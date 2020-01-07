// placeholder를 이용해 함수 리터럴 구문을 축약하자
// > 명시적 타입이 리터럴 외부에 지정되어있고, 매개변수가 한번 이상 사용되지 않는 경우

val doubler : Int => Int = _ * 2 // 매개변수를 따로 선언하는 대신, 그냥 _로 받는다
println(doubler(5))

def safeStringOp(s: String, f: String => String) = {
    if(s!=null) f(s) else s
}
println(safeStringOp(null, _.reverse)) //(s:String) => s.reverse)가 단순화됨
println(safeStringOp("Ready", _.reverse))



// 여러 개의 _ 사용하기
def combination(x:Int, y:Int, f:(Int,Int) => Int) = f(2+x,y)
println(combination(1, 10, _*_)) //30 (차례대로 x, y로 대체된다)
println(combination(10, 1, _*_)) //12

def tripleOp(a: Int, b:Int, c:Int, f:(Int,Int,Int)=>Int) = f(a,b,c)
println(tripleOp(23,92,14, _ * _ + _)) //2130. 역시 차례대로 들어간다

def uniTripleOp[A,B](a:A, b:A, c:A, f:(A,A,A)=>B) = f(a,b,c)
println(uniTripleOp[Int,Int](23,92,14, _*_+_)) //2130
println(uniTripleOp[Int,Double](23,92,14, 1.0*_/_/_)) //0.017857142857142856
println(uniTripleOp[Int,Boolean](93,92,14, _>_+_)) //false