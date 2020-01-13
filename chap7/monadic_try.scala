// 예외처리
// 예외를 (단일요소) 컬렉션으로 돌려 처리함
// Success(~) or Failure(Exception)이 들어있는 컬렉션

// 던지기: throw
// throw new Exception("No DB connection, exiting...") // <-예외나므로 주석처리. test시 주석 해제
// java.lang.Exception: No DB connection, exiting... //<-JVM 레벨에서 예외 던짐

// ex1
def loopAndFail(end: Int, failAt: Int) : Int = {
    for (i<- 1 to end){
        println(s"$i)")
        if(i == failAt) throw new Exception("Too many iterations")
    }
    end
}
// loopAndFail(10,3) // <-예외나므로 주석처리. test시 주석 해제
// 1)
// 2)
// 3)
// java.lang.Exception: Too many iterations



// 예외처리
// 1. try-catch 블록 존재. catch 블록에서 case문 지원
// 2. util.Try 컬렉션 이용
val t1 = util.Try( loopAndFail(2,3) ) //<-함수호출 자체를 둘러싸자 (소괄호든 중괄호든)
val t2 = util.Try{ loopAndFail(4,2) }
println(t1) //Success(2) //<-무 예외시 Success()로 감싸 리턴됨
println(t2) //Failure(java.lang.Exception: Too many iterations) //<- 예외시 Failure()로 예외를 감싸 리턴됨


// ex2
def nextError = util.Try { 1/util.Random.nextInt(2) }
val x1 = nextError
println(x1)
// 값 꺼내기
val r0 = x1 flatMap {_ => x1} // Success인 경우 계속 util.Try (즉 Success(~))를 리턴. Failure인경우 꺼내서 예외를 리턴.
println("r0 : " + r0)
val r1 = x1 getOrElse 0 // Success인 경우 내장된값 반환. Failure일 시 뒤 매개변수 반환
println(r1)
val r2 = x1 foreach (x1 => println("Success! " + x1.toString)) //Success일땐 실행, Failure일땐 실행 안 함 
val r3 = x1 orElse x1 // Failure인경우 계속 util.Try (즉 Failure(~))를 리턴. Success인경우 꺼내서 리턴. (flatMap과 경우가 반대로 동작)
println(r3)
val r4 = x1.toOption // Option으로 전환. Success(~)는 Some(~)이 되지만, Failure일 시 예외정보는 잃어버리고 None이 되버림 (왜 쓰나?)
println(r4)
val r5 = x1 map (_*2) //Success일땐 실행(단 여전히 Success(~*2) 객체임), Failure일땐 실행 안 함(그냥 Failure 그대로 리턴)
println(r5)
val r6 = nextError //그대로 두기
println(r6)
// 상황에 맞게 적절히 전파 전달되어 처리되도록 하자


// ex3
val input = " 123 "
val result = util.Try(input.toInt) orElse util.Try (input.trim.toInt)
result foreach { r => println(s"Parsed '$input' to $r !")}
// Parsed ' 123 ' to 123 !
val x = result match {
    case util.Success(x) => Some(x)
    case util.Failure(ex) => {
        println(s"Couldn't parse input '$input'")
        None
    }
}
println(x)
// Some(123)
