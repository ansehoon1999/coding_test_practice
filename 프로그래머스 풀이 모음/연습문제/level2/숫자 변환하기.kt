import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = Integer.MAX_VALUE
        
        val visited = MutableList<Boolean>(y+1) { false }
        
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(Pair(x, 0))
        visited[x] = true
        
        while(deque.isNotEmpty()) {
            // println(deque)
            val (curNum, cnt) = deque.removeFirst()
            
            if(curNum > y) continue
            
            if(curNum == y) {
                answer = minOf(answer, cnt)
                continue
            }
            
            val num1 = calculatePlusN(curNum, n)
            if(num1 <= y && !visited[num1]) {
                deque.add(Pair(num1, cnt + 1))
                visited[num1] = true
            }
            
            val num2 = calculateMultiple2(curNum)
            if(num2 <= y && !visited[num2]) {
                deque.add(Pair(num2, cnt + 1))
                visited[num2] = true
            }
            
            val num3 = calculateMultiple3(curNum)
            if(num3 <= y && !visited[num3]) {
                deque.add(Pair(num3, cnt + 1))
                visited[num3] = true
            }
        }
        
        if(answer == Integer.MAX_VALUE) return -1
        else return answer
    }
    
    
    fun calculatePlusN(x: Int, n: Int): Int {
        return x + n
    }
    
    fun calculateMultiple2(x: Int): Int {
        return 2 * x
    }
    
    fun calculateMultiple3(x: Int): Int {
        return 3 * x
    }
}