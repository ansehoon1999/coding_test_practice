class Solution {
    fun countBits(n: Int): IntArray {
        
        val list = mutableListOf<Int>()

        var count = 0
        for (i in 0 .. n) {
            list.add(Integer.toBinaryString(i).replace("0", "").length)
            // println(Integer.toBinaryString(i).replace("0", ""))
        }
        return list.toIntArray()

    }
}