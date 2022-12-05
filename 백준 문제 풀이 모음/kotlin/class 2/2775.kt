
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val test_case = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(test_case) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()

        val arr = Array(k+1) {
            Array(n+1) { 0 }
        }

        for (i in 1..n) {
            arr[0][i] = i
//            println(arr[0][i])
        }


        for (i in 1..k) {
            for (j in 1..n) {
                for (x in 1..j) {
                    arr[i][j] += arr[i-1][x]
                }

            }
        }
        println(arr[k][n])
//        bw.write(arr[k][n].toString())

    }


}