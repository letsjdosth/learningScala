// trait
// 다중상속 지원 클래스
// 인스턴스화 불가. 클래스 매개변수 불가
// java interface와 비슷하나... 흠...

// 메소드 관련 작업시 사용 편리
// trait <identifier> [extends <identifier>]{}

// ex1
trait HtmlUtils {
    def removeMarkup(input: String) = {
        input
            .replaceAll("""</?\w[^>]*>""", "")
            .replaceAll("<.*>", "")
    }
}

class Page(val s: String) extends HtmlUtils {
    def asPlainText = removeMarkup(s)
}

val result = new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText
println(result)


// ex2
// 다중상속
// 상속시 하나라면 extends, 그 이후는 with
// 클래스와 트레이트를 동시 상속시 무조건 extends에 클래스.

trait SafeStringUtils {
    def trimToNone(s: String) : Option[String] = {
        Option(s) map(_.trim) filterNot(_.isEmpty)
    }
}
class SafePage(val s: String) extends SafeStringUtils with HtmlUtils { //<-두 trait를 상속한다.
    def asPlainText : String = {
        trimToNone(s) map removeMarkup getOrElse "n/a"
    }
}

val safeResult1 = new SafePage("<html><body><h1>Introduction</h1></body></html>").asPlainText
val safeResult2 = new SafePage(" ").asPlainText
val safeResult3 = new SafePage(null).asPlainText
println(s"$safeResult1 \n$safeResult2 \n$safeResult3")
// Introduction
// n/a
// n/a


// ex3
// 다중상속2
// 여러 트레이트들 다중상속시 우선순위를 순서로 설정
// 컴파일시, 순서에따라 "좌->우->자신"으로 선형적으로, 수직적인 하나의 클래스로 재구성됨 ("선형화")
// (맨 왼쪽이 가장 부모방향에!)
// 이는 jvm이 다중상속을 허용하지 않기 때문임. scala 컴파일러의 꼼수
// 다중상속시 다른 트레이트와 겹치는 멤버 있을 시, 해당 멤버에 override 명시

trait Base {override def toString = "Base"}
class A extends Base {override def toString = "A->" + super.toString}
trait B extends Base {override def toString = "B->" + super.toString}
trait C extends Base {override def toString = "C->" + super.toString}
class D extends A with B with C {override def toString = "D->" + super.toString}
println(new D()) // D->C->B->A->Base //<- 


// ex4
// 클래스 약식 수정
class RGBColor(val color : Int) {
    def hex = f"$color%06X"
}
val green = new RGBColor(255<<8).hex

trait Opaque extends RGBColor {
    override def hex = {
        s"${super.hex}FF"
    }
}
trait Sheer extends RGBColor {
    override def hex = s"${super.hex}33"
}

class Paint(color : Int) extends RGBColor(color) with Opaque // RGBColor->Opaque->Paint
class Overray(color : Int) extends RGBColor(color) with Sheer // RGBColor->Opaque->Sheer
val red = new Paint(128 << 16).hex
val blue = new Overray(192).hex
println(s"green: $green, red: $red, blue: $blue")
// green: 00FF00, red: 800000FF, blue: 0000C033
