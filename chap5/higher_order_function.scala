// higher-order function
// arg로, 함수를 받자

def safeStringOp(s: String, f: String => String) = { //그냥 함수 타입 그대로 시그니쳐에 올리자
    if (s != null) f(s) else s
}
def reverser(s: String) = s.reverse

println(safeStringOp(null, reverser)) //null
println(safeStringOp("Ready", reverser)) //ydaeR
