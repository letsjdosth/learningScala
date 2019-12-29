// Type
// fixed number
// Byte    1
// Short   2
// Int     4
// Long    8
// floting number
// Float   4
// Double  8
// 할당시, 바이트수 작은데서 큰데로는 할당가능
// 하지만, 반대로 큰 자료형을 작은데다 할당은 불가. (데이터 손실을 컴파일러차원에서 막음)

val byteVar : Byte = 10
val shortVar : Short = byteVar
val doubleVar : Double = shortVar
println(byteVar)
println(shortVar)
println(doubleVar)


// ~타입추론을 위한~
// 기본은 int(정수) / double(유리수). 필요시 d 붙여서 double임을 알릴 것. 10d
// long은 뒤에 접미사 10L <- 소문자 l은 deprecated됨.(1과 헷갈린다는 이유)
// float는 뒤에 접미사 10.0f
// 기타: 16진수 0x~ >> 기본은 Int 10진수로 변환

var whatVar0 = 10
val whatVar1 = 10.0
var whatVar2 = 10L
var whatVar3 = 10f
var whatvar4 = 10d
