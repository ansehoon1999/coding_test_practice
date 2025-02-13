import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val list = MutableList<Int>(n) { it + 1 }

    val str = StringTokenizer(br.readLine())
    val op = str.nextToken().toInt()

    if (op == 1) {
        val target = str.nextToken().toLong()
        val answer = MutableList<Int>(n) { 0 }

        solve1(list, target, answer)
        answer.forEach {
            print("${it} ")
        }
    } else if (op == 2) {
        val target = mutableListOf<Long>()
        repeat(n) {
            target.add(str.nextToken().toLong())
        }

        println(solve2(list, target, 1L))
    }
}


fun solve1(list: MutableList<Int>, target: Long, answer: MutableList<Int>) {
//    println("list: ${list}, target: ${target}, answer: ${answer}")

    if(list.isEmpty()) {
        return
    }

    val fac = factorial(list.size.toLong() - 1)
    val idx = (target - 1) / fac
    val x = list.removeAt(idx.toInt())
    answer[answer.size - list.size - 1] = x

    solve1(list, target - fac * idx, answer)
}

fun solve2(list: MutableList<Int>, target: MutableList<Long>, answer: Long): Long {
//    println("list: ${list}, target: ${target}, answer: ${answer}")

    if(list.isEmpty()) {
        return answer
    }

    val fac = factorial(list.size.toLong() - 1)
    val x = target[target.size - list.size].toInt()
    val idx = list.indexOf(x)
    list.remove(x)

    return solve2(list, target, answer + (idx * fac))
}


fun factorial(n: Long): Long {
    if(n == 0L) {
        return 1
    }

    return n * factorial(n-1)
}













