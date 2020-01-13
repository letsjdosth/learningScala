// Monadic collection
// 단일요소 컬렉션


// Option
// 크기가 1을 넘지 않는 컬렉션. 보통 단일값의 존재/부재 (결측, 누락값, 미초기화값, 계산불가능값 등) 나타냄

// Null보다 안전 (NullPointerException 가능성 감소)
// 연산체인 만들때 안전 (오직 유효값만 가지고 진행함을 보장)
// -> 타입 안전 보장

// 구현: Some(하나의 요소로 구성된, 타입-매개변수화된 컬렉션) + None(빈 컬렉션) 
// 둘 중 하나를 반환
// Option 자체가 컬렉션임. (단일값 들고있는)

var x : String = "Indeed"
var a = Option(x)

x = null
var b = Option(x)

// Some인지 None인지 확인 : isDefined, isEmpty
println(s"a is defined? ${a.isDefined}")
println(s"b is not defined? ${b.isEmpty}")
// a is defined? true
// b is not defined? true


// ex1 : 0으로 나누기 방지
// Option을 반환하는 함수를 만나면
// 이 함수의 반환값이 arg 넘기기에 따라 유효한 반환값이 아닐수도 있다고 읽어야 함. 즉 신중한 처리를 요구하는 것임.
// (걍 Null을 반환해버리는 것(=java 표준)보다 런타임에러에 안전함)
def divide (amt : Double, divisor : Double) : Option[Double] = {
    if (divisor==0) None
    else Option(amt / divisor)
}

val legit = divide(5,2)
val illegit = divide(3,0)
println(s"$legit $illegit") //Some(2.5) None

// ex2 : 빈 리스트의 head 부르기
// 빈 리스트에 head 부르면 바로 에러뱉음. 이에 대한 대안
val odds = List(1,3,5)
val firstOdd = odds.headOption
println(firstOdd) //Some(1)

val evens = odds filter (_%2==0)
val firstEven = evens.headOption //<-에러 안 나고 무사히 돌아감
println(firstEven) //None

// ex3 : find
// 매칭 실패시 에러뱉음. 이에 대한 대안
val words = List("risible", "scavenger", "gist")
val uppercase = words find (w => w==w.toUpperCase) //(find는 첫 매칭요소 하나만 찾는다)
val lowercase = words find (w => w==w.toLowerCase)
println(s"upper: $uppercase and lower: $lowercase") //upper: None and lower: Some(risible)

// ex4 : ex3에 이어서. 안전한 고차함수 사용
// Option이 컬렉션이기 때문에, 컬렉션 대상 고차함수가 다 적용됨
val filtered = lowercase filter (_ endsWith "ible") map (_.toUpperCase)
println(filtered) // Some(RISIBLE)
val exactSize = filtered filter (_.size > 15) map (_.size)
println(exactSize) //None



// Option에서 값 꺼내기
// 직접적으로는 Option.get()
// 하지만 이건, Option이 None일때 곧바로 에러남(no such element)
// <-에러에 안전하지 않음. 이거 쓰지 말자

// idea : 기본값 등이 있는 함수로 돌려서 꺼내자
def nextOption = if (util.Random.nextInt > 0) Some(1) else None
val ex1 = nextOption
val ex2 = nextOption
println(ex1, ex2)

println(nextOption.fold(-1)(x=>x)) // fold 이용: None이면 -1, 아니면 Some(x)의 x 반환
println(nextOption getOrElse 5) // getOrElse 이용 : None이면 5, 아니면 Some(x)의 x 반환
println(nextOption getOrElse {println("Error!"); -1}) //None이면 뒤 블록 실행
println(nextOption orElse nextOption) // orElse 이용: None이면 None 반환함 (흠)
val res = nextOption match { //match 표현식 이용
    case Some(x) => x
    case None => -1
}
println(res)