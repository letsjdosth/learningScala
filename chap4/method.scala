// method
// class에서 정의된 함수
// 표준 호출 표기 (infix dot notation) : <class instance identifier>.<method identifier>[<args>]
// 연산자 오버로딩시 표기 (operator notation) : <class instance identifier> <연산자> <args>

// 참고: 모든 리터럴이 연산자가 될 수 있음. 따라서 모든 메소드는 .표기 대신 공백과 중위연산자 방식으로
//      instance명 method명 (arg1, arg2, ...)
// 로 호출 가능 (arg가 하나인경우 괄호 생략가능)
// 하지만 가독성이 보통은 후져지니(물론 좋아지는 경우도 있지만), 수학의 특정 연산자를 구현하는 것이 아니라면 이러지 말 것
// 또한, 직관에 맞지 않게 오버라이딩하지 말 것. (+를 엉뚱한 연산으로 바꿔버린다거나 하지 말 것)
// 결론: 가독성을 평가하며, 가독성이 개선되는 방식으로만 오버라이딩하자

val s = "vacation.jpg"
val isJPEG = s.endsWith(".jpg")
println(isJPEG) //true

val d = 65.642
println(d.round) //66
println(d.floor) //65.0
println(d.compare(18.0)) //1 (arg보다 d가 크면 1, 같으면 0, 작으면 -1. 일종의 sign 함수임)
println(d.+(2.721)) //68.363 (더하기. 실제로 이 함수로 +가 연산자 오버로딩 되어있음. d+2.721 과 동일)
println(d+2.721) //68.363
println(d compare 18.0) //1 (!!)

// 메소드 호출 시 이어서 호출 가능 (앞 메소드에서 같은 류의 객체가 리턴될 경우)
// 왼쪽부터 평가
println(d.+(2.723).+(3.5)) // 71.865
println(d + 2.723 + 3.5) // 71.865
