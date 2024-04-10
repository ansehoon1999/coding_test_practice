import kotlin.collections.ArrayDeque
import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        val deque = ArrayDeque<Char>()
        s.forEach { sChar ->
            deque.add(sChar)
        }
        
        repeat(s.length) {  
            
            if(isAlright(deque)) {
                answer ++
            } 
            
            val first = deque.first()
            deque.addLast(first)
            deque.removeFirst()
            
        } 
        
        
        return answer
        
    }
    
    fun isAlright(deque: ArrayDeque<Char>): Boolean {
        val stk = Stack<Char>()
                
        deque.forEach { ch ->
            
            if(stk.isEmpty()) {
               stk.add(ch) 
            } else {
                if(stk.last() == '[' && ch == ']') { 
                    stk.pop()
                } else if(stk.last() == '(' && ch == ')') {
                    stk.pop()
                } else if(stk.last() == '{' && ch == '}') {
                    stk.pop()
                } else {
                    stk.add(ch)
                }
            
            }
        }
        
        return stk.isEmpty()
    }
}