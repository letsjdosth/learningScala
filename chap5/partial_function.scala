// total function: 시그니쳐에 선언된 argument type을 만족하는 모든 arg 값에 대해 동작
// partial function: 시그니쳐에 선언된 argument type을 만족해도, 특정 값에서만 동작
// 예: sqrt in real field

val statusHandler: Int => String = {
    case 200 => "OK"
    case 400 => "Your Error"
    case 500 => "Our error"
}

statusHandler(401) //scala.MatchError: 401 (of class java.lang.Integer)

// 대안은 case _를 사용하는 것 등등
// 하지만, 일부로 에러를 내고, 이를 이용해볼수도 있음 (허용 아이템 수집 등등)