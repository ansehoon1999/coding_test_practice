class Solution {

    lateinit var visited: MutableList<Boolean>

    fun solution(cards: IntArray): Int {
        var answer: Int = 0

        visited = MutableList<Boolean>(cards.size) { false }

        val countList = mutableListOf<Int>()

        for(idx in 0 until cards.size) {
            if(!visited[idx]) {
                visited[idx] = true
                val count = dfs(idx, cards)
                countList.add(count)
            }
        }

        countList.sortDescending()

        if(countList.size >= 2) {
            return countList[0] * countList[1]
        } else {
            return 0
        }

    }

    fun dfs(idx: Int, cards: IntArray): Int {
        var count = 1

        val nextBoxIdx = cards[idx] - 1
        if(!visited[nextBoxIdx]) {
            visited[nextBoxIdx] = true
            count = dfs(nextBoxIdx, cards) + 1
        }

        return count
    }
}