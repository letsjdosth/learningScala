// type

// class 명세 (trait에도 마찬가지로 동작. object는 안 됨)
// 1. 해당 class와 그 subclass들
// 2. 해당 class와 그 superclass들
// 3. 특정 메소드를 정의하는 모든 클래스


// 타입 alias(별칭)
// type <identifier(of alias)>[<type arg>] = <type name(original)>[<type arg>]
object TypeFun{
    type Whole = Int //<-Int의 별칭 Whole
    val x : Whole = 5

    type UserInfo = Tuple2[Int, String] //<-
    val u : UserInfo = new UserInfo(123, "George")

    type T3[A,B,C] = Tuple3[A, B, C] //<-
    val things = new T3(1, 'a', true)
}

val x = TypeFun.x
val u = TypeFun.u
val things = TypeFun.things
println(s"$x $u $things") //5 (123,George) (1,a,true)


// abstract type
// 인스턴스화 안 되는, 타입 별칭과 유사한 타입
// 1. 허용가능한 타입의 범위를 지정하는 타입 매개변수로써 사용
// 2. 추상클래스에서, 실제 구현 서브클래스가 구현해야 하는 타입을 선언하도록 사용

// ex1
class User(val name: String)
trait Factory{
    type A //<-추상 타입
    def create: A //<-반환값으로 A 타입을 강요
}
trait UserFactory extends Factory {
    type A = User //<-A에 구체적 타입 적용
    def create = new User("")
}
// ex2: 타입 매개변수를 이용한 구현
trait AnotherFactory[A]{ //<-A: 추상 타입
    def create: A
}
trait AnotherUserFactory extends AnotherFactory[User]{ //<- A에 User 적용
    def create = new User("")
}


// bounded type
// 특정 클래스 혹은 그의 서브타입 혹은 슈퍼타입으로 제한
// identifier <: upper bound: bound 해당 타입~해당타입의 자식 타입 어딘가 바운드
// identifier >: lower bound: bound 해당타입의 부모타입 어딘가 바운드~해당 타입
// ex1
class BaseUser(val name: String)
class Admin (name:String, val level:String) extends BaseUser(name)
class Customer(name:String) extends BaseUser(name)
class PreferredCustomer(name:String) extends Customer(name)
// BaseUser
// |       |
// Admin   Customer
//         |
//         PreferredCustomer

def check[A <: BaseUser](u:A) : Unit = { //A는 BaseUser 혹든 그 서브타입
    if (u.name.isEmpty) println("Fail!")
}
check(new Customer("Fred"))
check(new Admin("", "strict")) //Fail!

// 묵시적 전환 허용시, <: 대신 <% 사용. (view-bound라 부름)

// ex2
def recruit[A >: Customer](u: Customer) : A = u match { //A는 Customer 혹은 그 슈퍼타입
    case p : PreferredCustomer => new PreferredCustomer(u.name) 
        //(구현은 더 낮을수도 있다...)
    case c : Customer => new Customer(u.name)
}
val customer = recruit(new Customer("Fred"))
val preferred = recruit(new PreferredCustomer("George"))
println(preferred.getClass)

// ex3
// 추상타입 선언시 응용
abstract class Card {
    type UserType <: BaseUser //UserType는 BaseUser 혹든 그 서브타입
    def verify(u: UserType) : Boolean
}
class SecurityCard extends Card {
    type UserType = Admin // Admin의 별칭 UserType
    def verify(u: Admin) = true
}
val v1 = new SecurityCard().verify(new Admin("George","high"))
println(v1) // true

class GiftCard extends Card {
    type UserType = Customer // Customer의 별칭 UserType
    def verify(u: Customer) = true
}
val v2 = new GiftCard().verify(new Customer("Fred"))
println(v2) // true