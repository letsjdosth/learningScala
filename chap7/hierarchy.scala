
// indexSeq
// Vector, Range

// Vector는 c++ vector나 array처럼, 물리적으로 붙어있는 메모리공간임 (ArrayList)
// index를 통해 한번에 접근가능
// Java Array 기반으로 구현되어있음

// Range는 정수 범위 컬렉션.



// LinearSeq
// List, Queue, Stack, Stream

// List는 이번 값과 다음 요소를 위한 포인터만 들고있음 (연결 리스트, LinkedList)
// 접근시 무조건 head에서 시작. (n)번째 요소 접근에 n-1단계 필요 (일반적 작업시 대부분 O(n))

// Queue는 선입선출, Stack은 후입선출 리스트
// Stream은 지연(lazy) 리스트. 항목은 해당 항목에 접근시 추가됨 (함수형 언어 특화)


// 계층구조

// Seq (대표 List)
// |
// IndexSeq(대표 Vector)    LinearSeq
// |        |               |      |      |     |
// Vector   Range           Queue, Stack, List, Stream
//                                        |
//                                        Nil

