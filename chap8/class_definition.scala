// define class


//1
// class <this class identifier> [extends <superclass identifier>][{field, method, class}]
// 기타: 중첩 클래스를 만들 수 있음. 중첩된 내부클래스에서 외부 클래스 필드 접근가능.
// 표현식/함수/클래스가 모두 중첩되므로, (필요시) 충격적인 코드가 가능 (음....)

// 인스턴스 생성시 new <class identifier>()
// 괄호는 있어도 되고 없어도 됨


//2
// class 파라메터 사용시
// class <identifier> ([val|var] <identifier> : <type>[,...])[extends <superclass identifier>][{field, method, class}]
// 클래스 파라메터가 자동으로 클래스 필드의 변수/상수가 됨. 고칠수는 없음
class Car(val make : String, var reserved : Boolean) {
    def reserve(r:Boolean) : Unit = {reserved = r}
}
val t1 = new Car ("Toyota", false)
t1.reserve(true)
println(s"My ${t1.make} is now reserved? ${t1.reserved}") //My Toyota is now reserved? true

val t2 = new Car(reserved = false, make="Tesla") //클래스 arg 키워드로 넘기기 가능
println(t2.make) //Tesla

class Lotus (val color : String, reserved : Boolean) extends Car("Lotus", reserved) //뒤 reserved는 앞 reserved를 받는다.
val l1 = new Lotus("Silver", false) //Requested a Silver Lotus
println(s"Requested a ${l1.color} ${l1.make}")


//3
// 클래스 매개변수에 기본값(디폴트값)도 지정하여 사용가능
// class <identifier> ([val|var] <identifier> : <type> = <default expr> [,...])[extends <superclass identifier>][{field, method, class}]
class Car2 (val make: String, val reserved : Boolean = true, val year : Int = 2020) {
    override def toString = s"$year $make, reserved = $reserved"
}
val c1 = new Car2("Acura")
val c2 = new Car2("Lexus", year=2010)
val c3 = new Car2(reserved = false, make="Porsche")
println(c1) //2020 Acura, reserved = true
println(c2) //2010 Lexus, reserved = true
println(c3) //2020 Porsche, reserved = false

//4
// 타입 매개변수도 사용가능
// class <identifier> [type parameter]  ([val|var] <identifier> : <type> = <default expr> [,...])[extends <superclass identifier>][{field, method, class}]
class Singular[A](element: A) extends Iterable[A] { 
    //참고: Traversable(오직 foreach만 구현하면 되는 프로토콜)이 2.13에 들어오며 사장됨. Iterable(foreach, iterator 구현하는 프로토콜)로 동작
    override def foreach[B](f: A=>B) = f(element)
    override def iterator: Iterator[A] = {
        val elemIter = List(element)
        elemIter.iterator
    }
}
val p = new Singular("Planes")
p foreach println //Planes
val pName : String = p.head //<-Iterable의 두 메소드를 구현하면 자동으로 구현됨
println(pName) //Planes