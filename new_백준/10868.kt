import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toLong() }

    var treeHeight = 0
    var length = N

    while(length != 0L) {
        length /= 2L
        treeHeight ++
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    val treeStartIdx = treeSize / 2 - 1
    val tree = MutableList<Long>(treeSize) { Long.MAX_VALUE }

    for(idx in treeStartIdx + 1 .. treeStartIdx + N) {
        tree[idx.toInt()] = StringTokenizer(br.readLine()).nextToken().toLong()
    }

//    println(tree)

    fun setTree(idx: Int) {
        var index = idx
        while(index > 1) {
            tree[index / 2] = minOf(tree[index / 2], tree[index])
            index --
        }
    }

    fun getMin(s: Long, e: Long): Long {
        var start = s + treeStartIdx
        var end = e + treeStartIdx
        var tmpMin = Long.MAX_VALUE

        while(start <= end) {

            if(start % 2 == 1L) {
                tmpMin = minOf(tree[start.toInt()], tmpMin)
                start ++
            }

            if(end % 2 == 0L) {
                tmpMin = minOf(tree[end.toInt()], tmpMin)
                end  --
            }

            start /= 2
            end /= 2
        }

        return tmpMin
    }

    setTree(treeSize - 1)

    repeat(M.toInt()) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        println(getMin(a, b))
    }

//    println(tree)





}