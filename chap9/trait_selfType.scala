// trait annotation
// self type : 클래스가 추가될 때 특정 타입 또는 해당 서브타입과만 사용되어야 함을 명시
// 이 경우, 완전 다른 클래스에는 with로 해당 trait를 섞을 수 없음

// 용도: 입력 매개변수가 필요한 클래스에 트레이트로 기능 추가
// (트레이트가 입력 매개변수를 받지 못하므로, 매개변수 있는 클래스를 트레이트로 그냥 바로 확장시 매우 어려움)

// trait ... {
//     <identifier>: <type> => ...
// }

// 관례적으로 identifier 이름을 self로 씀. 읽기쉬운 코드를 위해 맞춰 쓸 것


// ex1
trait A {
    def hi = "hi"
}
trait B { self: A => // B는 A에서 상속될때만!
    override def toString = "B : " + hi
}
// class C extends B 
// C:\gitproject\learningScala\chap9\trait_selfType.scala:20: error: illegal inheritance;
//  self-type C does not conform to B's selftype B with A
// A에서 상속될때만 가능

class C extends A with B //A->B->C
println(new C) //B : hi


// ex2
// 매개변수가 있는 경우
class TestSuite(suiteName : String) {
    def start() {}
}
trait RandomSeeded {
    self: TestSuite => // TestSuite에서 상속받은 클래스에서만 사용할 수 있도록 제약
    def randomStart() = {
        util.Random.setSeed(System.currentTimeMillis)
        self.start()
    }
}
class IdSpec extends TestSuite("ID Tests") with RandomSeeded { // TEstSuite->RandomSeeded->IdSpec
    def testId() = {
        println(util.Random.nextInt != 1)
    }
    override def start() {
        testId()
    }
    println("Starting...")
    randomStart()
}

new IdSpec
// Starting...
// true