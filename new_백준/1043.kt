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

    parent = MutableList<Int>(n + 1) { it }

    st = StringTokenizer(br.readLine())
    val knownNum = st.nextToken().toInt()
    val knownList = mutableListOf<Int>()

    repeat(knownNum) {
        knownList.add(st.nextToken().toInt())
    }

    val partyList = mutableListOf<MutableList<Int>>()

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val tempList = mutableListOf<Int>()
        repeat(num) {
            val temp = st.nextToken().toInt()
            tempList.add(temp)
        }

        var first = tempList[0]
        for (i in 1 until tempList.size) {
            union(first, tempList[i])
        }

        partyList.add(tempList)
    }

    var cnt = m
    for(i in 0 until partyList.size) {
        val curParty = partyList[i]
        for(j in 0 until curParty.size) {
            val curPerson = curParty[j]

            var flag = false

            for(j in 0 until knownList.size) {
                val curKnown = knownList[j]
                if(find(curPerson) == find(curKnown)) {
                    flag = true
                    break
                }
            }

            if(flag) {
                cnt --
                break
            }
        }


    }

    println(cnt)

    bw.flush()
    bw.close()
}

fun find(a: Int): Int {
    if (a == parent[a]) return parent[a]
    else {
        parent[a] = find(parent[a])
        return parent[a]
    }
}

fun union(a: Int, b: Int) {
    val a = find(a)
    val b = find(b)

    if (a != b) {
        parent[b] = a
    }
}
