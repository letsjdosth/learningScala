// 추상클래스 abstract class

// 특정 핵심 필드와 메소드를, 실제 구현물을 구현하지 않으며 제공
// 상속시 자식 클래스가 다시 추상클래스가 아니라면 무조건 해당 실제 구현을 제공해야만 함

abstract class Car{
    val year : Int
    val automatic : Boolean = true
    def color : String
}

// new Car() // error: class Car is abstract; cannot be instantiated

class RedMini(val year: Int) extends Car {
    def color = "Red"
}

val m : Car = new RedMini(2005) 
//ok
//다형성을 이용해 부모 추상클래스로 인스턴스를 밀어 올릴 수 있다

class Mini (val year: Int, val color: String) extends Car 
//<-def color에 val color로 구현을 제공했다. 이래도 됨(어차피 함수가 일급)

val redMini : Car = new Mini(2005, "Red")
println(s"Got a ${redMini.color} Mini") //Got a Red Mini



// 익명 클래스(Anonymous class)를 이용한 구현
// 일회성 구현 필요시, 재사용 불가능하고 이름도 없는 익명 클래스로 추상클래스의 구현을 빠르게 만들 수 있음
// ex1
abstract class Listener {def trigger : Unit}

val myListener = new Listener { //<-인스턴스를 생성하며 구현하자
    def trigger : Unit = {
        println(s"Trigger at ${new java.util.Date}")
    }
}
myListener.trigger //Trigger at Thu Jan 16 02:50:09 KST 2020

//ex2 (등록 클래스)
class Listening {
    var listener : Listener = null
    def register(l: Listener) { listener = l }
    def sendNotification() {listener.trigger}
}

val notification = new Listening()
notification.register(new Listener {
    def trigger {println(s"Trigger at ${new java.util.Date}")}
}) //<-등록시 Listener 인스턴스를 생성하며 동시에 구현을 제공하자
notification.sendNotification //Trigger at Thu Jan 16 02:50:09 KST 2020