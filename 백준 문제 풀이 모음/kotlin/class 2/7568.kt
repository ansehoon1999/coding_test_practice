import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array<Pair<Int, Int>>(n) { Pair(0,0)}
    val rank = Array<Int> (n) { 1 }
    for ( i in 0 until n) {
        val str = StringTokenizer(readLine())
        val x = str.nextToken().toInt()
        val y = str.nextToken().toInt()
        arr.set(i, Pair(x, y))
    }


    for ( i in 0 until n) {
        for ( j in 0 until n) {
            if (arr.get(i).first.equals(arr.get(j).first) && arr.get(i).second.equals(arr.get(j).second)) {
                continue
            }

            if (arr.get(i).first < arr.get(j).first && arr.get(i).second < arr.get(j).second) {
                rank[i] += 1
            }
        }
    }

    for (i in rank) {
        print(i.toString() + ' ')
    }

}