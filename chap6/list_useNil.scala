// Nil
// 파이썬의 StopIteration처럼, 스칼라는 연결리스트의 마지막에서 Nil을 반환

// 참고: 빈 List는 Nil임
val l : List[Int] = List()
println( l == Nil ) //true
val m: List[String] = List("a")
println( m.tail == Nil ) //true


// 순회 4 : 스칼라에서 iterable은 모두 싱글톤 인스턴스 Nil (type : List[Nothing])을 반환하며 종료. 이를 이용
val primes = List(2,3,5,7,11,13)
var j = primes
while(j != Nil) {print(j.head + ", "); j = j.tail}
print("\n")


// Nil을 이용한 리스트 생성
// 연산자가 :로 끝나면 '오른쪽' 객체에서 연산자를 호출해 왼쪽과 동작시킴 (일반 연산자의 반대 연산순서가 됨)
// Nil엔 ::가 구현되어 있어서, 리스트 요소를 앞 방향으로 이어붙일 수 있음

val numbers = 1 :: 2 :: 3 :: Nil
println(numbers) //List(1, 2, 3)

// 실제 구현
val first = Nil.::(3)
println(first) //List(3)

val second = first.::(2)
println(second) //List(2, 3)

val result = second.::(1)
println(result) //List(1, 2, 3)