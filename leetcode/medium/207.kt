class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjList = MutableList<MutableList<Int>>(numCourses) { MutableList<Int>(0) { 0 } }
        val inDegree = MutableList<Int>(numCourses) { 0 }

        for (i in prerequisites) {
            val (end, start) = i
            adjList[start].add(end)
            inDegree[end] ++
        }

        val q = ArrayDeque<Int>()

        for (i in 0 until inDegree.size) {
            if (inDegree[i] == 0) q.add(i) 
        }

        repeat(inDegree.size) {
            if (q.isEmpty()) return false

            val target = q.poll()
            adjList[target].forEach { node ->
                inDegree[node] -= 1
                if (inDegree[node] == 0) {
                    q.add(node)
                }
            }

        } 

    

        return true
    }
}