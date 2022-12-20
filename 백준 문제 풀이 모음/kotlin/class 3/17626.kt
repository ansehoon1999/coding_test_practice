

fun main() = with(System.`in`.bufferedReader()){
    val  n = readLine().toInt()

    val list = MutableList<Int>(n+1) { 0 }
    var k = 1
    while (k*k <= n) {
        list[k*k] = 1
        k++
    }

    for (i in 1 .. n) {
        if (list[i] != 0) continue

        var j = 1
        while (j*j <= i) {
            if (list[i] == 0) {
                list[i] = list[j*j] + list[i-j*j]
            } else {
                list[i] = Math.min(list[i], list[j*j] + list[i-j*j])
            }

            j++
        }

    }

    println(list)
    println(list[n])




}