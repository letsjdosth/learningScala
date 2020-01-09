// List, Set, Map : immutable, type-argumented collections
// 셋다 불변임!
// 연결 리스트로 구현되어있음

val numbers = List(32, 95, 24, 21, 17) //List[Int]
val colors = List("red", "green", "blue") //List[String]
println(s"I have ${colors.size} colors: $colors") //I have 3 colors: List(red, green, blue)

println(colors.head) //red //(맨 앞 요소)
println(colors.tail) //List(green, blue) //(맨 앞 제외 나머지 요소들)
println(colors(1)) //green //<- index는 0부터 시작. 일반 괄호()로 접근
println(colors(2)) //blue


// 중첩: 자유롭게 됨
val oddsAndEvents = List(List(1, 3, 5), List(2, 4, 6)) // List[[List[Int]]]
val keyValues = List(('A', 65), ('B', 66), ('C', 67)) // List[(Char,Int)]
println(oddsAndEvents)
println(keyValues)
println(oddsAndEvents(1)(2)) //6 (index 0부터)


// 순회 1
var total = 0
for (i <- numbers) {total += i}
println(total) //189

for (c <- colors) {println(c)}
// red
// green
// blue


// 순회 2 : isEmpty + head/tail 이용
val primes = List(2,3,5,7,11,13)
var i = primes
while (! i.isEmpty) {print(i.head + ", "); i=i.tail}
print("\n")


// 순회 3 : 재귀적으로 head/tail 이용
def visit(i: List[Int]) {
    if (i.size>0) {
    print(i.head + ", ")
    visit(i.tail)
    }
}
visit(primes)
print("\n")



// 고차함수 묶어쓰기
colors.foreach( (c: String)=>println(c) ) // foreach(f): 리스트에 각 항목에 대해 f(x)를 호출
val sizes = colors.map( (c: String)=> c.size) // map(f): 리스트 각 항목에 대해 f(x)를 적용해 반환
val total2 = numbers.reduce( (a:Int, b:Int)=> a+b ) // reduce : 리스트를 앞에서부터 순회하며 f(기존값,x) 연산
println(sizes) //List(3, 5, 4)
println(total2) //189