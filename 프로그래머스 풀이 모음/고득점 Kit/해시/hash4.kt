class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val map = hashMapOf<String, MutableList<String>>()

        clothes.forEach { clothe ->
            if (map[clothe[1]] == null) {
                map[clothe[1]] = mutableListOf(clothe[0])
            } else {
                map[clothe[1]]!!.add(clothe[0])
            }
        }

        map.forEach {
            answer *= (it.value.size + 1)
        }

        return answer - 1
    }
}