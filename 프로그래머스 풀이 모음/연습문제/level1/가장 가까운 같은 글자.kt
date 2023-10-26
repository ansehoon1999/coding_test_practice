class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = IntArray(s.length)

        val hashMap = hashMapOf<Char, Int>()

        s.forEachIndexed { idx, sChar ->
            if(hashMap[sChar] == null) {
                hashMap[sChar] = idx
                answer[idx] = -1
            } else {
                answer[idx] = idx -hashMap[sChar]!!
                hashMap[sChar] = idx
            }
        }

        return answer
    }
}