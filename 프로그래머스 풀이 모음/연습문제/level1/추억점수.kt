class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = IntArray(photo.size)

        val hashMap = hashMapOf<String, Int>()

        for(idx in 0 until name.size) {
            hashMap[name[idx]] = yearning[idx]
        }

        for(i in 0 until photo.size) {
            var result = 0

            for(j in 0 until photo[i].size) {
                if(hashMap[photo[i][j]] != null) answer[i] += hashMap[photo[i][j]]!!
            }
        }

        return answer
    }
}