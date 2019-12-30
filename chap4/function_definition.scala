// 함수
// def <identifier:function name>(<identifier:arg name> : <type> [,...])[: <return type>] = <return expr>
// return expr의 wrapper. 등호가 있음에 주의
// return expr의 마지막줄이 자동으로 리턴됨
// (필요시, 중간에서도 명시적으로 return 명령으로 리턴가능)

def hi = "hi"
hi //호출된다
// hi() //<-이건 안된다. 괄호 없이 선언된 함수는 호출시에도 괄호 없이 호출해야한다.

def hi2() : String = "hi"
hi2 //호출된다
hi2() //호출된다. 받는 인자가 없어도 정의에 ()를 넣고, 호출시에도 ()를 붙이면, 더 읽기 쉬운 코드가 된다.
// 관례 : 부작용(즉, 외부로부터 영향을 받거나 외부에 영향을 주는(콘솔 출력 포함))이 있는 함수는 괄호를 무조건 붙인다.

def multiplier(x : Int, y : Int) : Int = {x * y}
val returnMultiplier = multiplier(6,7)
println(returnMultiplier) //42

def safeTrim(s : String) : String = {
    if (s==null) return null //return 사용 예
    s.trim() //if문에 안 걸리면, 이 값이 리턴된다.
}



// 프로시저 (Procedure)
// return 없는 함수
// void의 scala 버전인 Unit을 리턴하여, 의미있는 반환값이 없다는 것을 알리자
// (없어도, 보통은 스칼라 컴파일러가 알아서 타입추론하여 Unit을 반환함)
def log(d : Double) : Unit = println(f"Got value $d%.2f")
log(2.23535) //콘솔 출력: Got value 2.24



// 단일 매개변수를 가지는 함수 호출 시 {}를 이용해 표현식 블록을 넘겨도 됨.
// <function identifier> <expr(block)>
// (약간 가독성을 해치긴 함. 너무 해치지 않는 선에서만 쓰자.)
def formatEuro(amount : Double) : String = f"€$amount%.2f"
val euro1 = formatEuro(3.4645)
val euro2 = formatEuro { 
    val rate=1.32
    0.235 + 0.7123 + rate *5.32
    }
println(euro1) //€3.46
println(euro2) //€7.97



// 중첩 함수(nested function)
// 가능함. 단 local에서만 사용가능
def max(a:Int, b:Int, c:Int) : Int = {
    def max(x:Int, y:Int) = if (x>y) x else y
    max(a, max(b,c)) 
    // java처럼, overload가 되어 (혹은 함수 자체가 이름+매개변수 조합으로 식별된다고 생각해도 됨), 변수가 2개인 max를 동작시킨다
    // 또한, scala compiler의 이름 탐색 순서로도, local부터 탐색하므로, 안의 변수 2개 max를 동작시킨다.
    // 따라서 위 경우에는 재귀가 아님!
}
println(max(42,181,19)) //181



// 키워드 매개변수로 함수 호출
// 가능함. 순서대로 넘겨도 되고, 키워드를 명시해 넘겨도 됨
def greet(prefix : String, name: String) : String = s"$prefix $name"
val greeting1 = greet("Ms", "Brown")
val greeting2 = greet(name="Brown", prefix="Mr")
println(greeting1) //Ms Brown
println(greeting2) //Mr Brown



// default값이 있는 매개변수
// def <identifier> (<identifier> : <type> = <default value>) : <type>
def greet2(prefix : String = "", name : String) : String = s"$prefix $name"
val greeting3 = greet2(name="Paul")
println(greeting3)

//보통은 키워드명을 쓰기 귀찮으므로, 함수를 쓰기 편하게, 디폴트값이 있으면 arg 순서를 뒤로 밀어버리는게 낫다
def greet3(name : String, prefix : String = "") : String = s"$prefix $name"
val greeting4 = greet3("Ola")
println(greeting4)



// 가변인수 vararg
// 정해지지 않은 개수의 arg를 받는 경우.
// 변수 type 뒤에 *를 붙이자
// 주의: 가변인수는 불변인수 앞에 못 온다. 무조건 순서를 뒤로 보내자
def sum (items : Int*) : Int = {
    var total = 0
    for (i <- items) total += i //<-iterable로 들어옴
    total
}
println(sum(10,20,30)) //60
println(sum()) //0



// 매개변수 그룹화
// 괄호를 여러개 써서 매개변수를 받을 수 있다
def max2(x:Int)(y:Int) = if (x>y) x else y
val larger = max2(20)(30) //<-호출시에 괄호로 각각 묶어서 연달아 넘겨주자
println(larger) //30
//추후 함수 리터럴과 함께 고차함수를 사용할 때 유용