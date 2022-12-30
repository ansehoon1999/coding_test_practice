import java.util.StringTokenizer


data class Building(var idx : Int, var time : Int, var connect: Int, var time_ori : Int)
private lateinit var arr : MutableList<Building>
private lateinit var matrix : MutableList<MutableList<Building>>

fun main() = with(System.`in`.bufferedReader()){
    val T = readLine().toInt()

    repeat(T) {
        val (n, k) = readLine().split(' ').map { it.toInt() }
        matrix = MutableList<MutableList<Building>>(n+1) { mutableListOf() }
        arr = mutableListOf()
        arr.add(Building(0,0,0, 0))
        val input = StringTokenizer(readLine())
        for (i in 1..n) {
            val time = input.nextToken().toInt()
            arr.add(Building(i, time, 0,time))
        }
        repeat(k) {
            val (a, b) = readLine().split(' ').map { it.toInt() }
            matrix[a].add(arr[b])
            arr[b].connect += 1
        }

        val target = readLine().toInt()

//        println(arr)
//        matrix.forEach {
//            println(it)
//        }
//        println()

        val deque = ArrayDeque<Building>()

        for (i in 1 .. n) {
            if (arr[i].connect == 0) {
                deque.add(arr[i])
            }
        }

        while (!deque.isEmpty()) {
//            println(deque)
            val node = deque.removeFirst()
            if (node.idx == target) {
                println(node.time)
                break
            }
            matrix[node.idx].forEach {
                it.connect -= 1

                if (it.time < it.time_ori + node.time) {
                    it.time = it.time_ori + node.time
                }

                if (it.connect == 0) {
                    deque.add(it)
                }

            }


        }
//        println()

    }


}
