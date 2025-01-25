import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, K) = br.readLine().split(" ").map { it.toLong() }

    var treeHeight = 0L
    var length = N

    while(length != 0L) {
        length /= 2
        treeHeight ++
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    var tree = MutableList<Long>(treeSize) { 0L }
    var startLeftIdx = treeSize / 2 - 1

    for(idx in startLeftIdx + 1 .. startLeftIdx + N) {
        tree[idx.toInt()] = StringTokenizer(br.readLine()).nextToken().toLong()
    }


    fun setTree(idx: Int) {
        var index = idx

        while(index > 1) {
            tree[index / 2] += tree[index]
            index --
        }
    }

    setTree(treeSize - 1)

    fun changeValue(idx: Int, value: Long) {
        var index = startLeftIdx + idx
        val diff = value - tree[index]

        while(index > 0) {
            tree[index] += diff
            index /= 2
        }
    }

    fun getSum(s: Long, e: Long): Long {
        var start = s + startLeftIdx
        var end = e + startLeftIdx
        var partSum = 0L

        while(start <= end) {

            if(start % 2 == 1L) {
                partSum += tree[start.toInt()]
                start ++
            }

            if(end % 2 == 0L) {
                partSum += tree[end.toInt()]
                end --
            }

            start /= 2
            end /= 2
        }

        return partSum
    }



    for(i in 0 until M+K) {
        val (question, a, b) = br.readLine().split(" ").map { it.toLong() }
        if(question == 1L) {
            changeValue(a.toInt(), b)
        } else if(question == 2L) {
            println(getSum(a, b))
        }
    }


}