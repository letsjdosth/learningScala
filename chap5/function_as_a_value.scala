// 함수 할당
// 할당시 타입? >>
// 입력 타입과 반환값 타입을 그룹하여 함수 타입으로 사용

// 구문
// ([<type>, ...]) => <type>
// 함수 시그니쳐에서 이름이 빠졌다고 생각
// 단일 매개변수 함수는 앞쪽 () 빼도 됨

//ex1
def double(x: Int) : Int = x*2
println(double(5)) //10

val myDouble : (Int) => Int = double // 변수 하나이므로 (Int) 대신 Int 가능
println(myDouble(5)) //10 (함수가 값 취급되고, 호출됨)

val myDoubleCopy = myDouble
println(myDoubleCopy(5)) //10


//ex2
// 함수 할당된 val 정의 2: 와일드카드 연산자 _를 뒤에
// _는 미래 함수 호출의 자리표시자 역할
val myDouble2 = double _ //double(_)의 준말인가봄(repl error 메시지)
// missing argument list for method double
// Unapplied methods are only converted to functions when a function type is expected.
// You can make this conversion explicit by writing `double _` or `double(_)` instead of `double`.
println(myDouble2(25))


//ex3
def max(a : Int, b : Int) = if(a>b) a else b
val maximize: (Int, Int) => Int = max
println(maximize(50, 30))

//ex4
def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50
val start : () => String = logStart
println(start())