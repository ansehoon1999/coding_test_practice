class Solution {
    private lateinit var state: MutableList<StateType>

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        state = MutableList<StateType>(n) { StateType.HAVE }

        lost.sort()
        reserve.sort()

        val reserveSet = reserve.toSet()
        val lostSet = lost.toSet()

        lost.forEach {  lostItem ->
            if(reserveSet.contains(lostItem)) {
                state[lostItem-1] = StateType.HAVE
            } else {
                state[lostItem-1] = StateType.LOST
            }

        }

        for(i in 0 until reserve.size) {
            if(lostSet.contains(reserve[i])) {
                continue
            }

            if(reserve[i] == state.size) {
                val last = state.size

                if(state[last-2] == StateType.LOST) {
                    state[last-2] = StateType.HAVE
                }
            } else if (reserve[i] == 1) {
                val first = 0

                if(state[first+1] == StateType.LOST) {
                    state[first+1] = StateType.HAVE
                }
            }

            else {
                val before = reserve[i] - 1 - 1
                val next = reserve[i] + 1 - 1

                if(state[before] == StateType.LOST && state[next] == StateType.HAVE) {
                    state[before] = StateType.HAVE
                } else if (state[before] == StateType.HAVE && state[next] == StateType.LOST) {
                    state[next] = StateType.HAVE
                } else {
                    state[before] = StateType.HAVE
                }

            }

            //        println(state)
        }

        var answer = 0
        state.forEach {
            if(it == StateType.HAVE) {
                answer ++
            }
        }

        return answer
    }

    enum class StateType {
        HAVE,
        LOST
    }
}