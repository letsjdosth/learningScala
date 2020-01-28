// namespace 자동 추가 요소들
// 묵시적 매개변수/묵시적 클래스-전환/ 타입 별칭을 수동 임포트 할 필요 없이 편리하게 쓰고싶을때 고려

// 1. scala.Preef object
// 스칼라 전체에 영향

// 2. package object
// 패키지마다 하나의 객체만, 패키지 임포트시 자동으로 네임스페이스에 추가됨을 허용
// 패키지 내부 package.scala에, package object <package name>
// ex. scala 패키지의 package.scala
