// 비동기 처리
// 보통의 경우, 스레드 리턴값은 util.Try로 반환됨. 문제 없을 시 Success(return val), 예외시 Failure(Exception)
// 혹은, 각 스레드 작업 후 콜백을 호출하도록 콜백을 넘길 수 있음

import concurrent.ExecutionContext.Implicits.global
import concurrent.Future

def nextFtr(i : Int = 0) = Future {
    def rand(x: Int) = util.Random.nextInt(x)
    
    Thread.sleep(500)
    if(rand(3) > 0) (i+1) else throw new Exception
}

// 처리
val r1 = nextFtr(1) fallbackTo nextFtr(2) // 첫 퓨처가 성공하지 못하면 두번째 퓨처 호출하는 종합 퓨처 반환
Thread.sleep(1500)
println(r1) //Future(Success(2)) 또는 Future(Success(3)) 또는 Future(Failure(java.lang.Exception))

val r2 = nextFtr(1).flatMap(int => nextFtr()) // 첫 퓨처가 성공하면 그 값으로 두번재 퓨처 호출하는 종합 퓨처 반환
Thread.sleep(1500)
println(r2) //Future(Success(1)) 또는 Future(Failure(java.lang.Exception)) (매개변수 전달이 안 되어서 두번재 퓨처 arg i가 기본값으로 0이 적용됨)

val r3 = nextFtr(1) map (_*2) // 첫 퓨처가 성공하면 map 실행
Thread.sleep(1000)
println(r3) //Future(Success(4)) 또는 Future(Failure(java.lang.Exception))

//이건 좀 문제가있음
// val r4 = nextFtr(1) onComplete {_ getOrElse 0} //퓨처 완료되면 어쩄든 util.Try를 이용해 다음 함수 호출
// Thread.sleep(1000)
// println(r4)

val r5 = concurrent.Future sequence List(nextFtr(1), nextFtr(5))
Thread.sleep(1000)
println(r5) //Future(Success(List(2, 6))) 혹은 Future(Failure(java.lang.Exception))