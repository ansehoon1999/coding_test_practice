class Solution {
    fun solution(gems: Array<String>): IntArray {
        val answer = IntArray(2)

        val set = HashSet<String>()

        for(gem in gems) {
            set.add(gem)
        }

        val map = HashMap<String, Int>()

        var dst = Integer.MAX_VALUE
        var start = 0
        var end = 0

        while (true) {
            if(set.size == map.size) {
                map[gems[start]] = map[gems[start]]?.minus(1) ?: 0

                if(map[gems[start]] == 0) {
                    map.remove(gems[start])
                }

                start ++
            }

            else if(end == gems.size) {
                break
            }
            else {
                map[gems[end]] = map.getOrDefault(gems[end], 0) + 1
                end ++
            }

            if(set.size == map.size) {
                if(end - start < dst) {
                    dst = end - start
                    answer[0] = start + 1
                    answer[1] = end
                }
            }

        }

        return answer
    }
}