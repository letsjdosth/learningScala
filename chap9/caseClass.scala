// case class
// 자동생성 동반객체와 사전적으로 생성된 몇몇 메소드가 있는 클래스

// 상속되어져 만들어졌거나 혹은 상속할 경우가 없을, 필드 위주 데이터 저장용 클래스에 사용
// (자동으로 만들어진 메소드가 상속받은 필드를 제대로 지원 안 함)

case class Character(name: String, isThief: Boolean) //<-자동으로 val이 붙은것으로 취급됨
// 상속해 만들 수 있으나, 주의할 것
// 부모 클래스의 필드에 대해서는 아래 메소드가 자동생성되지 않음

// 자동생성 목록
// in object
// apply : 인스턴스 factory
// unapply : 인스턴스 필드들의 튜플을 추출. 패턴매칭에 사용할 수 있도록 함
// in class
// copy : 요청 변경사항(매개변수:필드)이 변경된 인스턴스 사본 반환
// equals: == 지원. 인스턴스간 모든 필드값이 일치하는지 확인
// hashCode : 인스턴스 필드들의 해시코드 반환. 컬렉션 확장시 유용
// toString : 클래스명/필드를 string으로 전환

val h = Character("Hadrian", true) //<- by object's apply()
val r = h.copy(name="Royce") //<- by class's copy(). isThief는 true가 복사되어 들어감
println( h == r ) // false //<- by class's equals
val isThiefStr = r match {
    case Character(x, true) => s"$x is a thief" //<-case에서 튜플 바인드를 지원하는것은 object의 unapply()
    case Character(x, false) => s"$x is not a thief"
}
println(isThiefStr)