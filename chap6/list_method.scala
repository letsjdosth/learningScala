// List arithmetic method
// 참고: List는 불변(immutable)임. 뭔가 수정하면 실제론 변경되는것이 아니라 새로 만들어짐

// 참고2: 스칼라는 연결리스트로 리스트를 구현. 
// 때문에 앞에서(만) 넣었다뺐다 해야/ 앞만 최소로 순회해야 성능상 좋음
// 예: ::, drop, take 등은 성능하강 없음.
// 반대로, 뒤에서 넣었다뺐다 하거나 뒤를 순회하는건, 전체를 다돌아야해서 느림
// 예: +:, dropRight, takeRignt <-이런거 큰 리스트에서는 자주 쓰지 말 것

// 아래 모두 점표기법, 연산자표기법 둘 다 가능


val list1 = 1 :: 2 :: Nil //원소간 이어붙이기
println(list1) //List(1, 2)

val list2 = List(1,2) ::: List(2,3) //리스트간 이어붙이기
println(list2) //List(1, 2, 2, 3)

val list3 = List(1,2) ++ Set(3,4,3) //Set! 컬렉션 종류가 다를때도 동작하는 이어붙이기
println(list3) //List(1, 2, 3, 4)

val bool = (List(1,2) == List(1,2)) //값 비교
println(bool) // true

val list4 = List(3,5,4,3,4).distinct //중복요소 삭제 후 리스트
println(list4) //List(3, 5, 4)

val list5 = List('a','b','c','d') drop 2 //앞부터 n개 뺌
println(list5) //List(c, d)

val list6 = List(List(1,2), List(3,4)).flatten //중첩 리스트를 단일 리스트로 전환
println(list6) //List(1, 2, 3, 4)

val tuple = List(1,2,3,4,5) partition ( _<3 ) // true 요소들과 false 요소들을 갈라 tuple화
println(tuple) //(List(1, 2),List(3, 4, 5))

val list7 = List(1,2,3).reverse //순서 뒤집기
println(list7) //List(3, 2, 1)

val list8 = List(2,3,5,7) slice(1,3) //파이썬에서 List(2,3,5,7)[1:3]과 같음. [start, end+1] 임
println(list8) //List(3, 5)

val list9 = List("apple", "to") sortBy (_.size) // 뒤 함수를 모든 요소에 적용 후 값 순서대로 오름차순 정렬
println(list9) //List(to, apple)

val list10 = List("apple", "to").sorted // 자주쓰는 타입 요소 자연스러운 정렬 (이 경우, 알파벳순 정렬됨)
println(list10) //List(apple, to)

val tuple2 = List(2,3,5,7) splitAt 2 //인덱스기준 스플릿. 해당 인덱스 앞에서 잘림
println(tuple2) //(List(2, 3),List(5, 7))

val list11 = List(2,3,5,7,11,13) take 3 //앞 n개 추출
println(list11) //List(2, 3, 5)

val list12 = List(1,2) zip List("a","b") //파이썬 zip과 같은 동작. 리스트를 반환함
println(list12) // List((1,a), (2,b))

