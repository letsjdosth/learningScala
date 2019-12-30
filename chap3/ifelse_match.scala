// if문 형식
// if(<boolean expression>) <expression>
// else <expression>
// else if 사용 가능. (내부적으로는 중첩된 if문으로 동작)

if (47%3 > 0){
    println("Not a multiple of 3")
}

//중괄호 없이 한줄표기 가능 (단, else 없이 if문만 있을때에는 중괄호 사용을 권장)
if (45%3 > 0) println("Not a multiple of 3") else println("a multiple of 3")

//자체로 expression임
val x = 10
val y = 20
val max = if (x>y) x else y
println(max) //20



// match expression
// 일종의 switch문 (타 언어보다 훨신 유욘함). scala에서는 if-else보다 이를 더 권장
// <expression> match {
//     case <pattern match> => <expression>
//     [case ...]
// }
// 맨 위 match 앞 expression을 평가 후, 해당 결과를 pattern match와 비교, 매치시 => 옆 expression을 반환

// ex1
val max2 = x > y match {
    case true => x
    case false => y
}
println(max2) //20


// ex2
val status = 500
val message = status match {
    case 200 => "ok"
    case 400 => {
        println("ERROR - we called the service incorrectly")
        "error"
    }
    case 500 => {
        println("Error - the service encountered an error")
        "error"
    }
}
println(message)


// ex3
val day = "MON"
val kind = day match {
    case "MON" | "TUE" | "WED" | "THU" | "FRI" => 
        "weekday"
    case "SAT" | "SUN" =>
        "weekend"
}
println(kind) //"weekday"



// 와일드카드 패턴
// 1. 값 바인딩 (value binding)
// 2. 와일드카드 연산자 _

// ex4 (값 바인딩 예)
val message2 = "OK" //여기 OK와 OK가 아닌 값을 변경해보며 테스트 해볼 것
val status2 = message2 match {
    case "OK" => 200
    case other => { 
        // 여기에 그냥 아무 변수 집어넣으면, 이 match문의 local 변수로 message2 값을 그대로 대입함. 
        // 따라서 언제나 참이 됨. 이를 이용해 나머지 경우를 제어가능
        // 굳이 other 아니고 다른 이름 써도 동작
        println(s"Couldn't parse $other")
        -1
    }
}
println(status2)


// ex5 (와일드카드 연산자 _ 이용)
// case _ 는 모든 패턴에 매칭됨
val message3 = "Unauthorized"
val status3 = message3 match {
    case "OK" => 200
    case _ => {
        // _는 그냥 placeholder임. _가 변수명으로 동작하진 않음.
        println(s"Couldn't parse $message3") //따라서 여기 $_가 아니라 직접 $message3으로 써줘야 함
        -1
    }
}
println(status3)



// pattern guard : match 표현식에 if를 섞어쓰자
// case <pattern expr> if <boolean expr> => <expr>
val response : String = null
response match {
    case s if s!=null => println(s"Received '$s'!") //if문에 괄호를 써도 되는데 안 써도 상관없음
    case s => println(s"ERROR! Received a null response")
}
//ERROR! Received a null response


// pattern matching : using type information
// case <identifier> : <type> => <expr>
val w : Int = 12180
val v : Any = w //모든 type의 superclass임
val z = v match {
    case w : String => s"'w'"
    case w : Double => f"$w%.2f"
    case w : Float => f"$w%.2f"
    case w : Long => s"${w}L"
    case w : Int => s"${w}i"
}
println(z) // 12180i

