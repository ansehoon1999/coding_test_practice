import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val arr = mutableListOf<Int>()
    for (i in 1..n) arr.add(i)

    val st = StringTokenizer(br.readLine())
    val k = st.nextToken().toInt()

    when (k) {
        1 -> {
            val target = st.nextToken().toLong()

            val answer = IntArray(n)

            solve1(arr, answer, n.toLong(), target, 0)

            answer.forEach {
                print("${it} ")
            }

        }

        2 -> {

            val target = mutableListOf<Int>()
            repeat(n) {
                val num = st.nextToken().toInt()
                target.add(num)
            }

            println(solve2(arr, target, 0, 1))
        }

        else -> {}
    }


    writer.flush()
    writer.close()
}

fun solve1(arr: MutableList<Int>, answer: IntArray, n: Long, target: Long, idx: Int) {
//    println("arr: ${arr}, answer: ${answer.toList()}, n: ${n}, target: ${target}, idx: ${idx}")

    if(arr.isEmpty()) {
        return
    }

    val fac = factorial(arr.size.toLong()-1)
    val k = (target-1) / fac
    val x = arr.removeAt(k.toInt())
    answer[idx] = x

    solve1(arr, answer, n, target - (k * fac), idx + 1)
}

fun solve2(arr: MutableList<Int>, target: MutableList<Int>, depth: Int, answer: Long): Long {

    if(arr.isEmpty()) {
        return answer
    }

    val fac = factorial(arr.size.toLong() - 1)
    val a = arr.indexOf(target[depth])
    arr.remove(target[depth])

    return solve2(arr, target, depth+1, answer + (a * fac))
}



fun factorial(n: Long): Long {

    var ans = 1L
    for (i in 1..n) {
        ans *= i
    }
    return ans
}