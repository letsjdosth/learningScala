// 1

val cel = 25.5
val fer = cel * 9/5 + 32
println(fer, cel.getClass , fer.getClass) // 77.9, double, double

// 2
val ferInt = (cel * 9/5 + 32).toInt
println(ferInt, ferInt.getClass) // 77, int

// 3
val inputNum = 2.7255
val stringOut = f"${inputNum}%.3f"
println("You owe $" + stringOut + ".")
// cannot do using interpolation

// 4
val flag : Boolean = false
var result : Boolean = !flag
println(result) // true

// 5
val givenNum = 128
println((givenNum.toChar).toInt)
println((givenNum.toString).toInt)
println((givenNum.toDouble).toInt)
// 연달아서는 안됨

// 6
val fullInput = "Frank, 123 Main, 925-555-1943, 95122"
val regRule = """.*, ([0-9].+), .*""".r
val regRule(phoneNum) = fullInput
// val phoneNumInt = phoneNum.toInt
println(phoneNum)
val phoneNumTuple = (phoneNum.slice(0,3).toInt, phoneNum.slice(4,7).toInt, phoneNum.substring(8).toInt)
println(phoneNumTuple, phoneNumTuple._1.getClass)