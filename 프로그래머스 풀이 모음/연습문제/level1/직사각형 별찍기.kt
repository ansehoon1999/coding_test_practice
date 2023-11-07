fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)

    val sb = StringBuilder()

    for(row in 0 until b) {
        for(col in 0 until a) {
            sb.append("*")
        }
        sb.append("\n")
    }


    println(sb.toString())
}