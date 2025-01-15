import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()


    val list = mutableListOf<Int>()
    var answer = 0

    repeat(n) {
        st = StringTokenizer(br.readLine())
        list.add(st.nextToken().toInt())
    }

    for(coin in list.lastIndex downTo 0) {

        if(k / list[coin] != 0) {

            answer += (k / list[coin])
            k %= list[coin]
        }
    }

    println(answer)

    //    bw.write("$sum")
    bw.flush()
    bw.close()
}


