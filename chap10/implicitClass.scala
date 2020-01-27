// 묵시적 클래스

// 특정 클래스의 인스턴스를 묵시적으로 다른 클래스로 자동 전환
// 해당 인스턴스에 없는 필드나 메소드에 접근시, 같은 namespace에서
// 그 필드나 메소드가 있는 인스턴스의 클래스를 찾아,
// 찾을 시 그 클래스로 인스턴스를 자동 변환하고 그 필드/메소드를 돌려줌.
//  (못찾으면 컴파일 에러를 냄)

// implicit class로 표시

// 필드/메소드 이식용으로 사용가능
// 단, 코드 가독성을 해침

// 선언 제약
// 1. 다른 object/클래스/트레이트에서 정의. 이후 원하는 네임스페이스에 임포트
// 2. 묵시적 클래스는 언제나 하나의 묵시적이지 않은 클래스 인수를 받아야 함
// 3. 묵시적 클래스명은 네임스페이스에서 충돌하지 말아야 함 (따라서 case class는 묵시적 선언 불가)

object IntUtils { //<-다른 object 내 네임스페이스에서 정의하자(1) 
    implicit class Fishies(val x: Int){ //<-클래스인수를 받자(2).이름충돌을 주의하자(3)
    //<-특정 상황에 이 클래스로 자동전환을 허용하도록 implicit를 붙인다
        def fishes = "Fish" * x
    }
}
import IntUtils._ //<-global에 Fishies를 임포트.
println(3.fishes) //FishFishFish
// Int에 .fishes가 없으므로,
// namesepace에서 fishes란 메소드를 가진 묵시적 클래스를 찾는다.
// 마침 IntUtils의 메소드 fishes가 global에 있으므로
// Int를 Fishes로 변환후, fishses(3)을 실행.
// (모든 Int에 .fishes가 정의되는 효과)

// (1) 관련, 위치는 보통 object 내가 편리함
// subclass가 만들어지지 않아 의도치않게 묵시적 클래스를 늘리는 일이 없으며
// 원하는 네임스페이스로의 임포트가 편리하기 때문 

// 스칼라 설계 구조상, scala.Predef object 내에 정의된 멤버는
// 컴파일시 전역에 바로 불러와짐