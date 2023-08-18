class Solution {

    private lateinit var visited: MutableList<Boolean>
    private lateinit var hashMap: HashMap<Int, MutableList<Int>>
    private lateinit var newInfo: IntArray
    var max = -100000000


    fun solution(info: IntArray, edges: Array<IntArray>): Int {

        newInfo = info
        visited = MutableList<Boolean>(info.size) { false }
        hashMap = hashMapOf()

        for(i in 0 until info.size) {
            hashMap[i] = mutableListOf()
        }

        edges.forEach {
            val start = it[0]
            val end = it[1]

            hashMap[start]!!.add(end)
        }

        visited[0] = true

        println(hashMap)


        dfs(0, 1, 0, hashMap[0]!!)


        return max
    }

    fun dfs(curPoint: Int, sheepCount: Int, wolfCount: Int, curList: MutableList<Int>) {

        if(sheepCount <= wolfCount) {
            return
        }

        max = maxOf(max, sheepCount)

        // println("curList: ${curList}")
        // println("visited: ${visited}, sheep: ${sheepCount}, wolf: ${wolfCount}")

        for(i in 0 until curList.size) {
            if(visited[curList[i]]) continue

            visited[curList[i]] = true
            if(newInfo[curList[i]] == 0) {
                val removePoint = curList[i]
                val idx = curList.indexOf(removePoint)
                curList.remove(removePoint)
                dfs(removePoint, sheepCount+1, wolfCount, (curList + hashMap[removePoint]!!).toMutableList())
                curList.add(idx, removePoint)
            } else {
                val removePoint = curList[i]
                val idx = curList.indexOf(removePoint)
                curList.remove(removePoint)
                dfs(removePoint, sheepCount, wolfCount+1, (curList + hashMap[removePoint]!!).toMutableList())
                curList.add(idx, removePoint)
            }

            visited[curList[i]] = false
        }

    }

}