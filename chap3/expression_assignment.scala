// expression
// 실행 후 값을 반환하는 코드 단위.
// 길면 중괄호 {} 로 묶음. 마지막줄 표현식이 반환됨.
// 자체 scope를 가짐.

// assignment
// val <name> [: <type>] = <expression>
// var <name> [: <type>] = <expression>
// 타입 생략시, 컴파일러가 타입 추론(type inference)

val amount = {
    val x=5*20 //<-local variable. 이 표현식 scope 안에서만 존재
    x+10 //<-이부분이 amount에 들어감
}
println(amount) //110

val amount2 = {
    val a = 1;
    {   
        val b = a*2;
        {
            val c = b+4;
            c //<-얘가 amount2에 들어감
        }
    }
}
println(amount2) //6 

// statement
// 실행 후 값을 반환하지는 않는 코드 단위
// println 등의 함수 호출문, 혹은 선언문 그 자체 등
// app 밖을 변경하는 함수들 대부분이 이에 해당 (콘솔에 쓰거나, 데이터베이스를 업데이트하거나 등등)