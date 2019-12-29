// tuple
// 기본 컨테이너. non iterable
// 타입 섞여도 괜찮음

// 생성법 1 : (값1, 값2[, ...])
// 파이썬과 같음
val info = (5, "Korben", true)
println(info)

// 생성법 2 : 화살표 연산자. 키-값 조합 만들 때
val red = "red" -> "0xff0000"
println(red)

//요소 접근 : <name>._i
println(s"${info._1}, ${info._2} , ${info._3}") //1부터 시작함 -_-;

val reversed = red._2 -> red._1
println(reversed)