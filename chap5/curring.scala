// 반복적으로 함수 호출 시, 모든 arg를 다 채울 필요 없이
// 일부 매개변수를 유지하게 하며 호출하고 싶다면?


// 부분 적용 함수
// ex1
def factorOf(x:Int, y:Int) = y % x == 0
val multipleOf3 = factorOf(3, _:Int) //x를 3으로 고정한 factorOf가 된다
println(multipleOf3(78)) // true



// curring
// 함수의 체인(합성함수)을, 합성된 함수의 매개변수 값을 고정시키며 쪼개는 것
// ex2
def factorOf2(x: Int)(y:Int) = y % x == 0 //factorOf2의 type은 Int=>Int=>Boolean이 된다. (앞에서부터 읽는다)
val isEven = factorOf2(2) _ // 앞은 2로 고정 ('2로 factorOf2의 앞부분을 curring했다'고 말한다.). isEven의 type은 Int=>Boolean이 된다.
val z = isEven(32) // type은 Boolean이다.
println(z) //true



