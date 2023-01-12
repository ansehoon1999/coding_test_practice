



private lateinit var edge : MutableList<Triple<Int,Int, Int>>
private lateinit var parent : MutableList<Int>

fun find(num: Int): Int {
    if (num == parent[num]) return num

    parent[num] = find(parent[num])
    return parent[num]

}

fun union(num1 :Int, num2:Int) {
    val one = find(num1)
    val two = find(num2)

    if (one < two) parent[two] = one
    else parent[one] = two
}

fun main() {
    val sb = System.`in`.bufferedReader()
    val (s,e) = sb.readLine().split(' ').map { it.toInt() }

    edge = MutableList<Triple<Int,Int, Int>>(0) { Triple(0,0,0) }
    parent = MutableList<Int>(s+1) { it }

    repeat(e) {
        val input = sb.readLine().split(' ').map { it.toInt() }
        edge.add(Triple(input[2], input[0], input[1]))
    }

    edge.sortBy { it.first }

    var sum = 0
    edge.forEach {
        if (find(it.second) != find(it.third)) {
            union(it.second, it.third)
            sum += it.first
        }
    }

    println(sum)
}


