// match 표현식을 컬렉션에도 사용가능

val statuses = List(500, 404)

// 한 값에 대해서는 기존 match 그대로 사용가능
val msg0 = statuses.head match {
    case x if x<500 => "okay"
    case _ => "whoah, an error"
}
println(msg0) // whoah, an error

// 통째로 받을 수 있음
val msg1 = statuses match {
    case x if x contains(500) => "has error"
    case _ => "okay"
}
println(msg1) //has error

// 요소값 바인딩도 가능
val msg2 = statuses match {
    case List(500, x) => s"Error followed by $x"
    case List(e, x) => s"$e was followed by $x"
}
println(msg2) //Error followed by 404


// List match식에 a::b로 case를 받으면 a는 head, b는 tail에 매칭됨. (즉, 첫요소와 나머지로 매칭)
val head = List('r','g','b') match {
    case x :: xs => x
    case Nil => ' '
}
println(head) // 'r'

val tail = List('r','g','b') match {
    case x :: xs => xs
    case Nil => ' '
}
println(tail) // List(g, b)


// 참고로 tuple도 match 사용가능
val code = ('h', 204, true) match {
    case (_, _, false) => 501
    case ('c', _, true) => 302
    case ('h', x, true) => x
    case (c, x, true) => {
        println(s"Did not expect code $c")
        x
    }
}
print(code) //204