// 자료구조 Map
// python dict. hashmap
// key-value 쌍으로 저장
// 생성시 -> 연산자 사용 혹은 2개짜리 tuple로 선언

val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
println(colorMap) // Map(red -> 16711680, green -> 65280, blue -> 255)
val readRGB = colorMap("red") //접근은 괄호로
val cyanRGB = colorMap("green") | colorMap("blue")
println(readRGB) //16711680
println(cyanRGB) //65535

val hasWhite = colorMap.contains("white")
println(hasWhite) //false

for (pairs <- colorMap) {println(pairs)}
// (red,16711680)
// (green,65280)
// (blue,255)



// 자료구조 Set
// 무순서. 불변. 유일성 보장
val unique = Set(10, 20, 30, 20, 20, 10)
println(unique) // Set(10, 20, 30)
val sum = unique.reduce((a:Int, b:Int)=> a+b)
println(sum) // 60