class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()

        val result = mutableSetOf<Int>()
        nums.forEach { num ->
            if (map[num] == null) map[num] = 1
            else {
                val tmp = map[num]!! + 1 
                map.put(num, tmp)
            }
        }

        val list = ArrayList(map.entries)
        list.sortByDescending { it.value }
        // println(list)
        
        for (i in 0 until k) {
            result.add(list[i].key)
        }
        return result.toIntArray()

    }
}