class User //defined class User
val u = new User //u: User = User@7d64a960 //<-@ 뒤는 JVM의 내부적 16진수 참조위치
val isAnyRef = u.isInstanceOf[AnyRef]
println(isAnyRef) //true

// 계층
// (jvm)java.lang.Object = (scala)Any > AnyRef > 사용자 class
// 2번째줄은 java.lang.Object.toString이 호출된 결과임


class User2 {
    val name : String = "Yubaba"
    def greet : String = s"Hello from $name"
    override def toString = s"User2($name)"
}
val u2 = new User2
println(u2.greet) //Hello from Yubaba


class User3(n:String) { //<-클래스 매개변수
    val name : String = n
    def greet : String = s"Hello from $name"
    override def toString = s"User2($name)"
}
val u3 = new User3("Zeniba")
println(u3.greet) //Hello from Zeniba
//주의: 클래스 매개변수는 인스턴스 생성 후에는 메소드 내부에서 사용할 수 없음. 오직 인스턴스 생성시 초기화용임


class User4(val name:String) { //<-여기서 val로 선언하면, 멤버가 된다
    def greet : String = s"Hello from $name"
    override def toString = s"User2($name)"
}
val users = List (new User4("Shoto"), new User4("Art3mis"), new User4("Aesch"))
val sizes = users map (_.name.size)
println(sizes) //List(5, 7, 5)
val sorted = users sortBy (_.name)
println(sorted) //List(User2(Aesch), User2(Art3mis), User2(Shoto))
val third = users find (_.name contains "3")
val greet = third map (_.greet) getOrElse "Hi" //getOrElse로 third가 비어있을 경우에도 안전하도록 함
println(greet) //Hello from Art3mis


// 상속
// 상속 예약어 (sibling) extends (parents)
// 자기 멤버 지칭: this.~
// 부모 멤버 지칭: super.~
// 메소드 오버라이드시 override def
class A {
    def hi = "Hello from A"
    override def toString = getClass.getName
}
class B extends A
class C extends B {
    override def hi = "hi C ->" + super.hi
}
val hiA = new A().hi
val hiB = new B().hi
val hiC = new C().hi
println(s"$hiA $hiB $hiC")
// Hello from A 
// Hello from A //<- A가 하드코딩되어있으므로
// hi C ->Hello from A

// 다형성 지원
val a1 : A = new A
val a2 : A = new B //특정 class로 선언된 변수에 그의 subclass 넣는것은 ok (B가 A의 아들이라 A이기도 함)
// val b1 : B = new A //error: type mismatch //<- 특정 class로 선언된 변수에 그의 superclass 넣는것은 안 됨
val b2 : B = new B
val listOfABC = List[A](new A, new B, new C) //<-컴파일러에 의해 타입추론되고, 자동으로 List[A]가 됨
println(listOfABC.map(_.hi)) //List(Hello from A, Hello from A, hi C ->Hello from A)
