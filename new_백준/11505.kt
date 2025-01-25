import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val MOD = 1000000007L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, K) = br.readLine().split(" ").map { it.toLong() }

    var length = N
    var treeHeight = 0

    while(length != 0L) {
        length /= 2
        treeHeight ++
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    val treeStartIdx = treeSize / 2 - 1
    val tree = MutableList<Long>(treeSize) { 1L }
    val zeroList = MutableList<Boolean>(treeSize) { false }

    for(idx in (treeStartIdx + 1) .. (treeStartIdx + N)) {
        tree[idx.toInt()] = br.readLine().toLong()
    }

    fun setTree(idx: Int) {
        var index = idx
        while(index > 1) {
            tree[index / 2] = (tree[index / 2] * tree[index] % MOD)
            index --
        }
    }

    setTree(treeSize - 1)

//    println(tree)

    fun changeValue(idx: Int, value: Long) {
        var index = treeStartIdx + idx
        tree[index] = value

        while(index > 1) {
            index /= 2
            tree[index] = tree[index * 2] * tree[index * 2 + 1] % MOD
        }

    }

    fun getMultipleValue(s: Long, e: Long): Long {
        var start = s + treeStartIdx
        var end = e + treeStartIdx
        var partMultipleValue = 1L

        while(start <= end) {
            if(start % 2 == 1L) {
                partMultipleValue = partMultipleValue * tree[start.toInt()] % MOD
                start ++
            }

            if(end % 2 == 0L) {
                partMultipleValue = partMultipleValue * tree[end.toInt()] % MOD
                end --
            }

            start /= 2
            end /= 2
        }


        return partMultipleValue
    }

    for(i in 0 until M + K) {
        val (question, s, e) = br.readLine().split(" ").map { it.toLong() }
        if(question ==1L) {
            changeValue(s.toInt(), e)
        } else if(question == 2L) {
            val tmp = getMultipleValue(s, e)
            println(tmp)
        }

//        println(tree)
    }


}