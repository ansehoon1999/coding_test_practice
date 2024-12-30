fun main() {

    val count = readln().toInt()
    val pointList = readln().split(" ").map { it.toDouble() }

    val M = pointList.max()

    var sum = 0.0
    pointList.forEach { point ->
        sum += (point / M) * 100L
    }

    val result = sum / count

    println(result)

}