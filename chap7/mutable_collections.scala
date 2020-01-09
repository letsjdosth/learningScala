// 가변 컬렉션
// 주의: 동시성 프로그래밍 시 가변 데이터 구조를 바로 던지지 말 것
// 불변구조로 변환 후 던질것

// // mutable collection
// collection.mutable.Buffer <- List에 대응
// collection.mutable.Set
// collection.mutable.Map

// // immutable collection
// collection.immutable.List
// collection.immutable.Set
// collection.immutable.Map

// 기본로딩 namespace의 것은 immutable임. mutable 사용시 따로 로드해 써야 함


val nums = collection.mutable.Buffer(1) //val이어도 변경된다
for(i<-2 to 10) nums += i
println(nums) //ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// 가변->불변 : toList, toMap, toSet
val numsList = nums.toList
println(numsList) //List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val wantToSet = collection.mutable.Buffer("a"->1, "a"->1, "b"->2)
val wentSet = wantToSet.toSet
println(wentSet) //Set((a,1), (b,2)) //<-중복 제거되며 변환된다


// 불변->가변 : List, Map, Set 모두 toBuffer (딴거 굳이 쓸 이유 x)
val m = Map("AAPL"->597, "MSFT"->40)
val b = m.toBuffer
println(b) //ArrayBuffer((AAPL,597), (MSFT,40))
b trimStart 1 //앞에서부터 n개 제거
b += ("GOOG"->521)
println(b) //ArrayBuffer((MSFT,40), (GOOG,521))
val m2 = b.toMap
println(m2) //Map(MSFT -> 40, GOOG -> 521)



// 단, 불변 컨테이너 처음 만들때 반복 요소 추가시, 가변으로 만든 후 불변으로 변환할필요 없음
// 그냥 불변타입의 컬렉션 빌더를 사용하자
val builderHelloSet = Set.newBuilder[Char]
builderHelloSet += 'h'
builderHelloSet ++= List('e','l','l','o')
val helloSet = builderHelloSet.result //<-모두 추가후 .result 호출해 반환값 사용
print(helloSet) // Set(h, e, l, o)