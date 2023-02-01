class Solution {
    
    var computerCount = 0
    lateinit var parents : MutableList<Int>
    
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        computerCount = n
        parents = MutableList<Int>(n) { it }  
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j && computers[i][j] == 1) union(i, j)
            }
        }

        for (i in 0 until n) {
            parents[i] = find(i)
        }
        
        return parents.toSet().size
    }
    
    
    fun find(num : Int) : Int {
        if (parents[num] == num) return num
        
        parents[num] = find(parents[num])
        return parents[num]
    }
    
    
    fun union(num1 :Int, num2 : Int) {
        val num1 = find(num1)
        val num2 = find(num2)
        
        if (num1 < num2) parents[num2] = num1
        else parents[num1] = num2
    }
        
}