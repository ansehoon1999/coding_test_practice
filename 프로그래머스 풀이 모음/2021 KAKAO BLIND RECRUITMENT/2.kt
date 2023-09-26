class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {

        var answer: Array<String> = arrayOf()
        val madeCourses = mutableMapOf<String, Int>()
        val made = mutableListOf<String>()

        for(order in orders) {
            var part = ""

            var temp = order.toCharArray()
            var sortedOrder = temp.sorted().joinToString("")

            for(i in course) {
                var start = 0
                var cnt = 0
                madeCombination(sortedOrder, part, made, start, cnt, i)
            }
        }

        for(element in made) {
            if(madeCourses[element] == null) {
                madeCourses[element] = 1
            } else {
                madeCourses[element] = madeCourses.getValue(element) + 1
            }
        }

        var mapToList = madeCourses.toList()
        mapToList = mapToList.sortedWith(compareBy({
            it.first.length
        }, { - it.second }))

        for(i in course) {
            var maxCount = 0
            for(j in mapToList.indices) {
                if(mapToList[j].first.length == i && mapToList[j].second >= 2) {
                    if(maxCount < mapToList[j].second) {
                        maxCount = mapToList[j].second
                        answer = answer.plus(mapToList[j].first)
                    } else if(maxCount == mapToList[j].second){
                        answer = answer.plus(mapToList[j].first)
                    }
                }
            }
        }

        answer.sort()

        return answer
    }

    fun madeCombination(total: String, part: String, made: MutableList<String>, start: Int, cnt: Int, n: Int) {
        if (cnt == n) {
            made.add(part)
            return
        }

        for (i in start until total.length) {
            madeCombination(total, part + total[i], made, i + 1, cnt + 1, n)
        }
    }

}