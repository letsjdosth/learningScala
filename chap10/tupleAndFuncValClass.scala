// tuple 내부구현

val testTuple = (1, 'a', true)

// 실제로는 ()를 TupleX[Y]란 클래스에 매핑함
// TUpleX[Y]는 case class로 구현되어 있음
// X는 숫자(1~22). 멤버 수에 매칭
// Y는 타입 매개변수. 마찬가지로 멤버 수만큼 넘김
// 필드 _1, _2, ..., _X
// 부모로서 ProductX라는 trait를 가짐.
// trait 메소드: 멤버수를 반환하는 productArity, 접근 productElement 등 제공

val testTuple2 : (Int, Char, Boolean) = Tuple3(1, 'a', true)
println(testTuple2.productArity) //3



// function val 내부구현
// 마찬가지로 FunctionX[Y]로 매핑
// X는 매개변수 수(0~22, 23개까지 지원), Y는 (반환)타입 매개변수
// 함수를 값에 넣으면, 위 클래스로 매핑 후 apply()의 본체에 받은 함수 구현을 집어넣음
// 이후 jvm에 넘겨, java의 제약(모든 함수가 클래스메소드여야하는)을 만족시킴

val hello1 = (n:String) => s"Hello, $n"
val hi = hello1("Function Literals")

val hello2 = new Function1[String, String] {
    def apply(n: String) = s"Hello, $n"
}
println(s"hello1: $hello1, hello2=$hello2")
// hello1: Main$$anon$1$$Lambda$728/0x000000010057e840@bbd4791, hello2=<function1>

// Function1 트레이트는 특별히 두 메소드를 더 가지고 있음
// Function1간의 결합(합성, compose) 지원
// andThen: 왼->오
// compose: 오->왼
// 반환-입력 타입이 맞아야함

val doubler = (i: Int) => i*2
val plus3 = (i:Int) => i+3
val prepend = (doubler compose plus3)(1) //8 (1+3)+2 (오->왼)
val append = (doubler andThen plus3)(1) //5 1*2+3 (왼->오)
println(s"$prepend $append")
