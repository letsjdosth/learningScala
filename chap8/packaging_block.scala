// 한 파일에서 여러 패키지의 클래스를 포함할 경우
// 패키지 경계를 표시하자
// (음..파일을 쪼개는게 어떨까요? 이건 잘 안 쓰는 방법임)

package com { //com
    package test{ //com.test
        package comname{ //com.test.comname
            class Config1(val baseUrl: String = "http://localhost") //com.test.comname.Config1
        }
    }

    package test2{ //com.test2
        package comname2{ //com.test2.comname2
            class Config2(val baseUrl: Int = "http://127.0.0.1:8888") // com.test2.comname2.Config2
        }
    }
}


// 블록이 중첩될 수 있음