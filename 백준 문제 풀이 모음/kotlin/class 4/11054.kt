

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val arr1 = readLine().split(' ').toList().map { it.toInt() }
    val arr2 = arr1.reversed()

    var count = MutableList<Int>(n) { 1 }
    var count2 = MutableList<Int>(n) { 1 }


    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr1[j] < arr1[i]) {
                count[i] = maxOf(count[i], count[j]+1)
            }
            if (arr2[j] < arr2[i]) {
                count2[i] = maxOf(count2[i], count2[j]+1)
            }
        }
    }

//    println(count)
//    println(count2)
    val result = mutableListOf<Int>()
    for (i in 0 until n) {

        result.add(count[i] + count2[n - i -1] -1)
    }

    print(result.max())
}

