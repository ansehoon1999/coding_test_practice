import java.util.*


lateinit var parent : MutableList<Int>
lateinit var know_truth : MutableList<Boolean>

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(' ').toList().map { it.toInt() }
    // n = 사람 수, m = 파티 수
    parent = MutableList<Int>(n+1) { it }

    know_truth = MutableList<Boolean>(n+1) { false }

    val input = StringTokenizer(readLine())
    val num = input.nextToken().toInt()
    repeat(num) {
        know_truth[input.nextToken().toInt()] = true
    }

    val party = MutableList<MutableList<Int>>(m) { MutableList<Int> (0) { 0 } }
    repeat(m) {i ->
        val input = StringTokenizer(readLine())
        val num2 = input.nextToken().toInt() // 파티에 참여한 사람 수
        for (j in 0 until num2) {
            party[i].add(input.nextToken().toInt())

            if (j > 0) union(party[i][j], party[i][j-1])
        }
    }


    var ans = 0

    party.forEach {
        var state = true
        for (i in 0 until it.size) {
            if (!know_truth[find(it[i])])  {
                state = false
                break
            }
        }
        if (!state) {
            ans ++
        }
    }
    print(ans)
//    val result = mutableListOf<Int>()
//    for (i in 0 until know_truth.size) {
//        if (know_truth[i]) result.add(i)
//    }
//
//    var count = 0
//    repeat (m) {i ->
//        for (j in 0 until party[i].size) {
//            if (result.contains(party[i][j])) {
//                count ++
//                break
//            }
//        }
//
//    }
//    println(count)
}

fun union(a: Int, b: Int) {
    val a = find(a)
    val b = find(b)

    if (know_truth[a] && know_truth[b]) return

    if (know_truth[a]) parent[b] = a
    else if (know_truth[b]) parent[a] = b

    else {
        if (a < b) parent[b] = a
        else parent[a] = b
    }
}

fun find(x: Int): Int {
    if (x != parent[x]) {
        parent[x] = find(parent[x])
    }

    return parent[x]
}
