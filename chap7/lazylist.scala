// Stream
// 요소 접근시 컬렉션에 추가하는 무한(혹은 유한번째에서 종료가능) 컬렉션
// 재귀적으로 정의

// deprecated됨(2.13.0)
// chap7\stream.scala:6: warning: type Stream in package scala is deprecated (since 2.13.0): Use LazyList instead of Stream
// def inc(i: Int) : Stream[Int] = Stream.cons(i, inc(i+1))
//                   ^
// chap7\stream.scala:6: warning: value Stream in package scala is deprecated (since 2.13.0): Use LazyList instead of Stream
// def inc(i: Int) : Stream[Int] = Stream.cons(i, inc(i+1))
//                                 ^
// Stream(1, <not computed>)

// iterator 같은거라고 생각

def inc(i: Int) : LazyList[Int] = LazyList.cons(i, inc(i+1)) //.cons 다음 (head, tail) 요소로 선언
val s= inc(1)
println(s) //LazyList(<not computed>)

s.take(5).toList
println(s) // LazyList(1, 2, 3, 4, 5, <not computed>)
println(s.take(5).toList) //List(1, 2, 3, 4, 5)


// cons 대신 #:: 사용가능 . list :: 로 이어붙이듯, 생성연산자처럼 쓸수있음. head #:: tail 로 선언
def inc2(head: Int) : LazyList[Int] = head #:: inc2(head+1)
println(inc(10).take(10).toList) //List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)



// 유한 LazyList: List가 Nil 쓰듯 여긴 LazyList.empty를 넘기자.
def to(head: Char, end:Char) : LazyList[Char] = (head > end) match {
    case true => LazyList.empty
    case false => head #:: to((head+1).toChar, end)
}
val hexChars = to('A','F').take(20).toList
println(hexChars) //List(A, B, C, D, E, F)