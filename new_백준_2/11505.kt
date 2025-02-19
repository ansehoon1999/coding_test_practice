import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val MOD = 1000000007L

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    var length = n
    var treeHeight = 0

    while (length != 0) {
        treeHeight++
        length /= 2
    }

    val treeSize = Math.pow(2.0, (treeHeight + 1).toDouble()).toInt()
    val tree = MutableList<Long>(treeSize) { 1L }
    val treeStartIdx = treeSize / 2 - 1

    for (idx in treeStartIdx + 1..treeStartIdx + n) {
        tree[idx] = br.readLine().toLong()
    }

    fun setTree(idx: Int) {
        var index = idx

        while (index != 1) {
            tree[index / 2] = ((tree[index / 2] * tree[index]) % MOD)
            index--
        }
    }

    setTree(treeSize - 1)

    fun changeValue(idx: Int, value: Long) {

        var index = idx + treeStartIdx

        tree[index] = value

//        println()

        while(index != 1) {

            if(index % 2 == 1) {
                tree[index / 2] = ((tree[index] * tree[index - 1]) % MOD)
            } else {
                tree[index / 2] = ((tree[index] * tree[index + 1]) % MOD)
            }

//            println("${index} tree: ${tree}")

            index /= 2
        }


    }


    fun getMultiple(s: Int, e: Int): Long {
        var start = s + treeStartIdx
        var end = e + treeStartIdx

        var partMulti = 1L

        while (start <= end) {
            if (start % 2 == 1) {
                partMulti =  (partMulti * tree[start] % MOD)
                start++
            }

            if (end % 2 == 0) {
                partMulti = (partMulti * tree[end] % MOD)
                end--
            }

            start /= 2
            end /= 2
        }

        return partMulti
    }

//    println(tree)


    val sb =StringBuilder()

    repeat(m + k) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        if (a == 1L) {
            changeValue(b.toInt(), c)
//            println(tree)
        } else if (a == 2L) {
            val x = getMultiple(b.toInt(), c.toInt()) % MOD
            sb.append("${x}\n")
        }
    }

    writer.write(sb.toString())


    writer.flush()
    writer.close()
}















