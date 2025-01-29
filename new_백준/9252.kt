import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val str1 = br.readLine().toString()
    val str2 = br.readLine().toString()

//    println("$str1 $str2")

    val dp1 = Array<IntArray>(str1.length + 1) {
        IntArray(str2.length + 1) { 0 }
    }

    for(i in 1 .. str1.length) {
        for(j in 1 .. str2.length) {
            if(str1[i-1] == str2[j-1]) {
                dp1[i][j] = dp1[i-1][j-1] + 1
            } else {
                dp1[i][j] = maxOf(dp1[i][j-1], dp1[i-1][j])
            }
        }
    }

    val result = StringBuilder()

    fun getText(r: Int, c: Int) {
        if (r == 0 || c == 0) return
        if (str1[r - 1] == str2[c - 1]) {
            result.append(str1[r - 1])
            getText(r - 1, c - 1)
        } else {
            if (dp1[r - 1][c] > dp1[r][c - 1]) {
                getText(r - 1, c)
            } else {
                getText(r, c - 1)
            }
        }
    }

    getText(str1.length, str2.length)

    writer.write("${dp1[str1.length][str2.length]}\n")
    if(dp1[str1.length][str2.length] != 0) {
        writer.write(result.reversed().toString())
    }

//    dp1.forEach {
//        println(it)
//    }

    writer.flush()
    writer.close()

}
