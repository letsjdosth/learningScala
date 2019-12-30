// 1
val name = "name"
val return1 = name match {
    case "name" => name
    case "" => "n/a"
}
println(return1)


// 2
val amount : Double = -1
val return2 = amount match {
    case 0 => "same"
    case amount if amount > 0 => "greater"
    case amount if amount < 0 => "less"
}
println(return2)

val return22 = if (amount == 0) "same" else if (amount > 0) "greater" else "less"
println(return22)


// 3
val cyan = 0
val magenta = 0
val yellow = 2
val cmykCode : String = {
    (255 - 255*cyan/100).toInt.toHexString + (255 - 255*magenta/100).toInt.toHexString + (255 - 255*yellow/100).toInt.toHexString
}
println(cmykCode)


// 4
for (i <- 1 to 100){
    print(s"$i, ")
    if (i%5==0) print("\n")
}

// 5
for (i <- 1 to 100){
    val out = i match {
        case i if i % 15 == 0 => "typesafe"
        case i if i % 3 == 0 => "type"
        case i if i % 5 == 0 => "safe"
        case _ => i
    }
    print(s"$out, ")
    if (i%10==0) print("\n")
}

// 6
// one line code for 5?