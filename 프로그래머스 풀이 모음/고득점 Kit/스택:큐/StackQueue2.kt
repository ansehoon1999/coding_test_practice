class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = ArrayList<Int>()

        val total = progresses.size
        val state = MutableList<Int>(total) { 0 }

        for (i in 0 until total) {
            val divide = (100 - progresses[i]) / speeds[i]
            val remain = (100 - progresses[i]) % speeds[i]
            println("${divide} ${remain}")

            if (remain > 0) {
                state[i] = divide + 1
            } else {
                state[i] = divide
            }
        }

        for(i in 0 until total) {
            var count = 1
            val current = state[i]

            if (current == - 1) continue

            for(j in i+1 until total) {
                if (current >= state[j]) {
                    state[j] = -1
                    count ++
                } else {
                    break
                }
            }

            answer.add(count)

        }

        return answer.toIntArray()
    }
}
}