

var arr = Array<Int>(0) { 0 }
fun main () = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val k = str[1].toInt()
    arr = Array<Int> (200001) { 0 }

    BFS(n, k)

}

fun BFS(n: Int, k : Int) {
    val deque = ArrayDeque<Int>()
    deque.add(n)

    while (deque.size != 0) {
        val node = deque.removeFirst()
        if (node == k) {
            println(arr[node])
            break
        }

        val list = listOf<Int>(node * 2, node-1, node+1)
        list.forEach {
            if ( (0 <= it && it < 200001) && arr[it] == 0 ) {
                if (it == node * 2) {
                    arr[it] = arr[node]
                    deque.add(it)
                } else {
                    arr[it] = arr[node] + 1
                    deque.add(it)
                }

            }
        }
    }
}