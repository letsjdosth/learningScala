// 동기 처리
// 백그라운드 스레드 완료까지 main을 블록해야 하는 경우

// concurrent.Await.result()
// 주어진 기간동안 퓨처가 종료되야 함. 그럼 제대로 반환. 종료가 안 되면 java.util.concurrent.TimeoutException을 일으킴
import concurrent.ExecutionContext.Implicits.global
import concurrent.Future
import concurrent.duration._

val maxTime = Duration(10, SECONDS)

def nextFtr(i : Int = 0) = Future {
    def rand(x: Int) = util.Random.nextInt(x)
    
    Thread.sleep(500)
    if(rand(3) > 0) (i+1) else throw new Exception
}

val amount = concurrent.Await.result(nextFtr(5), maxTime)
println(amount) //6(성공시) 혹은 java.lang.Exception(실패시)(현재, 처리되지 않음)