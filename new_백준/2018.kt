fun main() {

    val n = readln().toInt()

    var sum = 1
    var startIdx = 1
    var endIdx = 1

    var result = 0

    while(endIdx != n + 1) {

        if(sum == n) {
            result += 1
            endIdx += 1
            sum += endIdx
        } else if(sum > n) {
            sum -= startIdx
            startIdx += 1
        } else {
            endIdx += 1
            sum += endIdx
        }

    }

    println(result)


}