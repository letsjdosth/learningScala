// 캡슐화-프라이버시 제어 2
// 클래스 통째로 private/protected 설정가능

// 동일 인스턴스 or 동일 패키지 내부에서까지만 접근가능하도록 설정할 수 있음

// private, protected 다음 대괄호[] 안에 this or 패키지명을 넣어 제어

package com.test2 {
    private[test2] class Config { //<-패키지 마지막 경로만 명시
        val url = "http://localhost"
    }
    class Authentication {
        private[this] val password = "jason"
        def validate = password.size > 0
    }
    class Test {
        println(s"url = ${new Config().url}")
    }
}
