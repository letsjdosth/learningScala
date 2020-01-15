// 자바와 같음.
// 각 scala file의 소스코드 맨 위에서 package <identifier> 로 해당 패키지에 포함됨을 선언
// 디렉토리 구조는 무조건 패키지 구조와 같아야 함. 스칼라 코드파일도 해당 디렉토리에 들어가있어야 함.


package com.test.comname

class Config(val baseUrl: String = "http://localhost")

//이거 컴파일해보면, ~/com/test/comname에 Config.class가 생김.
//$ scalac com/test/comname/packaging_definition.scala

//참고로 src<-라는 폴더이름은 컴파일러가 무시함. 따라서
//소스파일을 ~/src라는 폴더에 구조에 맞춰 몰아놓고 컴파일하면, ~ 밑에 해당 구조에 맞게 class 파일이 생성됨