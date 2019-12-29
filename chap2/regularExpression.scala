// Regular expression
// from java.util.regex.Pattern
// 위 java doc 보며 할 것

//자주쓰는 연산
// matches : 전체 문자열과 맞으면 true 리턴
// replaceAll
// replaceFirst

// 캡처 후 Regex instance 리턴
// 캡처 구문
// val <정규 표현식>(<(캡쳐그룹이 리턴될)식별자>) <정규식을 적용할 문자열>

val input = "Enjoying this apple 3.14159 times today"
val pattern = """.* apple ([\d.]+) times .*""".r //string의 .r로 string을 정규표현식 타입으로 전환
    // pattern: scala.util.matching.Regex = .* apple ([\d.]+) times .
val pattern(amountText) = input //<<< capture. amountText 자리는 위에서 할당되지 않은 완전 새로운 이름이어야 함.
val amount = amountText.toDouble
println(amount) //3.14159

