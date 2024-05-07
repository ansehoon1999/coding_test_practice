class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        
        val toppingSet = mutableSetOf<Int>()
        
        val left = IntArray(topping.size)
        val right = IntArray(topping.size)
        
        for(i in 0 until topping.size) {
            toppingSet.add(topping[i])
            left[i] = toppingSet.size
        }
        
        toppingSet.clear()
        
        for(i in topping.size - 1 downTo 0) {
            toppingSet.add(topping[i])
            right[i] = toppingSet.size
        }
        
        
        for(i in 0 until left.size - 1) {
            if(left[i] == right[i+1]) {
                answer ++
            }
        }
        
        return answer
    }
}