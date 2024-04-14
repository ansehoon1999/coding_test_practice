class Solution {
    
    var answer: Int = Integer.MIN_VALUE
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        
        val visited = MutableList<Boolean>(dungeons.size) { false }
        
        dfs(k, dungeons, 0, visited)
        
        return answer
    }
    
    fun dfs(k: Int, dungeons: Array<IntArray>, cnt: Int, visited: MutableList<Boolean>) {
        
        if(k < 0) return
        
        for(idx in 0 until dungeons.size) {
            
            val minTired = dungeons[idx][0]
            val consumeTired = dungeons[idx][1]
            
            if(k < minTired) {
                answer = maxOf(answer, cnt)
                continue
            }
            
            if(!visited[idx]) {
                visited[idx] = true
                dfs(k - consumeTired, dungeons, cnt + 1, visited)
                visited[idx] = false
            }
            
            
        }
    
        
    }
}