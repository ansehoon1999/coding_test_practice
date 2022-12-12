package class3

fun main () = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()

    val list = MutableList<Int>(x+2) { 0 }
    list[2] = 1

    for ( i in 3..x) {
        var three = false
        var two = false
        if (i % 3 == 0) {
            three = true
        }
        if (i % 2 == 0) {
            two = true
        }

        if (three == true && two == true) {
            list[i] = Math.min(list[i/3]+1, list[i/2] + 1)
            list[i] = Math.min(list[i], list[i-1] + 1)
        } else if (three == true && two == false) {
            list[i] = list[i/3]+1
            list[i] = Math.min(list[i], list[i-1] + 1)
        } else if (three == false && two == true) {
            list[i] = list[i/2]+1
            list[i] = Math.min(list[i], list[i-1] + 1)
        } else {
            list[i] =  list[i-1] + 1
        }



    }
    println(list[x])


}