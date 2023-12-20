class Solution {

    lateinit var pickList: IntArray
    lateinit var list: MutableList<IntArray>

    var answer = Integer.MAX_VALUE

    fun solution(picks: IntArray, minerals: Array<String>): Int {

        list = mutableListOf<IntArray>()
        pickList = picks

        var count1 = 0
        var count2 = 0
        var count3 = 0

        for(idx in 0 until minerals.size) {
            if(idx % 5 == 0 && idx != 0) {
                list.add(intArrayOf(count1, count2, count3))

                count1 = 0
                count2 = 0
                count3 = 0
            }

            count1 += calculate("diamond", minerals[idx])
            count2 += calculate("iron", minerals[idx])
            count3 += calculate("stone", minerals[idx])

        }

        list.add(intArrayOf(count1, count2, count3))


        dfs(0, minerals, pickList, 0)


        return answer
    }

    fun dfs(idx: Int, minerals: Array<String>, pick: IntArray, total: Int) {
        if(pick[0] == 0 && pick[1] == 0 && pick[2] == 0) {
            // println("${list.map { it.toList() }}, ${pick.toList()} ${total}")
            answer = minOf(answer, total)
            return
        }

        if(idx == list.size) {
            // println("${list.map { it.toList() }}, ${pick.toList()} ${total}")
            answer = minOf(answer, total)
            return
        }


        if(pick[0] != 0) {
            pick[0] -= 1
            dfs(idx + 1, minerals, pick, total + list[idx][0])
            pick[0] += 1
        }

        if(pick[1] != 0) {
            pick[1] -= 1
            dfs(idx + 1, minerals, pick, total + list[idx][1])
            pick[1] += 1
        }

        if(pick[2] != 0) {
            pick[2] -= 1
            dfs(idx + 1, minerals, pick, total + list[idx][2])
            pick[2] += 1
        }
    }

    fun calculate(pickName: String, mineralName: String): Int {
        if(pickName == "diamond") {
            if(mineralName == "diamond") {
                return 1
            } else if(mineralName == "iron") {
                return 1
            } else if(mineralName == "stone") {
                return 1
            }
        } else if(pickName == "iron") {
            if(mineralName == "diamond") {
                return 5
            } else if(mineralName == "iron") {
                return 1
            } else if(mineralName == "stone") {
                return 1
            }
        } else if(pickName == "stone") {
            if(mineralName == "diamond") {
                return 25
            } else if(mineralName == "iron") {
                return 5
            } else if(mineralName == "stone") {
                return 1
            }
        }

        return 0
    }
}