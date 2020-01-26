// trait의 다른 사용법: 인스턴스화될 때 클래스에 트레이트 추가
// new <class name> with <trait name>
// 해당 클래스를 해당 트레이트에 의해 확장된 버전의 인스턴스를 찍어냄

class A
trait B {self: A=>}
val a = new A with B //A->B 인, 어떤 익명클래스의 인스턴스를 만든것임

// 종속성 주입 ("dependency injection")의 예임
// (클래스에도 추가되지 않다가, 인스턴스화될 때에나 특징이 주입됨)


// ex1
class User (val name : String) {
    def suffix = ""
    override def toString = s"$name$suffix"
}

trait Attorney {self: User => 
    override def suffix = ", esq."
}
trait Wizard {self: User => 
    override def suffix =", Wizard"
}
trait Reverser {
    override def toString = super.toString.reverse
}

val h = new User("Harry P") with Wizard // User->Wizard
println(h) //Harry P, Wizard
val g = new User("Ginny W") with Attorney // User->Attorney
println(g) //Ginny W, esq.
val l = new User("Luna L") with Wizard with Reverser // User->Wizard->Reverser
println(l) //draziW ,L anuL