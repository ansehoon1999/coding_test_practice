import java.util.StringTokenizer


fun main() = with(System.`in`.bufferedReader()) {
    val test_case = readLine().toInt()

    for (i in 0 until test_case) {
        val str = StringTokenizer(readLine())
        val n = str.nextToken().toInt()
        val m = str.nextToken().toInt()

        val list1 : MutableList<Int> = mutableListOf()
        val list2 : MutableList<Boolean> = mutableListOf()

        val arr = StringTokenizer(readLine())
        for ( i in 0 until n) {
            list1.add(arr.nextToken().toInt())
            if (i == m ) {
                list2.add(true)
            } else {
                list2.add(false)
            }
        }
        var cnt = 1
        while (true) {
            var state = true
            for (i in 1 until list1.size) {
                if (list1[0] < list1[i]) {
                    val first1 = list1[0]
                    val first2 = list2[0]

                    list1.removeAt(0)
                    list1.add(first1)
                    list2.removeAt(0)
                    list2.add(first2)

                    state = false
                    break
                }
            }

            if (state) {
                if (list2[0]) {
                    println(cnt)
                    break
                } else {

                    list1.removeAt(0)
                    list2.removeAt(0)

                    cnt++
                }
            }
        }
    }
}