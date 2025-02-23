import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val valueList = MutableList<Long>(100) { 0 }

    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(t, p))
    }

    for(i in 0 until n) {
        val curT = list[i].first
        val curP = list[i].second.toLong()

        val next = i + curT



        for(j in next .. n) {
            valueList[j] = maxOf(valueList[j], valueList[i] + curP)
        }

//        println(valueList)
    }

    println(valueList[n])

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








