import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Node(
    val idx: Int,
    val value: Int
)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val values = mutableListOf<Node>()

    val st = StringTokenizer(br.readLine())

    repeat(n) {
        values.add(
            Node(
                idx = it,
                value = st.nextToken().toInt()
            )
        )
    }

    values.sortBy { it.value }

    var height = (Math.ceil(Math.log(n.toDouble())/Math.log(2.0)) + 1)
    val treeSize = (Math.pow(2.0, height) - 1).toInt()
    val tree = MutableList<Long>(treeSize) { 0 }
    val treeStartIdx = treeSize / 2 - 1

    val idxs = mutableListOf<Int>()
    var pre = Integer.MAX_VALUE
    var result = 0L


    fun search(start: Int, end: Int, node: Int, left: Int, right: Int): Long {

        if (left > end || right < start) {
            return 0L
        }

        if (left <= start && end <= right) {
            return tree[node]
        }

        val mid = (start + end) / 2
        return search(start, mid, node * 2, left, right) + search(
            mid + 1,
            end,
            node * 2 + 1,
            left,
            right
        )
    }

    fun update(start: Int, end: Int, node: Int, idx: Int) {
        if (idx == start && end == idx) {
            tree[node] = 1L
            return
        }

        val mid = (start + end) / 2
        if (idx <= mid) {
            update(start, mid, node * 2, idx)
        } else {
            update(mid + 1, end, node * 2 + 1, idx)
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1]
    }




    values.forEach { value ->
        if (pre != value.value) {

            idxs.forEach { idx ->
                update(0, n-1, 1, idx)
            }
            idxs.clear()
            pre = value.value
        }

        result += search(0, n-1,  1,value.idx + 1, n -1)

        idxs.add(value.idx)
    }

    println(result)



    writer.flush()
    writer.close()
}


//val (n, k) = br.readLine().split(" ").map { it.toInt() }
//val A = br.readLine().split(" ").map { it.toInt() }.toMutableList()
//
//fun swap(i: Int, j: Int){
//    val temp = A[i]
//    A[i] = A[j]
//    A[j] = temp
//}
//
//fun partition(s: Int, e: Int): Int {
//
//    if(s + 1 == e) {
//        if(A[s] > A[e]) {
//            swap(s, e)
//        }
//        return e
//    }
//
//    val m = (s + e) / 2
//    swap(s, m)
//    val pivot = A[s]
//    var i = s+1
//    var j = e
//
//    while(i <= j) {
//        while(j >= s && pivot < A[j]) j--
//        while(i <= e && pivot > A[i]) i++
//
//        if(i < j) {
//            swap(i, j)
//            i++
//        } else {
//            break
//        }
//    }
//
//    A[s] = A[j]
//    A[j] = pivot
//
//    return j
//}
//
//fun quickSort(s: Int, e: Int, k: Int) {
//    if(s < e) {
//        val pivot = partition(s, e)
//        if(pivot == k) return
//        else if(k < pivot) quickSort(s, pivot - 1, k)
//        else quickSort(pivot+1, e, k)
//    }
//}
//
//quickSort(0, n-1, k-1)
//println(A[k - 1])








