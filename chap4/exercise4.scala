// 1
def circleArea (radius : Double) : Double = Math.PI*radius*radius
println(circleArea(1))

// 2
def circleArea2 (radius : String) : Double = {
    val doubleRadius = radius.toDouble
    Math.PI*doubleRadius*doubleRadius
}
println(circleArea2("1"))
// println(circleArea2("")) // <-error남. java.lang.NumberFormatException: empty String

// 3
@annotation.tailrec
def recPrintTo50(x: Int) : Unit ={
    println(x)
    if (x<50) recPrintTo50(x+5)
}
recPrintTo50(5)

// 4
def millisecToTime(milliSec : Long) : String = {
    var sec : Double = (milliSec % 1000).toDouble / 1000
    var nowScale : Long = ((milliSec-sec) / 1000).toLong
    sec += (nowScale % 60)
    nowScale = ((nowScale-(nowScale%60)) / 60).toLong
    val min : Long = (nowScale % 60)
    nowScale = ((nowScale-min) / 60).toLong
    val hour : Long = (nowScale % 24)
    val day = ((nowScale-hour) / 24).toLong

    day.toString + " day " + hour.toString + " hour " + min.toString + " min " + sec.toString + " sec"
}
println(millisecToTime(2*1000 + 500))
println(millisecToTime(23*60*1000 + 2*1000 + 500))
println(millisecToTime(14*60*60*1000 + 23*60*1000 + 2*1000 + 500))
println(millisecToTime(3*24*60*60*1000+ 14*60*60*1000 + 23*60*1000 + 2*1000 + 500))
//long 말고 string으로 받으면 어떨까?


// 5
def powWithMath(base : Double, exponent : Double) : Double = Math.pow(base, exponent)
println(powWithMath(2,3)) //8.0

@annotation.tailrec
def powOwn(base : Int, exponent : Int, x : Long) : Long = {
    // x는 base와 언제나 같게 놓을것. (이거 개선할 수 없나?)
    if (exponent == 1) x
    else powOwn(base, exponent-1, x*base)
}
println(powOwn(2,3,2))


// 6
def distance2d (x : (Double, Double), y : (Double, Double)) : Double = {
    val squared = Math.pow(x._1-y._1, 2) + Math.pow(x._2-y._2, 2)
    Math.pow(squared, 0.5)
}
println(distance2d((0,0),(3,4))) //5.0


// 7
def intToFirst[A,B] (a : (A, B)) = {
    if (a._2.isInstanceOf[Int]) (a._2, a._1)
    else a
}
println(intToFirst(2.5,2))
println(intToFirst(2.7,2.4))

//8
def addString[A,B,C](a : (A, B, C)) = {
    (a._1, a._1.toString, a._2, a._2.toString, a._3, a._3.toString)
}
println(addString(true, 22.25, "yes"))
// REPL 출력: res1: (Boolean, String, Double, String, String, String) = (true,true,22.25,22.25,yes,yes)
