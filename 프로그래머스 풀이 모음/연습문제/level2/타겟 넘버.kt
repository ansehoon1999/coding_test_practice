class Solution {
    
    var answer = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        
        
        dfs(0, numbers, target, 0)
        
        return answer
    }
    
    fun dfs(curIdx: Int, numbers: IntArray, target: Int, curValue: Int) {
        
        if(curIdx >= numbers.size) {
            
            if(target == curValue) {
                answer ++
            }
            
            return
        }
    
        
        dfs(curIdx + 1, numbers, target, curValue + numbers[curIdx])
        dfs(curIdx + 1, numbers, target, curValue - numbers[curIdx])
    }
}