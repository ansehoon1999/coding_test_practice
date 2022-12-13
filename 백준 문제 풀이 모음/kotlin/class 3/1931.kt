package class3

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val arr = MutableList<Pair<Int, Int>>(0) { Pair(0,0)}

    repeat(n) {
        val str = readLine().split(' ').toList()
        val a = str[0].toInt()
        val b = str[1].toInt()

        arr.add(Pair(a,b))
    }


    arr.sortBy {
        it.first
    }
    arr.sortBy {
        it.second
    }
//    arr.forEach {
//        print(it.first)
//        print(' ')
//        print(it.second)
//        println()
//    }


    var count = 0
    var now = 0

    arr.forEach {
        if (it.first >= now) {
            count ++
            now = it.second
        }
    }



    println(count)
}