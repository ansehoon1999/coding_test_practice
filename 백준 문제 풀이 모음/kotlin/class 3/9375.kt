

fun main()= with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()

    repeat(T) {
        val n = readLine().toInt()
        val map = mutableMapOf<String, Int>()

        repeat(n) {
            val type = readLine().split(' ')
            val detail = type[0].toString()
            val top = type[1].toString()

            if (map[top] == null) {
                map[top] = 1
            } else {
                map[top] = map[top]!! + 1
            }
        }

        var sum = 1
        map.forEach {
            sum *= (it.value + 1)
        }

        println(sum-1)


    }



}