// 인스턴스 멤버 임포트
// 인스턴스 멤버를 해당 네임스페이스로 직접 끌어올려, 편리하게 접근할 수 있음
// <instance identifier>.<member identifier>
// 전체멤버 끌어올릴시 ._


// 여러 인스턴스 작업시 마구 임포트하지 말 것 (이름 충돌날 우려)
// 또한, import문 위치를 신중히 조절할것 (가독성을 크게 해칠 우려)

// ex1
case class Receipt(id: Int, amount: Double, who: String, title: String)

{
    val latteReceipt = Receipt(123, 4.12, "fred", "Medium Latte")
    import latteReceipt._ //<-인스턴스 멤버 전체를 이 중괄호 local namespace로 끌어올린다
    println(s"Sold a $title for $amount to $who")
}
//Sold a Medium Latte for 4.12 to fred

// ex2
{
    import util.Random._
    val letters = alphanumeric.take(20).toList.mkString
    val numbers = shuffle(1 to 20)
    println(letters)
    println(numbers)
}