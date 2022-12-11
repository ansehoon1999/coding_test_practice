package class3



fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val T = readLine().toInt()


    repeat (T) {

        val str = readLine().split(' ').toList()
        val m = str[0].toInt()
        val n = str[1].toInt()
        val k = str[2].toInt()

        val matrix = Array<Array<Int>> (n) { Array<Int>(m) {0} }
        var result = 0

        repeat(k) {
            val str2 = readLine().split(' ').toList()
            val x = str2[0].toInt()
            val y = str2[1].toInt()

            matrix[y][x] = 1
        }

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (matrix[y][x] == 1) {
                    search_function(x, y, m, n, matrix)
                    result ++
                }
            }
        }

        println(result)
    }





//    matrix.forEach {
//        it.forEach {
//            sb.append(it)
//            sb.append(' ')
//        }
//        sb.append('\n')
//    }
//
//    print(sb.toString())


}

fun search_function(x: Int, y: Int, m: Int, n: Int, matrix: Array<Array<Int>>) {
    if (x<0 || x>=m || y <0 || y>=n) {
        return
    }
    if (matrix[y][x] == 0) {
        return
    }

    matrix[y][x] = 0

    search_function(x+1, y, m, n, matrix)
    search_function(x, y+1, m, n, matrix)
    search_function(x-1, y, m, n, matrix)
    search_function(x, y-1, m, n, matrix)


}

