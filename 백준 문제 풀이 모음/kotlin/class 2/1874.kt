

val list = mutableListOf<Int>()
val type = mutableListOf<Char>()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var xxx = 0
    var final = 1
    for (i in 0 until n) {
        val num = readLine().toInt()

        if (num > final) {
            while (num > final) {
                list.add(final)
                type.add('+')
                final += 1
            }
            final += 1
            list.add(final)
            type.add('+')
            list.removeAt(list.size -1)
            type.add('-')
        } else if (num < final) {
            if (list.size == 0) {
                xxx = 1
                continue
            }

            while (true) {
                if (list.size == 0) {
                    xxx = 1
                    break
                }
                if (list.get(list.size -1) == num) {
                    list.removeAt(list.size -1)
                    type.add('-')
                    break
                }
                list.removeAt(list.size -1)
                type.add('-')
            }

        } else if (num == final) {
            type.add('+')
            type.add('-')
            final += 1
        }


    }

    if (xxx == 1) {
        println("NO")
    } else {
        for (i in 0 until type.size) {
            println(type.get(i))
        }
    }

}