class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var start = 0
        var end = 0

        val list = mutableListOf<Pair<Int, Int>>()

        var sum = if(start == end) sequence[start] else sequence[start] + sequence[end]

        while(true) {
            if(end >= sequence.size || start >= sequence.size) break

            if(sum > k) {
                if(start >= sequence.size) break
                sum -= sequence[start]
                start ++
            } else if(sum < k) {
                end ++
                if(end >= sequence.size) break

                sum += sequence[end]

            } else if(sum == k) {
                list.add(Pair(start, end))
                if(start >= sequence.size) break
                sum -= sequence[start]
                start ++
            }
        }

        var min = Integer.MAX_VALUE
        var pair = Pair(0, 0)

        list.forEach {
            if(min > it.second - it.first) {
                min = it.second - it.first
                pair = it
            }
        }

        return intArrayOf(pair.first, pair.second)
    }
}