// 6.1
val numList = 1L to 20L
val oddList = numList.toList map (_*2-1)
println(oddList)


// 6.2
def factors (x: Int) : List[Int] = {
    val numList = (2 to x-1).toList
    numList filter (x%_==0)
}
println(factors(15))

def factorsList(xList: List[Int]) : List[Int] = {
    xList flatMap factors
}
println(factorsList(List(9, 11, 13, 15)))


// 6.3
def first[A](items: List[A], count:Int) : List[A] = {
    items take count
}
println(first(List('a','t','o'), 2))

def first2[A](items: List[A], count:Int) : List[A] = {
    if (count>0) items.head :: first2(items.tail, count-1) else Nil
}
println(first2(List('a','t','o','p'), 3))

// foldLeft는 음 귀찮을듯
// for loop로는 easy


// 6.4
val testStrings : List[String] = List("hi","Hello","I'mSoLong","one")
def reduceToLongest (s : List[String]) : String = {
    s reduce {(a,b) => if(a.size>b.size) a else b}
}
println(reduceToLongest(testStrings))

def foldToLongest(s : List[String]) = {
    s.fold(""){(a,b)=>if (a.size>b.size) a else b}
}
println(foldToLongest(testStrings))


// 6.5
val testListReverse = List(0,1,2,3,4,5)
def reverseList (l: List[Int]) : List[Int] = {
    l match {
        case Nil => Nil
        case _ => reverseList(l.tail) ::: l.head :: Nil
    }
}
println(reverseList(testListReverse))


// 6.6
val testStrings2 = List("racecar", "apple", "abba", "hello")
def sameRev (l : List[String]) : (List[String],List[String]) = {
    l partition {a => a==a.reverse}
}
println(sameRev(testStrings2))
//뭐 filter로 갈라서 각각 tuple 만들던가.. 하면될듯 (굳이?)