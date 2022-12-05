
fun main () = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val N = readLine().toInt()
    val list :MutableList<Int> = mutableListOf()

    repeat(N) {
        list.add(readLine().toInt())
    }

    list.sort()

    val sb = StringBuilder()
    for (i in 0 until N) {
        sb.append("${list[i]}\n")
    }
    bw.write(sb.toString())
    bw.close()


}