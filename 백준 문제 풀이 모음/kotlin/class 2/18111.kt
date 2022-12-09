import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()
    val b = str[2].toInt()

    val arr = Array(n) { Array<Int>(m) {0} }

    var max_height = -1
    var min_height = 257

    for (i in 0 until n) {
        val st = StringTokenizer(readLine(), " ")
        for (j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
            max_height = Math.max(max_height, arr[i][j])
            min_height = Math.min(min_height, arr[i][j])
        }
    }

//    println(max_height)
//    println(min_height)

    var mintime = 1000000000
    var minheight = 0
    for (i in 0 .. 256) {
        var minus = 0
        var plus = 0
        arr.forEach {
            it.forEach {
                if (it - i > 0) {
                    minus += (it - i)
                } else if (it - i < 0){
                    plus += (i - it)
                }
            }
        }

        if (plus > minus + b) {
            continue
        }


        if (mintime >= minus * 2 + plus ) {
            mintime = minus * 2 + plus
            minheight = i
        }



//        println(minus)
//        println(plus)

    }

//    arr.forEach {
//        it.forEach {
//            print(it)
//        }
//        println()
//    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("${mintime} ${minheight}")
    bw.flush()
    bw.close()
//    println(mintime)
//    println(minheight)


}