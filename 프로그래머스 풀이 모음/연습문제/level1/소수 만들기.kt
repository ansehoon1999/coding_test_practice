class Solution {

    val sumSet = mutableListOf<Int>()

    fun solution(nums: IntArray): Int {
        var answer = 0

        for(idx in 0 until nums.size) {
            permutation1(idx, nums)
        }

        sumSet.forEach {
            if(isPrime(it)) answer ++
        }

        return answer
    }

    fun permutation1(idx: Int, nums: IntArray) {
        for(i in idx+1 until nums.size) {
            permutation2(i, nums, idx)
        }
    }

    fun permutation2(idx: Int, nums: IntArray, idx2: Int) {
        for(i in idx+1 until nums.size) {
            sumSet.add(nums[idx2] + nums[idx] + nums[i])
        }
    }

    fun isPrime(num: Int): Boolean {
        if(num <= 1) return false

        for(n in 2 .. Math.sqrt(num.toDouble()).toInt()) {
            if(num % n == 0) {
                return false
            }
        }

        return true
    }
}