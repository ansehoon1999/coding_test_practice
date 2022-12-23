

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val arr1 = readLine().split(' ').map { it.toInt() }.toMutableList()
    val arr2 = mutableListOf<Int>()

    arr1.forEach {
        arr2.add(it)
    }

    repeat(n-1) {
        val input = readLine().split(' ').map { it.toInt() }.toMutableList()
        // input = [4,5,6]

        var sub1 = input[0] + arr1[0]
        var sub2 = input[0] + arr1[1]

        //======================================

        var sub3 = input[1] + arr1[0]
        var sub4 = input[1] + arr1[1]
        var sub5 = input[1] + arr1[2]

        //======================================

        var sub6 = input[2] + arr1[1]
        var sub7 = input[2] + arr1[2]

        arr1[0] = Math.max(sub1, sub2)
        arr1[1] = Math.max(sub3, Math.max(sub4, sub5))
        arr1[2] = Math.max(sub6, sub7)

        val sub11 = input[0] + arr2[0]
        val sub21 = input[0] + arr2[1]

        //======================================

        val sub31 = input[1] + arr2[0]
        val sub41 = input[1] + arr2[1]
        val sub51 = input[1] + arr2[2]

        //======================================

        val sub61 = input[2] + arr2[1]
        val sub71 = input[2] + arr2[2]

        arr2[0] = Math.min(sub11, sub21)
        arr2[1] = Math.min(sub31, Math.min(sub41, sub51))
        arr2[2] = Math.min(sub61, sub71)
    }

    val sb = StringBuilder()
    sb.append(arr1.max())
    sb.append(' ')
    sb.append(arr2.min())

    print(sb.toString())

}
