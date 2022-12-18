

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val list = MutableList<Int>(21) { 0 }
    val sb = StringBuilder()

    repeat(n) {
        val input = readLine().split(' ').toList()

        when(input[0]) {
            "add" -> {
                val cost = input[1].toInt()
                list[cost] = 1
            }
            "remove" -> {
                val cost = input[1].toInt()
                if (list[cost] == 1) {
                    list[cost] = 0
                }
            }
            "check" -> {
                val cost = input[1].toInt()
                if (list[cost] == 1) sb.append(1)
                else sb.append(0)

                sb.append('\n')
            }
            "toggle" -> {
                val cost = input[1].toInt()
                if (list[cost] == 1) list[cost] = 0
                else list[cost] = 1
            }
            "all" -> {
                for(i in 1 .. 20) {
                    list[i] = 1
                }
            }
           "empty" -> {
               for(i in 1 .. 20) {
                   list[i] = 0
               }
           }
        }

    }

    println(sb.toString())

}
