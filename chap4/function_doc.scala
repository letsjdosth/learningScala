// scaladoc header for function
// javadoc header와 정확히 같은 포맷임
// 맞춰 쓰면 InteliJ 등의 IDE에서 자동으로 이를 읽어서 스마트하게 제공함.
// 코드를 직접 읽으러 오지 않아도 됨.

// 함수 선언 앞에서
// /**로 시작 (참고: 여러줄 주석은 /* ~ */ 임)
// 내용은 1회 indent
// */로 끝


//ex

/**
    * 선행 혹은 후행 공백 없이 입력 문자열을 반환함
    * 입력 문자열이 null일 경우 null을 반환함
    * 매개변수 s는 입력 문자열임
    */
def safeTrim(s : String) : String = {
    if (s==null) return null
    s.trim()
}