// 재귀함수 (recursive function)
// 함수형 프로그래밍에서는 보편 사용. 
// 
// 재귀 함수 호출 시 데이터구조/계산을 가변적인 데이터를 사용하지 않고 반복하도록, 함수 호출이 매개변수를 저장하기 위한 stack을 각자 가지게 되는데,
// 이러면 stack overflow 문제가 날 위험이 있음
// -> 마지막 문장이 자신을 호출하는 재귀문일 시 (오직 이 때만), 스칼라 컴파일러는 stack을 또 쌓지 않고, 현 함수의 stack 공간을 이용해 함수를 돌림
// "tail-recursion" optimization (꼬리재귀 최적화)
// 꼬리재귀 annotation을 붙여 컴파일러에 명시적으로 알리자. @annotation.tailrec


// 꼬리재귀 최적화가 불가능할 경우, annotation을 달아 컴파일할 때 컴파일러가 에러를 뱉음
// @annotation.tailrec
// error: could not optimize @tailrec annotated method power: it contains a recursive call not in tail position
def power (x : Int, n : Int) : Long = {
    // x^n
    if (n>=1) x * power (x, n-1)
    else 1
}
val power28 = power(2,8)
val power21 = power(2,1)
val power20 = power(2,0)
println(power28) // 256
println(power21) // 2
println(power20) // 1


@annotation.tailrec
def optimizedPower(x : Int, n : Int, t : Int = 1) : Int = {
    // x^n
    if (n<1) t
    else optimizedPower(x, n-1, x*t) //<-마지막줄에 오직 자기를 부르는 명령만 오도록 함수를 잘 설계해야함
}
println(optimizedPower(2,8)) //256
