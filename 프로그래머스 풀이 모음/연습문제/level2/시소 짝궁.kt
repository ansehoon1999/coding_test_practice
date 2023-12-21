class Solution {

    val hashMap = hashMapOf<Double, Int>()

    fun solution(weights: IntArray): Long {
        var answer: Long = 0

        weights.forEach { weight ->
            if(hashMap[weight.toDouble()] == null) {
                hashMap[weight.toDouble()] = 1
            } else {
                hashMap[weight.toDouble()] = hashMap[weight.toDouble()]!! + 1
            }
        }


        for((key, value) in hashMap) {

            if(key > 1) {
                answer += (value.toLong() * (value.toLong() - 1L) / 2L)
            }

            if(hashMap[key.toDouble() * 2] != null) {
                answer += (value.toLong() * hashMap[key.toDouble() * 2]!!.toLong())
            }

            if(hashMap[key.toDouble() * 2/3] != null) {
                answer += (value.toLong() * hashMap[key.toDouble() * 2/3]!!.toLong())
            }

            if(hashMap[key.toDouble() * 3/4] != null) {
                answer += (value.toLong() * hashMap[key.toDouble() * 3/4]!!.toLong())
            }




        }


        return answer

    }

}