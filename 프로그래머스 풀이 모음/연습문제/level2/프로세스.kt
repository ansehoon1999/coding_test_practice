import java.util.*

class Solution {
    
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
    
        val deque = ArrayDeque<Pair<Int, Int>>()
        
        priorities.forEachIndexed { idx, priority ->
            deque.add(Pair(idx, priority))
        }
        

        while(true) {
            val (curIdx, curPriority) = deque.removeFirst()

            var flag = false
            
            deque.forEach { 
                if(curPriority < it.second) {
                    flag = true
                 }
            }
              
             if(flag) {
                 deque.add(Pair(curIdx, curPriority))
             } else {
                 answer ++ 
                 if(curIdx == location) return answer
             }
             
             
             
             
        }
        
        return answer - 1 
    }
}