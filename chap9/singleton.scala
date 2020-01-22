// singleton (object)
// 인스턴스가 오직 하나임을 보장
// jvm은, 해당 객체에 처음 접근할때가 되어서야 인스턴스화 (그전에는 인스턴스화 안 됨)

// 클래스 내의 static / global 멤버를 피할 수 있도록 함
// 전역멤버와 클래스멤버를 완전히 분리하는 설계를 지원

// 1. 특정 클래스를 전역으로 확장시 유용
// 2. 필드 없이 순수함수/외부입출력(I/O)작업 메소드로만 이루어진 클래스는 class대신 object 선언이 더 나음
// 3. 특정 class에 동반하여, class 보조역할로 쓸 수 있음(권한제어 / 진입통제 등)

// class 대신 object로 정의. 인스턴스 생성 및 접근시에는 new 필요없이 바로 접근
object Hello {
    println("in Hello")
    def hi = "hi"
}

println(Hello.hi) //<-new 없이 호출
// in Hello //<-인스턴스 생성 시점
// hi

println(Hello.hi)
// hi //<-in Hello가 출력되지 않음. 기존 인스턴스가 다시 불려왔음이 확인


// ex1
// 순수함수 유틸리티
object HtmlUtils {
    def removeMarkup(input: String) = {
        input
            .replaceAll("""</?\w[^>]*>""", "")
            .replaceAll("<.*>", "")
    }
}
val html = "<html><body><h1>Introduction</h1></body></html>"
val text = HtmlUtils.removeMarkup(html)
println(text) //Introduction

// ex2
// 동반 객체 companion object
// 특정 class와 동명인, 같은파일 내에서 정의된 object
// 스칼라 컴파일러상 동명 object는 class의 접근 제어 관점에서 동일단위 취급. 동시 컴파일함.
// 즉 서로의 private/protected 멤버에 접근가능

// apply()와 엮어, factory 패턴 구현에 사용
// ex2-1
class Multiplier(val x: Int){
    def product(y: Int) = x*y
}
object Multiplier{ //<-Multiplier class factory
    def apply(x: Int) = new Multiplier(x)
}
val tripler = Multiplier(3)
val result = tripler.product(13)
println(result) // 39

// ex2-2
object DBConnection { //<-DBConnection class factory (apply 볼 것)
    private val db_url = "jdbc://localhost"
    private val db_user = "franken"
    private val db_pass = "berry"

    def apply() = new DBConnection
}
class DBConnection {
    private val props = Map (
        "url" -> DBConnection.db_url, //<-동명 object의 private val에 접근
        "user" -> DBConnection.db_user,
        "pass" -> DBConnection.db_pass
    )
    println(s"Created new connection for " + props("url"))
}
val conn = DBConnection()
//Created new connection for jdbc://localhost