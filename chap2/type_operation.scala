// 모든 타입 공통 method

// <name>.getClass              : <name>의 타입 반환
// <name>.isInstanceOf[<type>]  : <name>이 <type>이면 true, 아니면 false
// <name>.asInstanceof[<type>]  : <name>을 <type>으로 캐스팅 (안쓰는것이 좋음. 타입이 호환 불가능 시 런타임 에러남)
// <name>.to<type>              : <name>을 <type>으로 캐스팅
// <name>.toString              : <name>을 String으로 캐스팅
// <name>.hashCode              : hash 리턴
//기타: jvm은 모든 클래스의 인스턴스가 toString과 hashCode를 구현하도록 강제

val five = 5.asInstanceOf[Long]
val isDouble = (7.0/5).getClass
val isFalse = (5.0).isInstanceOf[Float]
val isByte = (20.toByte).getClass
val isFloat = (47.toFloat).getClass

println(s"$five, $isDouble, $isFalse, $isByte, $isFloat")

val hashOfA = "A".hashCode
println(hashOfA) //65

val stringOfNum = (3.0/4.0).toString
println(stringOfNum) //0.75