class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()
        
        for(idx in left .. right) {
            
            val col = idx / n
            val row = idx % n
                        
            val maxVal = maxOf(col, row).toInt()
            answer.add(maxVal + 1)
        }
        
        
        return answer.toIntArray()
    }
}