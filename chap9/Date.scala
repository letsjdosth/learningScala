//shell app ex 1
object Date {
    def main(args: Array[String]) : Unit = { //<-like java, under object ~, define main(args: Array[String])
        println(new java.util.Date)
    }
}

// rtoru@DESKTOP-Q0E76F1 MINGW64 /c/gitProject/learningScala/chap9 (master)
// $ scalac Date.scala
// rtoru@DESKTOP-Q0E76F1 MINGW64 /c/gitProject/learningScala/chap9 (master)
// $ scala Date
// Thu Jan 23 14:29:32 KST 2020
