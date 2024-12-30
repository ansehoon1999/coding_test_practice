fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }
    val nList = (listOf(0L) + readln().split(" ").map { it.toLong() }).toMutableList()

    for (idx in 1..n) {
        nList[idx] += nList[idx - 1]
        nList[idx] %= m.toLong()
    }

    var result = 0L
    val hashMap = hashMapOf<Long, Long>()

    for (idx in 1..n) {
        val curValue = nList[idx]

        if(curValue == 0L) result += 1

        if (hashMap[curValue] == null) {
            hashMap[curValue] = 1
        } else {
            hashMap[curValue] = hashMap[curValue]!! + 1
        }
    }

    for((key, value) in hashMap) {

        val tmp = (value * (value - 1) / 2)
        result += tmp
    }

    println(result)

}