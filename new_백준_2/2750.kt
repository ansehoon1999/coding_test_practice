import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val list = mutableListOf<Int>()

    repeat(n) {
        list.add(br.readLine().toInt())
    }

    for(i in 0 until n) {
        for(j in 0 until n-1-i) {
            if(list[j] > list[j+1]) {
                val temp = list[j]
                list[j] = list[j+1]
                list[j+1] = temp
            }
        }
    }

    list.forEach {
        println(it)
    }
}














