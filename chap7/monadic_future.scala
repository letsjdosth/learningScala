// concurrent.Future
// 스레딩시 각 스레드의 반환값을 위한 모나딕 컨테이너 + 백그라운드 스레드 모니터 역할

import concurrent.ExecutionContext.Implicits.global
val f = concurrent.Future { Thread.sleep(500); println("hi") } //<-바로 타 스레드에 {} 안이 던져짐
println(f)
println("waiting")
Thread.sleep(1000)
// Future(<not completed>)
// waiting 
// hi

