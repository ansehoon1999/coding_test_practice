class Solution {

    val hashMap = hashMapOf<String, String>()

    fun solution(record: Array<String>): Array<String> {
        val result = mutableListOf<Pair<String, String>>()

        record.forEach {

            val recordList = it.split(" ")

            var action = ""
            var uid = ""
            var name = ""

            if(recordList.size == 3) {
                action = recordList[0]
                uid = recordList[1]
                name = recordList[2]
            } else {
                action = recordList[0]
                uid = recordList[1]
            }

            if(action == "Enter") {
                hashMap[uid] = name
                result.add(Pair(action, uid))
            } else if(action == "Leave") {
                result.add(Pair(action, uid))
            } else if(action == "Change") {
                hashMap[uid] = name
            }

        }

        var answer = Array<String>(result.size) { "" }

        result.forEachIndexed { idx, it ->
            val action = it.first
            val uid = it.second

            if(action == "Enter") {
                answer[idx] = "${hashMap[uid]!!}님이 들어왔습니다."
            } else {
                answer[idx] = "${hashMap[uid]!!}님이 나갔습니다."
            }
        }



        return answer
    }
}