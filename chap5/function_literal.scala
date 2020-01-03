// 함수 리터럴
// = 익명함수 (Anonymous function) or 람다 표현식 (lambda expression)
// 내부적으로는 $$Lambda$~/~@~

//선언 
// [<identifier> : <type>[,...]] => <expr>
// 그냥 매개변수화된 표현식임

// ex1
val doubler = (x: Int) => x*2
// 뒷부분만으로 함수 표현식이고, 이것이 doubler에 대입됨
println(doubler(22)) //44

// ex2
val greeter = (name: String) => s"Hello, $name"
val hi = greeter("World")
println(hi)

// ex3
def max(a : Int, b : Int) : Int = if (a>b) a else b
val maximize : (Int, Int) => Int = max
println(maximize(30,50)) //50
val maximize2 = (a : Int, b: Int) => if(a>b) a else b
println(maximize2(60,40)) //60

// ex4
def logStart() = "="*50 + "\nStarting NOW\n" + "="*50
val start = () => "="*50 + "\nStarting NOW\n" + "="*50
println(logStart())
println(start())


// ex5
def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
}
println(safeStringOp(null, (s:String) => s.reverse))
println(safeStringOp("Ready", (s:String) => s.reverse))
// 타입 추론 사용시 (어차피 f가 STring=>String인걸 컴파일러가 알고있음)
println(safeStringOp("Yes", s=>s.reverse))
