// 묵시적 매개변수

// 값, 변수, 함수 매개변수를 직접 명시하지 않아도 로컬에서 적절히 선택되어
// 함수 호출에 추가되어 실행되도록 하자
// 함수 선언시 자동으로 채워넣어질 변수에 키워드 implicit 추가하여 묵시적 매개변수임을 표시
// 값 선언시 implicit 추가하여 이 값이 자동으로 채워질 후보임을 표시

// 코드 가독성이 매우 많이 떨어짐. 로직이 뻔히 보일 때나 사용할 것

object Doubly {
    def print(num: Double)(implicit fmt: String) = { //<-namespace: Doubly
        println(fmt format num)
    }
}

// try 1
val fmt : String = "%.1f" //namespace : global
// Doubly.print(3.724)
// error: could not find implicit value for parameter fmt: String
// namespace가 다르면 자동으로 못 끼워넣는다

// try 2 : 명시적으로 전달시
Doubly.print(3.724)("%.1f") //3.7 //<-namespace: global
// 잘 동작

// try 3 : 묵시적으로 전달시
case class USD(amount: Double) {
    implicit val printFmt = "%.2f" //<- USD 안 implicit로 선언
    def print = Doubly.print(amount) //<- USD 안
}
new USD(81.924).print //81.92
//<-같은 namespace에서 implicit으로 선언된 String을 찾아 빈 implicit arg를 끼워넣는다

