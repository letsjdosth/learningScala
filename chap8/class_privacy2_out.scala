// 캡슐화-프라이버시 제어 2
// 클래스 통째로 private/protected 설정가능

// 위치에 기반하여, 동일 인스턴스 or 동일 패키지 내부에서까지만 접근가능하도록 설정할 수 있음

// private, protected 다음 대괄호[] 안에 this or 패키지명을 넣어 제어

// 실행위치 주의(/chap8에서 실행)
// rtoru@DESKTOP-Q0E76F1 MINGW64 /c/gitProject/learningScala/chap8 (master)
// $ scala class_privacy2_out.scala


//패키지 밖
val valid = new com.test2.Authentication().validate
new com.test2.Test()
// url = http://localhost
//<- test2.Test는 test2.Authentication에 접근가능

// new com.test2.Config()
//class_privacy2_out.scala:19: error: class Config in package test2 cannot be accessed in package com.test2
// 패키지 밖에서는 접근불가능