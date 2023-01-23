class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()

        fun backtrack(current : Int, list : List<Int>) {
            if (current > target) return
            
            if (current == target) {
                // println(list.sorted())
                result.add(list.sorted())
                return
            } else {
                candidates.forEach { candidate ->
                    val n = candidate + current
                    backtrack(n, list + listOf(candidate))
                }
            }
        }

    
        backtrack(0, listOf<Int>())
        
        return result.toList()
    }


}