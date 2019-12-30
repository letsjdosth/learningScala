// 재료: Range
// <start int> [to|until] <end int> [by increment]

// for comprehension
// for (<identifier> <- <iterator>) [yield] [<expr>]
// 자체가 expression이므로 일종의 map()임

// ex1
for (x <- 1 to 7) {println(s"Day $x:")}

// ex2 : collection으로 받기
// for 문에 yield를 섞으면 자체가 반환값이 있는 expr가 된다
val dayCollect = for (x <- 1 to 7) yield {s"Day $x:"}
println(dayCollect) //Vector(Day 1:, Day 2:, Day 3:, Day 4:, Day 5:, Day 6:, Day 7:)
//계층구조 참고: IndexedSeq <- Vector
//REPL 출력 : dayCollect: IndexedSeq[String] = Vector(Day 1:, Day 2:, Day 3:, Day 4:, Day 5:, Day 6:, Day 7:)

// ex3 : iterable 객체 순회
val dayCollectSemicol = for (day <- dayCollect) yield day + ", " //한줄이면 중괄호 없어도 됨
println(dayCollectSemicol) //Vector(Day 1:, , Day 2:, , Day 3:, , Day 4:, , Day 5:, , Day 6:, , Day 7:, )
for (day <- dayCollectSemicol) print(day) //Day 1:, Day 2:, Day 3:, Day 4:, Day 5:, Day 6:, Day 7:,
print("\n")



// iterator guard
// for (<identifier> <- <iterator> if <boolean expression>) [yield] [<expr>]
// for에 if를 섞어쓰자

// ex4
val threes = for (i<-1 to 20 if i%3 == 0) yield i
println(threes) //Vector(3, 6, 9, 12, 15, 18)

// ex5
val quote = "Faith,Hope,,Charity"
for {
    t <- quote.split(",") // (Faith, Hope, , Charity)가 순회된다
    if t != null
    if t.size > 0
}{
    println(t)
}
// Faith
// Hope
// Charity



// nested iterator
// for문을 중첩으로 직접 안 써도 중첩하여 돌릴 수 있음
for {
    x <- 1 to 2
    y <- 1 to 3
}{
    print(s"($x, $y) ")
}
print("\n") //(1, 1) (1, 2) (1, 3) (2, 1) (2, 2) (2, 3)



// value binding
// for loop 내 local 임시변수를 미리 선언하고 시작할 수 있음
// for (<identifier> <- <iterator>; <identifier>=<expr>) ...
val powerOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow
println(powerOf2) // Vector(1, 2, 4, 8, 16, 32, 64, 128, 256)




// while, do while
// 이건 표현식이 아님.
// 스칼라에서는 많이 쓰지 않음
// 필요하더라도 다른 더 나은 방식이 존재
var x = 10
while (x>0){
    println(x)
    x -= 1
}

x = 0
do{
    println(s"Here I am, x = $x")
} while (x>0)