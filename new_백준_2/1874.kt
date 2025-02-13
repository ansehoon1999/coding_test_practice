import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val stk = Stack<Int>()

    val nList = mutableListOf<Int>()

    repeat(n) {
        val tmp = br.readLine().toInt()
        nList.add(tmp)
    }

    var cnt = 1

    val sb = StringBuilder()

    nList.forEach { num ->

        if(cnt <= num) {
            while(cnt <= num) {
                sb.append("+\n")
                stk.add(cnt)
                cnt ++
            }
            stk.pop()
            sb.append("-\n")
        } else { // 5 > 3
            if(stk.last() == num) {
                stk.pop()
                sb.append("-\n")
            }
        }
    }

    if(stk.isEmpty()) {
        println(sb.toString())
    } else{
        println("NO")
    }


}










