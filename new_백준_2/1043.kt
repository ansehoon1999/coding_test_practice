import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * union-find
     * 그룹화 진행
     *
     * 한번 더 순회하면서 부모가 같은 지 검색
     */





    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val parents = MutableList<Int>(n+1) { it }

    fun find(a: Int): Int {
        if(a == parents[a]) return a
        else {
            parents[a] = find(parents[a])
            return parents[a]
        }
    }

    fun union(a: Int, b: Int) {
        val a = find(a)
        val b = find(b)
        if(a != b) {
            parents[b] = a
        }
    }

    val list = MutableList<Int>(n+1) { it }

    st = StringTokenizer(br.readLine())

    val knownList = mutableListOf<Int>()
    val knownCnt = st.nextToken().toInt()
    repeat(knownCnt) {
        knownList.add(st.nextToken().toInt())
    }

//    println(knownList)

    val partyMap = hashMapOf<Int, MutableList<Int>>()
    repeat(m) {
        partyMap[it] = mutableListOf()
    }

    repeat(m) { x ->
        st = StringTokenizer(br.readLine())
        val partyCnt = st.nextToken().toInt()
        repeat(partyCnt) {
            partyMap[x]?.add(st.nextToken().toInt())
        }

        val partySize = partyMap[x]?.size ?: 0


        for(i in 0 until partySize) {
            for(j in 0 until partySize) {
                if(find(partyMap[x]?.get(i)!!) != find(partyMap[x]?.get(j)!!)) {
                    union(partyMap[x]?.get(i)!!, partyMap[x]?.get(j)!!)
                }
            }
        }
//        println(parents)
    }

    var cnt = 0
    partyMap.forEach { party ->

        var flag = true
        val curPartyList = party.value
        for(i in 0 until curPartyList.size) {

            for(j in 0 until knownList.size) {
                if(find(curPartyList[i]) == find(knownList[j])) {
                    flag = false
                }
            }
        }

        if(flag) cnt ++

    }

    println(cnt)


//    partyMap.forEach {
//        it.value.forEach {
//
//        }
//    }
//


    writer.flush()
    writer.close()
}