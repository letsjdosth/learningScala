// 자주쓰는 고차함수

// sortBy, partition (list_method 또한 참고)
// & filter
// 자리표시자 연산자 사용시 간편
val filter = List(23, 8, 14, 21) filter (_>18) //boolean 리턴 형태
println(filter) //List(23, 21)

val partition = List(1,2,3,4,5) partition(_<3) //boolean 리턴 형태
println(partition) //(List(1, 2),List(3, 4, 5))

val sortBy = List("apple","to") sortBy(_.size) //크기비교 가능한 타입(Int) 리턴 형태
println(sortBy) //List(to, apple)


// map
// & collect, flatMap

//collect : case에 맞는 요소만 모은 후 case 적용
val collect = List(0,1,0) collect {case 1 => "Ok"}
println(collect) //List(Ok)
val collect2 = List(0,1,1,2) collect {case 1 => "Ok"}
println(collect2) //List(Ok, Ok)

//flatmap : 각 요소에 해당함수 적용 후 중첩리스트 존재시 다 평면화
val flatMap1 = List("milk, tea") flatMap (_.split(','))
val compareFlatMap1 = List("milk, tea") map (_.split(','))
println(flatMap1) //List(milk,  tea)
println(compareFlatMap1) //List([Ljava.lang.String;@d13baac) 
//<-java.lang.String.split()이라 리턴이 리스트가 아니라 자바 배열이라 이따위로 나옴
println(compareFlatMap1.flatten) //List(milk,  tea)

//map
val map = List("milk", "tea") map (_.toUpperCase)
println(map) //List(MILK, TEA)
