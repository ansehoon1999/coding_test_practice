import java.io.BufferedReader
import java.io.InputStreamReader


data class Node(
    val num: Int,
    val depth: Int
)

const val MOD = 1000000000

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

//    val N = br.readLine().toInt()

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Long>>(202) {
        MutableList<Long>(202) {
            0L
        }
    }



    for(i in 0 until 201) {
        for(j in 0  .. i) {
            if(j == 0 || j == i) {
                matrix[i][j] = 1
            } else {
                matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1]
                if(matrix[i][j] >1000000000 ) {
                    matrix[i][j] = 1000000001
                }
            }
        }
    }

    var totalCnt = matrix[n+m][minOf(n, m)]

//    matrix.forEach {
//        println(it)
//    }

    var N = n
    var M = m
    var K = k.toLong()

    var result = ""

    if(k > matrix[n+m][m]) {
        println(-1)
    } else {


    while(!(N == 0 && M == 0)) {

//        println("result: ${result} total: ${curTotal} ${matrix[curIdx][zCnt]} curIdx: ${curIdx} zCnt: ${zCnt}")

        if(matrix[N + M - 1][M] >= K) {
            N -= 1
            result += "a"
        } else {
            K -= matrix[N -1 + M][M]
            M -= 1

            result += "z"
        }

//        println("result: ${result} total: ${curTotal} ${matrix[curIdx][zCnt]} curIdx: ${curIdx} zCnt: ${zCnt}")
//        println()
    }

        println(result)
    }


//    println("result: ${result} total: ${curTotal} ${matrix[curIdx][zCnt]}")


//    println(totalCnt)
    writer.flush()
    writer.close()

}
