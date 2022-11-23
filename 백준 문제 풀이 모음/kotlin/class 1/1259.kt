fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val tmp = readLine()
        if (tmp.toInt() == 0) {
            break
        }

        val arr = tmp.toCharArray()
        var state = true
        for (i in 0 until (arr.size /2)) {

            if (arr[i] != arr[arr.size -1 - i]) {
                state = false
                break
            }
        }

        if (state) println("yes")
        else println("no")

    }
}