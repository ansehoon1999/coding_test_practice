
fun main () = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val m = str[0].toInt()
    val n = str[1].toInt()

    val arr = Array<Boolean> (n+1) { false }

    arr[0] = true
    arr[1] = true

    for (i in 2 .. (Math.sqrt((n+1).toDouble())).toInt()) {
        if (arr[i]) continue

        for (j in i*i until  n+1 step i) {
            if (!arr[j]) {
                arr[j] = true
            }
        }
    }

    val sb = StringBuilder()
    for (i in m .. n) {
        if(!arr[i]) {
            sb.append(i)
            sb.append(' ')
        }
    }

    print(sb)

}

