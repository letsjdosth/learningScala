// 이름에 의한 호출 매개변수
// 어떤 함수의 매개변수를, 값을 넣어서 호출해도 되고, 또다른 함수를 넣어 호출해도 되도록 만들자
// 함수를 넣을 경우, 그 함수에 값을 넣어 반환된 값을 얻은 후, 그 값으로 평가한다.

def doubles(x: =>Int) = { //x에는 이제 Int 값이 들어가도 되고, Int를 뱉는 함수가 들어가도 된다.
    println("Now doubling " + x)
    x * 2
}

println(doubles(5))
// Now doubling 5
// 10

def f(i : Int) = { println(s"Hello from f($i)"); i}

println(doubles(f(8)))
// Hello from f(8) //println 문에서
// Now doubling 8
// Hello from f(8) //x*2 에서
// 16
