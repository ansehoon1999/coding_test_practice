import java.io.*
import java.util.*
import kotlin.math.*

// 수열의 index와 숫자를 저장하는 클래스
data class Info(val idx: Int, val value: Int) : Comparable<Info> {
    override fun compareTo(other: Info): Int = this.value - other.value
}

// 세그먼트 트리 구현할 배열
lateinit var tree: LongArray
// 수열 A의 저장 배열
lateinit var values: Array<Info>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    values = Array(N) { Info(it, st.nextToken().toInt()) }

    var result = 0L
    // 오름차순 정렬
    values.sort()

    // 세그먼트 트리 관련 배열 초기화
    tree = LongArray(getTreeSize(N))
    var pre = Int.MAX_VALUE
    val idxs = mutableListOf<Int>()

    println(values.toList())
    // Swap 개수 구하기 시작 (작은 값부터 탐색)
    for (valInfo in values) {
        println(idxs)
        if (pre != valInfo.value) {
                for (idx in idxs) {
                    update(0, N - 1, 1, idx)
                }
                idxs.clear()
                pre = valInfo.value
            }
            result += search(0, N - 1, 1, valInfo.idx + 1, N - 1)
        idxs.add(valInfo.idx)
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
    br.close()
}

// 세그먼트 트리에서 Swap 개수 구하는 함수 (범위 합)
fun search(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (left > end || right < start) {
        println("${left} ${end} ${right} ${start}")
        return 0L
    }
    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    return search(start, mid, node * 2, left, right) + search(mid + 1, end, node * 2 + 1, left, right)
}

// 세그먼트 트리에 현재 값 저장 및 최신화
fun update(start: Int, end: Int, node: Int, idx: Int) {
    println(tree.toList())

   if(start == idx && end == idx) {
       tree[node] = 1
       return
   }

    val mid = (start+ end) / 2
    if(idx <= mid) update(start, mid, node * 2, idx)
    else update(mid + 1, end, node * 2 + 1, idx)

    tree[node] = tree[node*  2] + tree[node * 2 + 1]
}

// 세그먼트 트리의 노드 개수 구하는 함수
fun getTreeSize(n: Int): Int {
    val h = ceil(log2(n.toDouble())).toInt() + 1
    return (2.0.pow(h) - 1).toInt()
}
