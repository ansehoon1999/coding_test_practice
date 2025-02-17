import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */


    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var length = n
    var treeHeight = 0

    while(length != 0) {
        length /= 2
        treeHeight ++
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    val treeStartIdx = treeSize / 2 - 1
    val tree = MutableList<Long>(treeSize) { Long.MAX_VALUE }

    for(idx in treeStartIdx + 1 .. treeStartIdx + n) {
        tree[idx] = br.readLine().toLong()
    }


    fun setTree(idx: Int) {
        var index = idx

        while(index != 1) {
            tree[index / 2] = minOf(tree[index / 2], tree[index])
            index --
        }
    }

    setTree(treeSize - 1)

    fun getMin(s: Int, e: Int): Long {
        var startIdx = treeStartIdx + s
        var endIdx = treeStartIdx + e

        var result = Long.MAX_VALUE
        while(startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                result = minOf(result, tree[startIdx])
                startIdx ++
            }

            if(endIdx % 2 == 0) {
                result = minOf(result, tree[endIdx])
                endIdx --
            }

            startIdx /= 2
            endIdx /= 2
        }

        return result
    }

    repeat(m) {
        val (a, b) =br.readLine().split(" ").map { it.toInt() }
        println(getMin(a, b))
    }

//    println(tree)
}














