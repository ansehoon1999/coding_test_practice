package class3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list1 = mutableListOf<Int>()
    val first = MutableList<Int>(n+1) { 0 }
    val second = MutableList<Int>(n+1) { 0 }
    repeat(n) {
        val input = readLine().toInt()
        list1.add(input)
    }
    list1.add(0)
    first[0] = list1[0]
    first[1] = list1[1]
    second[1] = list1[1] + first[0]

    for (i in 2 until n) {
        first[i] = list1[i] + Math.max(first[i-2],second[i-2])
        second[i] = list1[i] + first[i-1]
    }

    println(Math.max(first[n-1], second[n-1]))
//    first.forEach {
//        print(it)
//        print(' ')
//    }
//    println()
//    second.forEach {
//        print(it)
//        print(' ')
//    }
//    println()

}