
fun main(args : Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val str = System.`in`.bufferedReader().readLine()

    str.forEach {
        when(it) {
            in 'A' .. 'Z' -> it + 32
            else -> it - 32
        }
    }
    bw.flush()
    bw.close()


}