import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Node(
    val b: Int,
    val p: Int,
    val q: Int
)


fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val hashMap = hashMapOf<Int, MutableList<Node>>()
    repeat(n) {
        hashMap[it] = mutableListOf()
    }

    val ratioList = MutableList<Int>(n) { 0 }



    for (i in 0 until n - 1) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val p = st.nextToken().toInt()
        val q = st.nextToken().toInt()

        val gcd = if (p < q) gcd(p, q) else gcd(q, p)

        if(gcd != 1) {
            hashMap[a]?.add(Node(b, p / gcd, q / gcd))
            hashMap[b]?.add(Node(a, q / gcd, p / gcd))
        } else {
            hashMap[a]?.add(Node(b, p, q))
            hashMap[b]?.add(Node(a, q, p))
        }
    }

//    println(hashMap)

    dfs(0, ratioList, hashMap)

    var mgcd = ratioList[0]

    for(idx in 1 until ratioList.size) {
        val cur = ratioList[idx]

        val gcd = if (cur < mgcd) gcd(cur, mgcd) else gcd(mgcd, cur)
        mgcd = gcd
    }

    val sb = StringBuilder()
    ratioList.forEach {
        sb.append("${it/mgcd} ")
    }

    println(sb.toString().trim())


    bw.flush()
    bw.close()
}

fun dfs(start: Int, ratioList: MutableList<Int>, hashMap: HashMap<Int, MutableList<Node>>) {

//    println(ratioList)

    hashMap[start]?.forEach { next ->
        if (ratioList[next.b] == 0) {

            if(ratioList[start] == 0) {
                ratioList[start] = next.p
                ratioList[next.b] = next.q
            } else {

                val curStart = ratioList[start]
                val newStart = next.p

                val gcd = if (next.p < next.q) gcd(next.p, next.q) else gcd(next.q, next.p)

                val lcm = gcd * (curStart / gcd) * (newStart / gcd)

                for(idx in 0 until ratioList.size) {
                    ratioList[idx] = ratioList[idx] * (lcm / curStart)
                }

                ratioList[next.b] = next.q * ((lcm / newStart))
            }

            dfs(next.b, ratioList, hashMap)
        }
    }
}

fun gcd(small: Int, big: Int): Int {


    val els = big % small

    if (els == 0) {
        return small
    }

    return gcd(els, small)
}
Mit