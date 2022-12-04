import kotlin.math.roundToInt

fun getAverage(numberList : MutableList<Int>) : Int {
    return numberList.average().roundToInt()
}

fun getMid(numberList : MutableList<Int>) : Int {
    val sortedList = numberList.sorted()
    val mid = numberList.size / 2
    return sortedList[mid]
}

fun getFreq(numberList : MutableList<Int>) : Int {
    val freqMap = numberList.groupingBy { it }.eachCount()
    val maxValue = freqMap.maxOf { it.value }
    val maxFreqMap = freqMap.filter { it.value == maxValue }
    val mapKeys = maxFreqMap.keys.sorted()

    return if (mapKeys.size == 1) {
        mapKeys.first()
    } else {
        mapKeys[1]
    }
}

fun getRange(numberList : MutableList<Int>) : Int {
    val maxValue = numberList.maxOf { it }
    val minValue = numberList.minOf { it}
    return maxValue - minValue
}

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val numberList = mutableListOf<Int>()
    repeat(n) {
        numberList.add(readLine().toInt())
    }

    println(getAverage(numberList))
    println(getMid(numberList))
    println(getFreq(numberList))
    println(getRange(numberList))
}