class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val map = hashMapOf<String, MutableList<Pair<Int,Int>>>()
        var countMap = hashMapOf<String, Int>()

        for (i in genres.indices) {
            if(map[genres[i]] == null) {
                map[genres[i]] = mutableListOf()
                map[genres[i]]!!.add(Pair(plays[i], i))

                countMap[genres[i]] = plays[i]
            } else {
                map[genres[i]]!!.add(Pair(plays[i], i))

                countMap[genres[i]] = countMap[genres[i]]!! +  plays[i]
            }

            map[genres[i]]!!.sortBy { it.second }
            map[genres[i]]!!.sortByDescending { it.first }

        }

        if (countMap.size >= 2) {
            countMap = countMap.toList().sortedByDescending { it.second }.toMap() as HashMap<String, Int>
        }
        countMap.forEach {

            if(map[it.key]!!.size == 1) {
                answer.add(map[it.key]!![0].second)
            } else if (map[it.key]!!.size >= 2) {
                answer.add(map[it.key]!![0].second)
                answer.add(map[it.key]!![1].second)
            }

        }

        return answer.toIntArray()
    }
}