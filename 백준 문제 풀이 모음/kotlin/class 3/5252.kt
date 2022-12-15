


fun main () = with(System.`in`.bufferedReader()) {

    repeat(100) {
        val n = readLine().toInt()
        val m = readLine().toInt()
        val s = readLine().toCharArray()
        val s_count = MutableList<Int>(m) { 0 }
        var first = true
        var result = 0
        for (i in 0 until m) {
            if (s[i].equals('I')) {
                if (first) {
                    s_count[i] = 1
                    first = false
                } else {
                    if (s[i].equals('I') && s[i - 1].equals('I')) {
                        s_count[i] = 1
                        continue
                    }
                    if (s[i - 1].equals('O') && s[i - 2].equals('I')) {
                        s_count[i] = s_count[i - 2] + 1
                    } else {
                        s_count[i] = 1
                    }
                }

                if (s_count[i] > n) result++
            }
        }
        println(s_count)

        if (result-1 == -1) {
            println(0)
        }else {
            println(result)
        }
    }
}