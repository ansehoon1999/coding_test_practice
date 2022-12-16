import java.util.*

private val treeMap = TreeMap<Int, Int>()
val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        val k = readLine().toInt()

        repeat(k) {
            val input = readLine().split(' ').toList()
            val type = input[0]
            val num = input[1].toInt()
            when (type) {
                "I" -> {
                    input(num)
                }
                "D" -> {
                   delete(num)
                }

            }


        }

        if (treeMap.isEmpty()) {
            sb.append("EMPTY").append('\n')
        } else {
            sb.append(treeMap.lastKey()).append(' ')
                .append(treeMap.firstKey()).append('\n')
        }


        treeMap.clear()

    }

    println(sb.toString())
}

fun input(num: Int) {
    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1)
}

fun delete(num: Int) {
    if (treeMap.isNotEmpty()) {
        if (num == 1) {
            val maxNum = treeMap.lastKey()
            val defaultNum = treeMap.remove(maxNum)
            if (defaultNum == 1) {
                treeMap.remove(maxNum)
            } else if (defaultNum != null) {
                treeMap.put(maxNum, defaultNum -1)
            }
        } else {
            val minNum = treeMap.firstKey()
            val defaultNum = treeMap.remove(minNum)
            if (defaultNum == 1) {
                treeMap.remove(minNum)
            } else if (defaultNum != null) {
                treeMap.put(minNum, defaultNum -1)
            }
        }
    }
}
