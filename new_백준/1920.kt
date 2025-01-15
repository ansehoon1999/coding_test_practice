import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val nList = mutableListOf<Long>()

    st = StringTokenizer(br.readLine())

    repeat(n) {
        val nNum = st.nextToken().toLong()
        nList.add(nNum)
    }

    nList.sort()

    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()

    val sb = StringBuilder()
    st = StringTokenizer(br.readLine())

    repeat(m) {
        val mNum = st.nextToken().toLong()
        val isFound = binarySearch(mNum, nList)

        if(isFound) {
            sb.append(1)
        } else {
            sb.append(0)
        }
        sb.append("\n")
    }

    println(sb.toString())

    //    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun binarySearch(target: Long, nList: List<Long>): Boolean {

    var low = 0
    var high = nList.lastIndex

    while(low <= high) {
        val mid = (low + high) / 2

        if(nList[mid] < target) {
            low = mid + 1
        } else if(nList[mid] > target) {
            high = mid - 1
        } else {
            return true
        }
    }

    return false
}
