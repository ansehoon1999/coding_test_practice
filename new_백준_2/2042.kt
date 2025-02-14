import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val to: Int,
    val weight: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (n, m, k) = br.readLine().split(" ").map { it.toLong() }

    var length = n
    var treeHeight = 0

    while (length != 0L) {
        length /= 2L
        treeHeight++
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    val treeStartIdx = treeSize / 2 - 1
    val tree = MutableList<Long>(treeSize + 1) { 0 }

    for (idx in treeStartIdx + 1..treeStartIdx + n) {
        tree[idx.toInt()] = br.readLine().toLong()
    }

    fun setTree(idx: Int) {
        var index = idx

        while (index != 1) {
            tree[index / 2] += tree[index]
            index --
        }
    }

    setTree(treeSize - 1)

    fun changeValue(idx: Int, value: Long) {
        var index = treeStartIdx + idx
        val diff = value - tree[index]

        while(index > 0) {
            tree[index] += diff
            index /= 2
        }
    }

    fun getSum(s: Int, e: Int): Long {
        var startIdx = s + treeStartIdx
        var endIdx = e + treeStartIdx
        var partSum = 0L

        while(startIdx <= endIdx) {
            if(startIdx % 2 ==1) {
                partSum += tree[startIdx]
                startIdx ++
            }

            if(endIdx % 2 == 0) {
                partSum += tree[endIdx]
                endIdx --
            }

            startIdx /= 2
            endIdx /= 2
        }

        return partSum
    }


    for(i in 0 until m+k) {
        val (op, a, b) = br.readLine().split(" ").map { it.toLong() }
        if(op == 1L) {
            changeValue(a.toInt(), b)
        } else if(op == 2L) {
            println(getSum(a.toInt(), b.toInt()))
        }
    }


}














