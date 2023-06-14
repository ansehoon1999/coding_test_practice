class Solution {

    var dungeons_size = -1
    lateinit var visited : MutableList<Boolean>
    lateinit var result : MutableList<IntArray>
    lateinit var resultOfresult : MutableList<MutableList<IntArray>>
    lateinit var list : MutableList<IntArray>
    var total_count = 0
    var kk = 0
    var ttmp = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {

        kk = k
        ttmp = k

        dungeons_size = dungeons.size

        visited = MutableList<Boolean>(dungeons_size) { false }
        result = MutableList<IntArray>(dungeons_size) { intArrayOf(0, 0)  }
        resultOfresult = mutableListOf()
        list = dungeons.toMutableList()

        permutation(0)

        return total_count
    }

    fun permutation(count: Int) {
        if(count == dungeons_size) {
            var tmp = 0
            for (i in 0 until result.size) {
                if (kk >= result[i][0]) {
                    kk -= result[i][1]
                    tmp = i + 1
                } else {
                    break
                }
            }

            total_count = maxOf(total_count, tmp)
            kk = ttmp


            return
        }

        for(i in 0 until dungeons_size) {
            if(!visited[i]) {
                result[count] = list[i]
                visited[i] = true
                permutation(count + 1)
                visited[i] = false
            }
        }
    }

}