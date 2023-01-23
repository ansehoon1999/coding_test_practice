class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 1) return 1
        
        val list = MutableList<Int>(s.length+1) { 0 }
        var result = 0
        for (i in 0 until s.length-1) {
            val tmp = mutableListOf<Char>()
            tmp.add(s[i])

            var j = i+1
            while (true) {
                if (j == s.length) break

                if (tmp.contains(s[j])) {
                    break
                }

                tmp.add(s[j])
                j++
            }
            // println(tmp)

            result = Math.max(result, tmp.size)
        }

        

        return result
    }
}