class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val result = Array<String>(players.size) { "" }

        val hashMap = hashMapOf<String, Int>()
        players.forEachIndexed { idx, player ->
            hashMap[player] = idx + 1
        }

        callings.forEachIndexed { idx, calling ->

            val playerIdx = hashMap[calling]!!
            val frontPlayer = players[playerIdx-2]
            val frontPlayerSeq = hashMap[players[playerIdx-2]]!!

            hashMap[frontPlayer] = hashMap[frontPlayer]!! + 1
            hashMap[calling] = hashMap[calling]!! - 1

            players[playerIdx-2] = calling
            players[playerIdx-1] = frontPlayer

        }

        players.forEachIndexed { idx, player ->

            val curPlayerIdx = hashMap[player]!! - 1
            result[curPlayerIdx] = player
        }

        return result
    }
}