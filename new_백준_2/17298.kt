import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine()

    val stk = Stack<Int>()

    val nList = br.readLine().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()
    result.add(-1)
    stk.add(nList.last())

    for(i in nList.lastIndex - 1 downTo 0) {

        val curN = nList[i]
        val stkLast = stk.last()

        if(curN < stkLast) {
            result.add(stkLast)
            stk.add(curN)
        } else  {

            while(stk.isNotEmpty()) {
                if(curN >= stk.last()) {
                    stk.pop()
                } else {
                    break
                }
            }

            if(stk.isNotEmpty()){
                result.add(stk.last())
            } else {
                result.add(-1)
            }
            stk.add(curN)
        }

//        println(stk)
    }

    val sb = StringBuilder()
    for(x in result.lastIndex downTo 0) {
        sb.append("${result[x]} ")
    }
    println(sb.toString())

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








