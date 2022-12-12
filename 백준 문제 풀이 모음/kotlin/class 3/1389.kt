package class3


var matrix = Array<MutableList<Int>>(0) { MutableList<Int>(0) { 0 } }
var visited = Array<Boolean>(0) { false }

fun main () = with(System.`in`.bufferedReader()) {

    val str1 = readLine().split(' ').toList()
    val n = str1[0].toInt()
    val m = str1[1].toInt()

    matrix = Array<MutableList<Int>>(n+1) { MutableList<Int>(0) { 0 } }

    repeat(m) {
        val str = readLine().split(' ').toList()
        val a = str[0].toInt()
        val b = str[1].toInt()

        matrix[a].add(b)
        matrix[b].add(a)
    }

    var result = 0
    var min :Int = 10000000
    for (person in 1 .. n) {
//        println("person: " + person.toString())
        visited = Array(n+1) { false }
        val bfs = BFS(person)
//        println("result: " + bfs.toString() )
//
//        println("${min} ${bfs}")
        if (min > bfs) {
            min = bfs
//            println(person)
//            println(min)
            result = person
        }
    }

    println(result)

//    println("result: " + result)

//    matrix.forEach {
//        it.forEach {
//            print(it)
//            print(' ')
//        }
//        println()
//    }

}

fun BFS(person: Int) : Int {
    var sum = 0
    var count = -1
    val deque = ArrayDeque<MutableList<Int>>()
    val list = mutableListOf<Int>()
    list.add(person)
    deque.add(list) // deque = [[1]]

    while (deque[0].size != 0 ) {
        count ++
//        println(deque.toString())
        val value = deque.removeFirst() // value = [1]
        sum += (value.size * count) // sum = 1
//        println("sum: " + sum.toString())
//        println("value.size: " + value.size.toString())
//        println("count: " + count.toString())


        val list2 = mutableListOf<Int>()

        value.forEach {
            visited[it] = true // [f, t, f, f, f, f]

            matrix[it].forEach {
                if(!visited[it]) {
                    visited[it] = true
                    list2.add(it)
                }
            }
        }

        deque.add(list2)

    }

    return sum

}
