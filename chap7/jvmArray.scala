// Array
// java 및 JVM 위 언어간 호환용
// 꼭 필요한것이 아닌이상 쓰지 말 것

// 처음 선언 후 크기(size)는 변경불가능하나, 값은 변경가능

val colors = Array("red","green","blue") //Array[3]으로 선언됨
colors(0) = "purple"
println(colors) //[Ljava.lang.String;@41a374be //<-안 읽힘(REPL에서 변수만 쓰면 읽히고, 바뀐걸 확인가능)


// scala> val colors = Array("red","green","blue")
// colors: Array[String] = Array(red, green, blue)

// scala> colors(0)
// res0: String = red

// scala> colors(0) = "purple"

// scala> colors
// res2: Array[String] = Array(purple, green, blue)