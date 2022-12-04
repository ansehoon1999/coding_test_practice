

fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val generate = mutableListOf<Int>()
    for (i in n-1 downTo 1) {
        val list = i.toString().toList()
        var result = i
        for (i in 0 until list.size) {
            result += Character.getNumericValue(list.get(i))
        }

        if (result == n) {
            generate.add(i)
        }
    }

    if (generate.size == 0) {
        println(0)
    } else {
        println(generate[generate.size -1])
    }
}