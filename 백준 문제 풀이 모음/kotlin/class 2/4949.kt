
fun main() = with(System.`in`.bufferedReader()) {

    while (true) {
        val arr = ArrayDeque<Char>()
        val str = readLine().toString()
        if(str.equals(".")) {
            break
        }
        val list = str.toCharArray()
        list.forEach {i ->
            if (i.equals('(') || i.equals(')') || i.equals('[') || i.equals(']')) {
                if (arr.isEmpty()) {
                    arr.add(i)
                } else {
                    val last = arr.last()
                    if (last.equals('(') && i.equals(')')) {
                        arr.removeLast()
                    } else if (last.equals('[') && i.equals(']')) {
                        arr.removeLast()
                    } else {
                        arr.add(i)
                    }
                }
            }
        }


        if (arr.isEmpty()) {
            println("yes")

        } else {
            println("no")
        }



    }


}