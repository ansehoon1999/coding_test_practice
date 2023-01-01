import java.util.StringTokenizer


private lateinit var lis_arr : MutableList<Int>
private lateinit var lis_total : MutableList<Pair<Int, Int>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    lis_arr = mutableListOf(-1000000001 )
    lis_total = mutableListOf( Pair(-1000000001, 0))
    val nums = ArrayDeque<Int>()
    val input = StringTokenizer(readLine())
    repeat(n) {
        nums.add(input.nextToken().toInt())
    }

    while (nums.isNotEmpty()) {
        val num = nums.removeFirst()

        if (num > lis_arr.last()) {
            lis_arr.add(num)
            lis_total.add(Pair(num, lis_arr.size -1))
        } else {
            val idx = binary_search(num)
            lis_arr[idx] = num
            lis_total.add(Pair(num, idx))
        }

    }

//    println(lis_arr)
//    println(lis_total)
    var lis_length = lis_arr.size - 1
    val lis = mutableListOf<Int>()

    while (lis_total.isNotEmpty() && lis_length != 0) {
        val (num, idx) = lis_total.removeLast()
//        println("${num} ${idx}")
        if (idx == lis_length) {
            lis.add(num)
            lis_length --
        }
    }

    val sb = StringBuilder()
    sb.append(lis.size)
    sb.append('\n')

//    for (i in lis.size-1 downTo(0)) {
//        if (i == 0) {
//            sb.append(lis[i])
//        } else {
//            sb.append(lis[i])
//            sb.append(' ')
//        }
//    }
    print(sb)
}

fun binary_search(num: Int): Int {
    var low = -1
    var high = lis_arr.size

    while (low+1 < high) {
        val mid = (low + high) / 2

        if (num > lis_arr[mid] ) low = mid
        else high = mid
    }

    return high
}

