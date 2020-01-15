// 이 파일 실행 안내
// vscode 단축키는 무조건 learningScala 폴더가 root라, 바로 실행하려면 com.test.comname 클래스 폴더를 루트 바로 아래로 빼야함
// 하지만 그러지 않고 chap8 밑에 두고 있음
// 때문에, 현 상태에서는 bash의 위치를 chap8 폴더에 두고 scala 실행

// jun@DESKTOP-5TMEH2C MINGW64 /c/gitProject/learningScala/chap8 (master)
// $ scala packaging_import.scala 


// 패키지 접근
// 그냥 패키지 이름 그대로 써서 접근가능
// 혹은 import문 사용: import <package>.<class>

// 바로 사용 예
val d = new java.util.Date
println(d) //Thu Jan 16 03:29:02 KST 2020

// import문으로 네임스페이스로 끌고와서 사용 예
import com.test.comname.Config
val a = new Config
println(a.baseUrl)
// jun@DESKTOP-5TMEH2C MINGW64 /c/gitProject/learningScala/chap8 (master)
// $ scala packaging_import.scala 
// http://localhost



// import 참고1: 각 스코프별로 import문을 사용할 수 있음 (그러면 해당 스코프를 나가는 순간 날아감)
println("Your new UUID is " + {
    import java.util.UUID
    UUID.randomUUID
})
//Your new UUID is 6b2f4c58-52e4-45a2-8591-9a1098a61ba3

// import 참고2: 부분 패키지 경로를 이용할 수 있음
import java.util
val d2 = new util.Date
println(d2) //Thu Jan 16 03:33:26 KST 2020

// import 참고3: 패키지의 모든 클래스 통째로 임포트시 import <class>._ 사용
// 단 이건 잠재적인 위험이 있음. namespace에서 이름이 중복되거나 하면 영영 접근할 수 없어짐
import collection.mutable._

val bu = new ArrayBuffer[String] //<-collection.mutable 안에 있는 클래스 1
bu += "Hello"
val q = new Queue[Int] 
q.enqueue(3,4,5)
val pop = q.dequeue
println(pop)
println(q)
// 3
// Queue(4, 5)
// Map(불변)은 이제 Map(가변)<-collection.mutable 안에 있는 클래스 3에 의해 가려졌다..


// import 참고4: 스칼라는 scala._와 java.lang._을 기본적으로 임포트하고 시작함
// import 참고5: 임포트 그룹 사용가능
// import <package>{<class1>, [<class2>, ...]}
import collection.mutable.{Queue,ArrayBuffer} //네임스페이스 생각하며 내가 쓸 것만 가져오자

// import 참고6: import한 클래스의 별칭 사용가능
// import <package>.{<class> => <alias>}
import collection.mutable.{Map=>MutableMap} //이렇게 애초에 했다면 안 가려졌을 것임
