// type variance
// 타입 매개변수의 타입은 불변이며, 정확히 매개변수화된 그 타입만을 받음
// 때문에 타입 매개변수가 설정되었을 경우
// 그 타입의 서브타입 또한 뱉어버림
// ->다형성을 원하는 정도로 구현하기 위해, 타입 매개변수를 변화하도록(variant) 설정해야 함

// ex1
class Car {
    override def toString = "Car()"
}
class Volvo extends Car {
    override def toString = "Volvo()"
}

val c : Car = new Volvo() //ok. 일반적으로는 자바와 같은 다형성이 지원됨. 자기 자식 클래스는 자기타입이기도 함.(반대는 x)


// ex2
case class Item[A](a:A) {
    def get: A = a
}

// val i : Item[Car] = new Item[Volvo](new Volvo) //<-이건 안됨. 타입매개변수에서는 타입자체가 호환이 되든말든 뱉음
// error: type mismatch;
//  found   : this.Item[this.Volvo]
//  required: this.Item[this.Car]
// Note: this.Volvo <: this.Car, but class Item is invariant in type A.
// You may wish to define A as +A instead. (SLS 4.5)


// ex3
// covariant type arg (공변 타입 매개변수)
case class Item2[+A](a: A){ //<-type arg 앞에 +를 붙이면, 
    def get : A = a
}
val i2 : Item2[Car] = new Item2[Volvo](new Volvo) //<-문제없다. (<- +A: A나 그의 서브타입)
val auto = i2.get
println(auto) //Volvo()


// ex4
// class 내의 메소드는 공변 타입 매개변수를 사용할 수 없음

// class Check[+A] {
//     def check(a: A) = {}
// }
// error: covariant type A occurs in contravariant position in type A of value a

// 실제로 이건 반대방향 변환임. 슈퍼타입이 서브타입으로 변해야 함.
// 거꾸로 -A를 붙여 이를 허용하자
// contra-variance type arg (반-공변타입 매개변수)
class Check[-A] { ////<-type arg 앞에 +를 붙이면, 
    def check(a: A) = {} ////<-문제없다. (<- -A: A나 그의 슈퍼타입)
}
// 주의: 반공변타입 매개변수는 리턴타입으로 사용 불가


// ex5
// 3중 구조 테스트. Car :> Volvo :> VolvoWagon
class VolvoWagon extends Volvo
class Item5[+A](a:A) { //서브클래스도 A로 바꿀 수 있다
    def get: A = a
}
class Check5[-A]{ //슈퍼클래스도 A로 바꿀 수 있다
    def check(a:A) = {}
}
def item5(v: Item5[Volvo]){val c: Car = v.get}
def check5(v: Check5[Volvo]){v.check(new VolvoWagon())}

// item5(new Item[Car](new Car()))
    // error: type mismatch;
    //  found   : this.Item[this.Car]
    //  required: this.Item[this.Volvo]
    // Note: this.Car >: this.Volvo, but class Item is invariant in type A.
    // You may wish to define A as -A instead. (SLS 4.5)

item5(new Item5[Volvo](new Volvo)) // ok
item5(new Item5[VolvoWagon](new VolvoWagon)) //ok (서브클래스가 들어와도 ok)

check5(new Check5[Car]()) //ok (슈퍼클래스가 들어와도 ok)
check5(new Check5[Volvo]()) //ok
// check5(new Check5[VolvoWagon]()) //error
    // error: type mismatch;
    // found   : this.Check5[this.VolvoWagon]
    // required: this.Check5[this.Volvo]

// 필요시에만 +,-를 추가할것
// 변화하는 타입 매개변수보다는 불변 타입 매개변수가 안전함