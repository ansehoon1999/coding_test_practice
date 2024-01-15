class Solution {

    val hashMap = hashMapOf<String, MutableList<Pair<Int, Int>>>()
    val list = mutableListOf<Pair<String, Int>>()

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()

        // genres to play -> hashMap input

        genres.forEachIndexed { idx, genre ->

            if(hashMap[genre] == null) {
                hashMap[genre] = mutableListOf(Pair(idx, plays[idx]))
            } else {
                hashMap[genre]?.add(Pair(idx, plays[idx]))
            }
        }

        // genres to playTotal time

        for((key, value) in hashMap) {

            var cost = 0

            for(num in value) {
                cost += num.second
            }

            list.add(Pair(key, cost))
        }

        list.sortByDescending { it.second }


        list.forEach { element ->
            val genre = element.first

            val generList = hashMap[genre]!!
            generList.sortByDescending { it.second }

            if(generList.size == 1) {
                answer += generList[0].first
            } else {
                for(idx in 0 until 2) {
                    answer += generList[idx].first
                }
            }
        }


        return answer
    }
}