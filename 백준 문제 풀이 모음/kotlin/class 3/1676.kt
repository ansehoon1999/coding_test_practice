package class3

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()

    var two = 0
    var five = 0

    if (n == 0) {
        println(0)
    } else {
        for (i in 1..n) {

            var divide1 = i
            while (true) {
                if (divide1 % 2 != 0) {
                    break
                }

                divide1 = divide1 / 2
                two++
            }

            var divide2 = i
            while (true) {
                if (divide2 % 5 != 0) {
                    break
                }

                divide2 = divide2 / 5
                five++
            }

//        println("${two} ${five}")
        }


    println(Math.min(two, five))
    }

}

