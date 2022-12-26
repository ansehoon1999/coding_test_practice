

private lateinit var matrix : MutableList<MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()){

    val input1 = readLine().toCharArray()
    val input2 = readLine().toCharArray()

    matrix = MutableList<MutableList<Int>>(input1.size + 1) { MutableList<Int>(input2.size + 1) { 0 } }



    for (i in 0 until input1.size) {
        for (j in 0 until input2.size) {
//            println("${input1.get(i)} ${input2.get(j)}")
            if (input1.get(i).equals(input2.get(j))) {
                matrix[i+1][j+1] = matrix[i][j] + 1
            } else {
                matrix[i+1][j+1] = Math.max(matrix[i+1][j], matrix[i][j+1])
            }
        }
    }

//    matrix.forEach {
//        println(it)
//    }

    println(matrix[input1.size][input2.size])
}

