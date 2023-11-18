class Solution {

    val clothHashMap = hashMapOf<String, MutableList<String>>()


    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        clothes.forEach { cloth ->
            val name = cloth[0]
            val type = cloth[1]

            if(clothHashMap[type] == null) {
                clothHashMap[type] = mutableListOf<String>()
            }

            clothHashMap[type]!!.add(name)
        }

        for((key, value) in clothHashMap) {
            answer *= (value.size + 1)
        }

        return answer - 1
    }
}