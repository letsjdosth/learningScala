// 컬렉션간 전환 연산

// String으로 변환
val markedString = List(24, 99, 104).mkString(", ")
println(markedString) //24, 99, 104

// 주의: 이건 "List(2, 5, 5, 3, 2)" 라는 스트링 뭉치를 반환함
val mystring : String = List(2,5,5,3,2).toString
println(mystring) // List(2, 5, 5, 3, 2)




val mylist = Map("a"->1, "b"->2).toList
println(mylist) // List((a,1), (b,2))

val mymap = Set(1->true, 3->true).toMap //튜플의 컬렉션만 가능
println(mymap) // Map(1 -> true, 3 -> true)

val myset = List(2,5,5,3,2).toSet
println(myset) // Set(2, 5, 3)

//(가변 컬렉션으로 전환)
var variable = List('f','t').toBuffer 
println(variable) // ArrayBuffer(f, t)




// java <-> scala간 변환
// 바로는 안되도록 막아둠. 호환 안됨
// 다음과 같이 진행

// import collection.JavaConverters._
// List(12, 29).asJava //자바로
// new java.util.ArrayList(5).asScala //스칼라로

// 알아서 적당히 어울리는것으로 대응되는듯(뭐로 대응될지는 돌려봐야함)
