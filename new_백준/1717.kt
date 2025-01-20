import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

lateinit var parent: MutableList<Int>

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    parent = MutableList(n+1) { it }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        if(a == 0) {
            union(b, c)
        } else {

            val b = find(b)
            val c = find(c)

            if(b == c) {
                println("YES")
            } else {
                println("NO")
            }
        }

    }


    bw.flush()
    bw.close()
}

fun find(a: Int): Int {
    if(a == parent[a]) {
        return parent[a]
    } else {
        parent[a] = find(parent[a])
        return parent[a]
    }
}

fun union(a: Int, b: Int) {
    val A = find(a)
    val B = find(b)

    if(A != B) {
        parent[B] = A
    }
}