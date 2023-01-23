class Solution {
    fun longestPalindrome(s: String): String {
        var res = ""
        var resLen = 0

        fun findLongest(start : Int, end : Int) {
            var start = start
            var end = end

            while ( 0 <= start && end < s.length && s[start] == s[end] ) {
                if (end-start+1 > resLen) {
                    resLen = end - start + 1
                    res = s.substring(start, end+1)
                
                }

                start --
                end ++
            }

        } 

        for (i in 0 until s.length) {
            findLongest(i, i)
            findLongest(i, i+1)
        }

        return res
    }
}