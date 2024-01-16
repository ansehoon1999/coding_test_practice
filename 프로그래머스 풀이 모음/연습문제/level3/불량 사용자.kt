class Solution {

    var bannedSize = 0
    var userIdSize = 0

    val resultList = mutableSetOf<List<Boolean>>()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0

        bannedSize = banned_id.size
        userIdSize = user_id.size

        // banned_id 순회
        val visited = MutableList<Boolean>(user_id.size) { false }

        dfs(0, 0, visited, user_id, banned_id)


        return resultList.size
    }

    fun dfs(bannedIdx: Int, userIdIdx: Int, visited: MutableList<Boolean>, user_id: Array<String>, banned_id: Array<String>) {

        if(bannedIdx == bannedSize) {
            // println("bannedIdx: ${bannedIdx}, userIdIdx: ${userIdIdx}, visited: ${visited}")

            resultList.add(visited)
            return
        }

        for(idx in 0 until userIdSize) {

            val curBanned = banned_id[bannedIdx]
            val curUserId = user_id[idx]

            if(curBanned.length != curUserId.length) continue

            var flag = true
            for(i in 0 until curUserId.length) {
                if(curBanned[i] != '*' && curUserId[i] != curBanned[i]) {
                    flag = false
                    break
                }
            }

            if(flag && !visited[idx]) {

                visited[idx] = true
                dfs(bannedIdx + 1, idx, visited, user_id, banned_id)
                visited[idx] = false

            }

        }



    }


}