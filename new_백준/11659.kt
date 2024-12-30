fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }

    val nList = (listOf(0) + readln().split(" ").map { it.toInt()}).toMutableList()
    for(idx in 1 until nList.size) {
        nList[idx] += nList[idx - 1]
    }

    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }

        val result = nList[j] - nList[i-1]
        println(result)
    }

}