
val doing = listOf<Char>('D', 'S', 'L', 'R')
var visited = MutableList<Boolean>(10001) { false }

val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()){
    val T = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(T) {
        visited = MutableList<Boolean>(10001) { false }

        val input = readLine().split(' ').toList()
        val a = input[0].toInt()
        val b = input[1].toInt()

        val x = BFS(a, b)
        bw.write(x + "\n")

    }

    bw.close()
}

fun BFS(a: Int, b: Int) : String{


    val deque = ArrayDeque<Pair<Int, String>>()
    deque.add(Pair(a, ""))
    visited[a] = true

    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()

        var next = (node.first*2)%10000
        if(next==b){
            return node.second+"D"
        }
        if (!visited[next]) {
            deque.add(Pair(next, node.second +  "D"))
            visited[next] = true
        }
        next = if(node.first-1 <0) 9999 else node.first-1
        if(next==b){
            return node.second+"S"
        }
        if(!visited[next]){
            deque.add(Pair(next,node.second+"S"))
            visited[next]=true
        }
        //L
        next = (node.first%1000)*10+node.first/1000
        if(next==b){
            return node.second+"L"
        }
        if(!visited[next]){
            deque.add(Pair(next,node.second+"L"))
            visited[next]=true
        }
        //R
        next = (node.first%10)*1000+(node.first/10)%1000
        if(next==b){
            return node.second+"R"
        }
        if(!visited[next]) {
            deque.add(Pair(next, node.second +"R"))
            visited[next] = true
        }
    }

    return "NO"
}