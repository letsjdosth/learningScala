// 캡슐화-프라이버시 제어

// 기본적으로 모든 스칼라 클래스와 그 멤버는 public
// public / protected (해당 class 및 자식클래스에서만 접근) / private (해당 class에서만 접근)
// 클래스내 멤버선언라인 def,var,val 앞에 붙여주자

class User(protected var passwd: String) {
    def update(p: String) = {
        println("Modifying the password!")
        passwd = p
    }
    def validate(p: String) = {
        p==passwd
    }
}
class ValidUser(passwd: String) extends User(passwd) {
    def isValid = ! passwd.isEmpty
}
val isValid = new ValidUser(scala.util.Random.nextString(10)).isValid
println(isValid) // true

// val passwd = new User("1234").passwd //<- protected에 접근 불가
// error: value passwd in class User cannot be accessed in this.User
//  Access to protected value passwd not permitted because
//  enclosing <$anon: AnyRef> is not a subclass of
//  class User where target is defined
// val passwd = new User("1234").passwd
//                              ^

val u = new User("1234")
val isValid1 = u.validate("1234")
println(isValid1) //true
u.update("4567")
val isValid2 = u.validate("4567") //Modifying the password!
println(isValid2) //true

