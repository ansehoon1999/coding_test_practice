class Solution {
    val list = mutableListOf<Int>()

    fun lengthOfLIS(nums: IntArray): Int {
        nums.forEach { num ->
            if (list.isEmpty()) list.add(num)
            else {
                if (list.last() < num) {
                    list.add(num)
                } else {
                    val pos = binary_search(num)
                    list[pos] = num
                }

            }

        }

        return list.size
    }

    fun binary_search(num: Int) : Int {
        var start = 0
        var end = list.size - 1

        while (start < end) {
            val mid = (start + end) / 2

            if (list[mid] < num) {
                start = mid + 1
            } else {
                end = mid
            }
        }

        return end
    }

}


