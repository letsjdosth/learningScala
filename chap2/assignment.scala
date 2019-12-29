// value assignment
// value == constant
// val <name> [: <type>] = <literal>
// 타입 생략시, 컴파일러가 타입 추론(type inference)

val x : Int = 5
println(x * 2)
println(x / 5)

val greeting : String = "Hello, world"
var atSymbol : Char = '@'
println(greeting)
println(atSymbol)


// variable assignment
// var <name> [: <type>] = <literal>
// 마찬가지로 type inference 가능

var a : Double = 2.72
println(a)

a = 355.0 / 113.0
println(a)


// 관례상, 기능상 괜찮다면 var대신 val을 더 선호
// 같은값 유지가 보증되기 때문 > 멀티스레딩 등에 안전

// 이름 관례
// 무조건 알파벳이나 유니코드로 시작이 강제됨
// 변수명에 연산자(!) 및 유니코드(특히 greek letter) 사용가능. 단 대괄호, 마침표 제외 (컴파일러에 의해 예약되어 있음)
// Java를 따라 camel case 사용
// 값과 변수는 소문자로, 클래스명은 대문자로 시작.
