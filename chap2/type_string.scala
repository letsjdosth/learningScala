// Type
// String : 큰따옴표로 묶어 사용
val hello = "Hello There"
val signature = "With Regards, \nYour friend"
println(hello)
println(signature)

// 여러 줄 쓴대로 넣기: """
// 주의: \n 등 안 먹음. 직접 엔터쳐줘야함.
val longGreeting = """She suggested reformatting the file
    by replacing tabs (\t) with newlines(\n);
    "Why do that?", he asked."""
println(longGreeting)

// String도 연산자가 정의되어 있음
val greeting = "Hello, " + "World"
println(greeting)
val matched : Boolean = (greeting == "Hello, World")
println(matched) //true

val theme = "Na " * 16 + "Batman!"
println(theme)

// string에 타변수값 넣기: + 이용
val approx = 355/113f
println(approx)
println("Pi, using 355/113, is about " + approx + ".")

// string에 타변수값 넣기: interpolation 이용
// s로 시작, 중간에 $로 변수명 호출
println(s"Pi, using 355/113, is about $approx.")
println(s"Pi, using 355/113, is about ${approx}.") //컴파일러가 제대로 인식 못 할 시 중괄호 사용

// string에 타변수값 넣기: printf 이용 (<from java.util.Formatter)
val item = "apple"
val appleItem = f"I wrote a new $item%.3s today"
println(appleItem)
println(f"Enjoying this $item ${355/113.0}%.5f times today")