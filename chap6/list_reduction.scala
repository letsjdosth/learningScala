// reduce류 메소드

// 수학
val maxval = List(41,59,26).max //59
val minval = List(10.9, 32.5, 4.23, 5.67).min //4.23
// warning: object DeprecatedDoubleOrdering in object Ordering is deprecated (since 2.13.0): 
// There are multiple ways to order Doubles (Ordering.Double.TotalOrdering, Ordering.Double.IeeeOrdering). 
// Specify one by using a local import, assigning an implicit val, or passing it explicitly. 
// See their documentation for details.

val prodval = List(5,6,7).product //210
val sumval = List(11.3, 23.5, 7.2).sum //42.0
println(s"$maxval $minval $prodval $sumval")

// bool값
val containBool = List(34, 29, 18) contains 29 //true
val endsWithBool = List(0,4,3) endsWith List(4,3) //true
val existsBool = List(24, 17, 32) exists (_<18) //true
val forallBool = List(24, 17, 32) forall (_<18) //false
val startsWithBool = List(0, 4, 3) startsWith List(0) //true
println(s"$containBool $endsWithBool $existsBool $forallBool $startsWithBool")

// 일반화
// 주의: 방향성 없는 연산은 연산방향 보장 안 함 (분산처리 시 주의). 방향연산이 더 안전함
// 주의: 연결리스트이므로, Left(즉 왼->오) 연산이 Right(오->왼)보다 빠름. 최적화시 고려
// 주의: 방향성 없는 연산은 리스트 요소와 동일한 타입의 값을 반환하도록 제약되어 있음
// 방향연산은 타입 다른 리턴이 가능. (예: 정수 list에 forall Boolean 연산은, 방향성 없는 연산으로는 불가.)
// .fold(start)(function)
val fold1 = List(4,5,6).fold(0)(_+_)
val fold2 = List(4,5,6).foldLeft(0)(_+_)
val fold3 = List(4,5,6).foldRight(0)(_+_)
println(s"$fold1 $fold2 $fold3") //15

// .reduce(function) : 시작값은 첫 요소
val reduce1 = List(4,5,6).reduce(_+_)
val reduce2 = List(4,5,6).reduceLeft(_+_)
val reduce3 = List(4,5,6).reduceRight(_+_)
println(s"$reduce1 $reduce2 $reduce3") //15

// .scan(start)(function) : 반환은 각 step에서의 값 list
val scan1 = List(4,5,6).scan(0)(_+_)
val scan2 = List(4,5,6).scanLeft(0)(_+_)
val scan3 = List(4,5,6).scanRight(0)(_+_)
println(scan1) //List(0, 4, 9, 15)
println(scan2) //List(0, 4, 9, 15)
println(scan3) //List(15, 11, 6, 0) <-오른쪽부터 연산되었고 해당 값이 끝부터 들어감



// 응용
// 중위연산자 표현식으로 마치 그냥 영어문장처럼 쓸 수 있음
val validations = List(true, true, false, true, true, true)
val valid1 = !(validations contains false)
println(valid1) //false
val valid2 = validations forall (_ == true)
println(valid2) //false
val valid3 = (validations.exists(_ == false) == false)
println(valid3) // false


// 구현 살펴보기
// 누산기 형태로 contains를 구현해보자
def contains(x: Int, l:List[Int]) : Boolean = {
    var a : Boolean = false
    for(i <- l) {if(!a) a=(i==x)}
    a
}
val included0 = contains(19, List(46, 19, 92))
println(included0) //true

// contains 로직 분리시 (순회로직만 남겨보자)
def boolReduce(l : List[Int], start : Boolean)(f : (Boolean, Int)=>Boolean) : Boolean = {
    var a = start
    for(i <- l) a=f(a, i)
    a
}
val included1 = boolReduce(List(46, 19, 92), false) {(bool,i)=> if(bool) bool else (i==19)}
println(included1) //true
// 이를 가지고 이제 뒤 f만 바꿔끼며 bool reduce류 연산 모두 구현가능

// 더 일반화 : bool 말고 다른것에도 쓸수있게 바꿔보자
def reduceOp[A,B](l: List[A], start:B)(f: (B,A)=>B) : B = {
    var a = start
    for(i <- l) a=f(a,i)
    a
}
val included2 = reduceOp(List(46, 19, 92), false) {(bool,i)=> if(bool) bool else (i==19)}
println(included2) //true
val mySum = reduceOp(List(11.3, 23.5, 7.2), 0.0)(_+_)
println(mySum) //42.0

// 이것이 fold임
val included3 = List(46, 19, 92).foldLeft(false){(bool,i)=> if(bool) bool else (i==19)}
val mySum2 = List(11.3, 23.5, 7.2).foldLeft(0.0)(_+_)
println(s"$included3 $mySum2") // true 42.0