// List, Set, Map : invariant, type-argumented collections

val numbers = List(32, 95, 24, 21, 17) //List[Int]
val colors = List("red", "green", "blue") //List[String]
println(s"I have ${colors.size} colors: $colors") //I have 3 colors: List(red, green, blue)

println(colors.head) //red
println(colors.tail) //List(green, blue)
println(colors(1)) //green //<- index는 0부터 시작. 일반 괄호()로 접근
println(colors(2)) //blue

// 순회
var total = 0
for (i <- numbers) {total += i}
println(total) //189

for (c <- colors) {println(c)}
// red
// green
// blue

