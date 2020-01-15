// 1. overloaded method
// 메소드 오버로딩
// 가능 (이름과 매개변수가 완전히 같은 두 메소드를 정의하지만 않는다면)
class Printer (msg: String) {
    def print(s: String) : Unit = println(s"$msg: $s")
    def print(l: Seq[String]) : Unit = {
        print(l.mkString(",")) //위 String버전 print가 호출된다
    }
}
new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil) //Today's Report: Foggy,Rainy,Hot


// 2. apply method
// 기본 메소드 / 인젝터 메소드. 메소드 이름 없이 호출되는 메소드
// python의 __call__처럼, 걍 인스턴스를 함수로 쓸 수 있게 해줌
// (단, 이게 이상해보이지 않을 곳에만 사용할 것. 연산자 오버라이드처럼, 코드 읽기의 직관성을 해칠 우려 있음)
class Multiplier(factor: Int) {
    def apply(input: Int) = input * factor
}
val tripleMe = new Multiplier(3)
val tripled = tripleMe.apply(10)
val tripled2 = tripleMe(10) // <-없어도 apply가 돌아간다
println(s"$tripled $tripled2") // 30 30

val l = List('a','b','c')
val charactor = l(1) //<-내부적으로는 apply로 구현되어있음
println(charactor) //b


// 3. lazy val
// 인스턴트 생성시 함께 생성되는 값이 아닌, 최초로 자기가 직접 호출될때 생성되는 클래스 필드의 값
// 일종의 캐시에 저장된 함수 결과라고 생각.
// val 앞에 lazy 키워드로 선언
// 사용: 
// 1 성능과 시간에 민감한 연산이 오직 한번만 실행될 것을 보장해야 할 시
// 2. 아예 접근할 필요가 없을 가능성도 있는 경우
// 예: 파일 기반 속성/ db 커넥션/ 오직 한번만 초기화될 불변 데이터 등
class RandomPoint {
    val x = { println("creating x"); util.Random.nextInt }
    lazy val y = { println("now y"); util.Random.nextInt }
}
val rp = new RandomPoint()
println("~~")
println(s"Location is ${rp.x}, ${rp.y}") //<-여기에 가서 y가 만들어져 고정된다.
println(s"Location is ${rp.x}, ${rp.y}")
// creating x
// ~~
// now y
// Location is 1394614391, 1163341495
// Location is 1394614391, 1163341495

