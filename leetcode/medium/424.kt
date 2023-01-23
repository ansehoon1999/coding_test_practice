class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var mostFreqCharCount = 0
        var start = 0
        var max = 0

        val map = mutableMapOf<Char, Int>()

        for (end in 0 until s.length) {
            map.put(s[end], map.getOrDefault(s[end], 0) + 1)
            mostFreqCharCount = Math.max(map[s[end]]!!, mostFreqCharCount)

            if (end - start + 1 > mostFreqCharCount + k ) {
                map.put(s[start], map[s[start]]!! - 1)
                start ++
            }

            max = Math.max(max, end-start + 1)

        }
        
        return max
    }
}