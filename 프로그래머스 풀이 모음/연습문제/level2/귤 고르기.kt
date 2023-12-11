class Solution {

    val hashMap = hashMapOf<Int, Int>()

    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0

        tangerine.forEach {
            if(hashMap[it] == null) {
                hashMap[it] = 1
            } else {
                hashMap[it] = hashMap[it]!! + 1
            }
        }

        val result = mutableListOf<Int>()
        for((key, value) in hashMap) {
            result.add(value)
        }

        result.sortDescending()

        var count = 0
        for(idx in 0 until result.size) {
            count += result[idx]
            answer ++
            if(count >= k) {
                break
            }
        }

        return answer
    }


}