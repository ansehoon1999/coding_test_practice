class Solution {
    
    
    var map = mutableMapOf<Int, Int>()

    fun combinationSum4(nums: IntArray, target: Int): Int {
    val comb = IntArray(target + 1)
    comb[0] = 1

    for (i in 1 until comb.size) {
        nums.forEach { num ->
            if (i - num >= 0) {
                comb[i] += comb[i - num]
            }
        }
    }
    return comb[target]
    }
}

