// 1

val max2 : (Int, Int) => Int = (a,b) => if (a>b) a else b
def highFunc3 (a: (Int,Int,Int), f: (Int,Int)=>Int) = {
    f(f(a._1,a._2),a._3)
}
val testTuple = (1,6,4)
println(highFunc3(testTuple, max2))


// 2
val randInt = util.Random.nextInt _
val testTuple2 = (randInt(), randInt(), randInt(), 2, 5)
println(testTuple2)
def highFunc5 (a: (Int,Int,Int,Int,Int), f: (Int,Int)=>Int) = {
    f(f(f(f(a._1,a._2),a._3),a._4),a._5)
}
val min2 : (Int, Int) => Int = (a,b) => if (a>b) b else a
val second2 : (Int, Int) => Int = (a,b) => b
println(highFunc5(testTuple2, max2))
println(highFunc5(testTuple2, min2))
println(highFunc5(testTuple2, second2))


// 3
def factoryOfProd (x : Int) : Int=>Int = {
    val returnFunc : Int => Int = a => a*x
    returnFunc
}
val prod3 = factoryOfProd(3)
println(prod3(2))
println(prod3(6))


// 4
// x, f를 받아 f(x)를 수행후 그냥 다시 x를 리턴
// f(x)가 외부상태만을 바꾸는 일이라면 (db를 쓴다거나, 화면출력이라거나) 이런 함수가 의미있을 수 있음


// 5
val sq : Double => Double = a => a*a
println(sq(2.5))


// 6
def conditional[A] (x: A, p: A => Boolean, f: A=>A): A = {
    if (p(x)) f(x) else x    
}

// 7
def conditional2[A] (x: A, p: A => Boolean, f: A=>String): String = {
    if (p(x)) f(x) else x.toString
}

for (x <- 1 to 100){
    val result15 = conditional2[Int](x, {y => if (y%15==0) true else false}, {y => "typesafe"})
    if (result15=="typesafe") {println(result15)}
    else {
        val result3 = conditional2[Int](x, {y => if (y%3==0) true else false}, {y => "type"})
        if (result3=="type") {println(result3)}
        else {
            val result5 = conditional2[Int](x, {y => if (y%5==0) true else false}, {y => "safe"})
            println(result5)
        }
    }
} //음 좀 구린것같음...
