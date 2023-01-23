class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        
        fun findLongest(start : Int, end : Int) {
            var start = start
            var end = end

            while (0 <= start && end < s.length && s[start] == s[end]) {
                
                count++

                start --
                end ++
            }


        }

        for (i in 0 until s.length) {
            findLongest(i, i)
            findLongest(i, i+1)
        }

        // println(res)

        return count
    }
}