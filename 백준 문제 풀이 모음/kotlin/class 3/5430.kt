package class3

val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        val arr = readLine().toCharArray() // arr = RDD
        val n = readLine().toInt()
        val input = readLine().removeSurrounding("[", "]").split(',').toMutableList()

        val deque = ArrayDeque<Int>()

        input.forEach {
            if (!it.equals("")) {
                deque.add(it.toInt())
            }
        }
        var err = 0
        var r_count = 0
        for (it in 0 until arr.size) {
            if (arr[it].equals('R')) {
                r_count ++
            } else if(arr[it].equals('D')) {
                if (deque.size < 1) {
                    err = 1
                    println("error")
                    break
                } else {
                    if (r_count % 2 == 0) {
                        deque.removeFirst()
                    } else {
                        deque.removeLast()
                    }
                }
            }
        }
        if (err == 0) {
          if (r_count % 2 != 0) {
              deque.reverse()
              println(deque.toString().replace(", ", ","))

          } else {
              println(deque.toString().replace(", ", ","))

          }
        }
    }
    print(sb.toString())


}