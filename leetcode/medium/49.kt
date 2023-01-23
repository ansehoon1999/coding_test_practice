class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        
        val str_state = BooleanArray(strs.size) { false }
        val str2 = mutableListOf<String>()
        for (i in 0 until strs.size) {
            val str = strs[i]
            val tmp = String(str.toCharArray().sortedArray())

            str2.add(tmp)
        }

        val result = mutableListOf<List<String>>()
        for (i in 0 until strs.size) {
            if (str_state[i]) continue

            val list = mutableListOf<String>()
            list.add(strs[i])
            str_state[i] = true

            for (j in i+1 until strs.size) {
                if (str_state[j]) continue
                if (str2[i] == str2[j]) {
                    list.add(strs[j])
                    str_state[j] = true
                }
            }

            result.add(list.toList())

        }

        // println(result)
        return result.toList()
    }
}