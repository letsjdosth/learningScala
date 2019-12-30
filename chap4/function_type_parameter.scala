// type parameter
// 함수의 return값의 type을 선언시 고정시키지 않고,
// 함수 사용자에게 설정하도록 넘겨버릴 수 있음
// def <function identifier> [type] (<arg identifier> : <type>[,...]) : <type>...

//ex1 : identity function
def identity[A] (a : A) : A = a
val s : String = identity[String]("Hello")
println(s) // Hello
val i : Int = identity[Int](55)
println(i) // 55


// 사실 type을 직접 []로 전달하지 않고, 컴파일러가 타입추론을 이용해 알아서 돌리도록 만들 수 있음
val d : Double = identity(2.717)
println(d) // 2.727 (Double)
val d2 = identity(3.1415)
println(d2) // 3.1415 (Double)


// 주의: 가독성 있는 코드를 만드는 방식을 택할 것.
// 너무 유연하게 만들어버리면 코드 읽는 사람에게는 힘들 수 있음. 맥락상 유연할 필요가 없다면 type을 명시
// 경우에 따라 type의 엄격함과 유연함의 균형을 잡을 것