// 함수 리터럴 블록으로 고차함수 호출하기
// 코드블록을 유틸리티로 감싸기 등에 유용

// ex1
def safeStringOp(s: String, f:String=>String) = {
    if (s != null) f(s) else s
}
def safeStringOp2(s: String)(f:String=>String) = {
    if (s != null) f(s) else s
}

val uuid = java.util.UUID.randomUUID.toString

val timedUUID = safeStringOp(uuid, { //2번째 인수인 f로, 함수리터럴 표현식을 보내자
    s =>
        val now = System.currentTimeMillis
        val timed = s.take(24) + now //take(i) : String의 앞 i 개 반환
        timed.toUpperCase
})

val timedUUID2 = safeStringOp2(uuid) {  //괄호를 분리한 버전이 더 깔끔하다
    s =>
        val now = System.currentTimeMillis
        val timed = s.take(24) + now
        timed.toUpperCase
}

println(uuid)
println(timedUUID)
println(timedUUID2)


// ex2
def timer[A](f : =>A): A = {
    def now = System.currentTimeMillis
    val start = now
    val a = f
    val end = now
    println(s"Exeuted in ${end-start} ms")
    a
}

val veryRandomAmount = timer {
    util.Random.setSeed(System.currentTimeMillis)
    for(i <- 1 to 100000) util.Random.nextDouble
    util.Random.nextDouble
}