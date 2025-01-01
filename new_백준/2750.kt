fun main() {

    val n = readln().toInt()

    val list = mutableListOf<Int>()
    repeat(n) {
       val value = readln().toInt()

        list.add(value)
    }

    for(i in 0 until n) {
        for(j in 0 until n-1-i) {

            if(list[j] > list[j+1]) {
                val tmp = list[j]
                list[j] = list[j+1]
                list[j+1] = tmp
            }
        }
    }

    val sb = StringBuilder()
    list.forEach {
        sb.append(it)
        sb.append("\n")
    }

    println(sb.toString())
}

