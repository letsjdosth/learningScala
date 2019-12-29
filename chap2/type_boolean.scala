// Boolean
// 1,0 캐스팅 없음에 주의. 무조건 true/false 명시적으로 넣어줘야함
val isTrue : Boolean = true
val isFalse : Boolean = !true
println(isTrue)
println(isFalse)

val zero : Int = 0
val isValid = (1 == true)
val isValid2 = (zero > 0)
println("*Validity print")
println(isValid) // False !!!!!! no casting. 경고도 출력됨.
// warning: comparing values of types Int and Boolean using `==` will always yield false : val isValid = (zero == true)
println(isValid2) // <-대체방식으로, >0 과 비교하자



val unequal = (5 != 6)
val isLess = (5 < 6)
val unequalAndLess = unequal & isLess //&은 모든 요소를 끝까지 평가
val definitelyFalse = false && unequal //&&은 앞에서부터 평가. 결과 확정시 뒤 평가하지 않고 바로 리턴
println("*operation test print")
println(s"$unequal $isLess $unequalAndLess $definitelyFalse")
