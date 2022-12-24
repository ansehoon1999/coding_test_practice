import java.lang.Math.abs


var n = -1
var sum = 0
var matrix = Array(15) { 0 }
fun main() = with(System.`in`.bufferedReader()){
    n = readLine().toInt()

    dfs(1)

}

fun dfs(x: Int) {
    if (x == n) sum ++
    else {
        for (i in 0 until n) {
            matrix[x] = i
            if (check(x)) dfs(x+1)
        }
    }
}

fun check (x : Int) : Boolean {

    for (i in 0 until x) {
        if (matrix[i] == matrix[x] || abs(matrix[i] - matrix[x]) == abs(i - x)) return false
    }
    return true

}


