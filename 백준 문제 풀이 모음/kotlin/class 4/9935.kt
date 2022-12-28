import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val stk = Stack<Char>()

    val input1 = readLine().toCharArray()
    val input2 = readLine().toCharArray()
    val input2_final = input2[input2.size-1]

    for (i in 0 until input1.size) {
        val stk_input = input1[i]
        stk.add(stk_input)

        var count = 0
        if (input2_final.equals(stk_input)) {
            if (stk.size < input2.size) continue

            for (j in 0 until input2.size) {
                if (stk[stk.size - input2.size + j] == input2[j]) {
                    count++
                } else {
                    break
                }
            }
        }

        if (count == input2.size) {
            repeat(input2.size) {
                stk.pop()
            }
        }
//        println(stk)
    }

    val sb = StringBuilder()
    if (stk.empty()) {
        sb.append("FRULA")
    } else {
        stk.forEach {
            sb.append(it)
        }
    }
    print(sb)


}


