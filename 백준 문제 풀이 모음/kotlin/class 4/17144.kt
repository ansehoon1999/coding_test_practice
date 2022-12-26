

private lateinit var matrix : MutableList<MutableList<Int>>
private val dr = listOf<Int>(1,-1,0,0)
private val dc = listOf<Int>(0,0,1,-1)


fun main() = with(System.`in`.bufferedReader()){
    val (r, c, t) = readLine().split(' ').map { it.toInt() }

    matrix = MutableList<MutableList<Int>>(r) { MutableList<Int> (c) { 0 } }

    var result = MutableList<MutableList<Int>>(r) { MutableList<Int> (c) { 0 } }
    for (i in 0 until r) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        for (j in 0 until c ) {
            matrix[i][j] = input[j]
        }
    }

//    matrix.forEach {
//        println(it)
//    }
//    println()

    repeat(t) {
        var new_matrix = process1(r, c)

        process2(r, c, new_matrix)

//        for (i in 0 until r) {
//            for (j in 0 until c) {
//                matrix[i][j] = result[i][j]
//            }
//        }

//        matrix.forEach {
//            println(it)
//        }
//        println()

    }

    var sum = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (matrix[i][j] != -1) {
                sum += matrix[i][j]
            }
        }
    }
    val sb = StringBuilder()
    sb.append(sum)
    print(sb)
}

fun process2(r: Int, c: Int, newnew_matrix : MutableList<MutableList<Int>>)  {
//    val new_matrix = MutableList<MutableList<Int>>(r) { MutableList<Int> (c) { 0 } }


    var cleaner1 = Pair(0,0)
    var cleaner2 = Pair(0,0)
    for (i in 0 until r) {
       if (newnew_matrix[i][0] == -1) {
           cleaner1 = Pair(i, 0)
           break
       }
    }
    cleaner2 = Pair(cleaner1.first + 1, 0)
    matrix[cleaner1.first][0] = -1
    matrix[cleaner2.first][0] = -1

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (i <= cleaner1.first) {
                if (i == 0) {
                    if (0 <= j - 1) {
                        matrix[i][j - 1] = newnew_matrix[i][j]
                    }
                }
                if (i == cleaner1.first) {
                    if (newnew_matrix[i][j] == -1) matrix[i][j + 1] = 0
                    else {
                        if (j + 1 < c) {
                            matrix[i][j + 1] = newnew_matrix[i][j]
                        }
                    }
                }


                if (j == 0){
                    if (i + 1 == cleaner1.first) matrix[i+1][j] = -1
                    else if (i + 1 < cleaner1.first)  {
                        matrix[i+1][j] = newnew_matrix[i][j]
                    }
                }


                if (j == c - 1) {
                    if (0 <= i - 1) {
                        matrix[i-1][j] = newnew_matrix[i][j]
                    }
                }

                if (i != 0 && i != cleaner1.first && j != 0 && j != c-1) {
                    matrix[i][j] = newnew_matrix[i][j]
                }
            }
            else {
                if (i == cleaner2.first) {
                    if (newnew_matrix[i][j] == -1) matrix[i][j + 1] = 0
                    else {
                        if (j + 1 < c) {
                            matrix[i][j + 1] = newnew_matrix[i][j]
                        }
                    }
                }
                if (i == r-1) {
                    if (0 <= j - 1) {
                        matrix[i][j - 1] = newnew_matrix[i][j]
                    }
                }

                if (j == 0){
                    if (i - 1 == cleaner2.first) matrix[i-1][j] = -1
                    else if (i - 1 > cleaner2.first)  {
                        matrix[i-1][j] = newnew_matrix[i][j]
                    }
                }

                if (j == c - 1) {
                    if (i+1 < r) {
                        matrix[i+1][j] = newnew_matrix[i][j]
                    }
                }

                if (i != r-1 && i != cleaner2.first && j != 0 && j != c-1) {
                    matrix[i][j] = newnew_matrix[i][j]
                }

            }


        }
    }



//    newnew_matrix.forEach {
//        println(it)
//    }
//    println()

}

fun process1(r: Int, c: Int) : MutableList<MutableList<Int>>{
    val new_matrix = MutableList<MutableList<Int>>(r) { MutableList<Int> (c) { 0 } }

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (matrix[i][j] == -1) {
                new_matrix[i][j] = -1
                continue
            }
            var sum = 0
            var count = 0
            if (0<= i-1 && i-1 < r && 0<= j && j < c && matrix[i-1][j] != -1) {
                sum += (matrix[i-1][j] / 5)
                count++
            }
            if (0<= i && i < r && 0<= j-1 && j-1 < c && matrix[i][j-1] != -1) {
                sum += (matrix[i][j-1] / 5)
                count++
            }
            if (0<= i+1 && i+1 < r && 0<= j && j < c && matrix[i+1][j] != -1) {
                sum += (matrix[i+1][j] / 5)
                count++
            }
            if (0<= i && i < r && 0<= j+1 && j+1 < c && matrix[i][j+1] != -1) {
                sum += (matrix[i][j+1] / 5)
                count++
            }

            sum += (matrix[i][j] - (matrix[i][j] / 5 * count))

            new_matrix[i][j] = sum
        }
    }



    return new_matrix
}


