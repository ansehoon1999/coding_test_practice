import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toLong() }

    val dp = MutableList<MutableList<Long>>(n+1) {
         MutableList<Long>(2) { Long.MIN_VALUE }
    }

    dp[0][0] = nList[0].toLong()
    dp[0][1] = nList[0]

    var max = nList[0]
    for(i in 1 until n) {

        // 0 = 제거 하지 않았을 때
        dp[i][0] = maxOf(nList[i], dp[i-1][0] + nList[i])

        // 1 = 삭제 했을 경우
        dp[i][1] = maxOf(dp[i-1][0], dp[i-1][1] + nList[i])

        max = maxOf(max, dp[i][0], dp[i][1])
    }




    println(max)


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








