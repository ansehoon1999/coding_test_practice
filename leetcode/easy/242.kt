class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        
        val map = IntArray(128) { 0 }

        for (s1 in s) {
            map[s1.toInt()] ++
        }

        for (t1 in t) {
            if (t1.toInt() != 0) map[t1.toInt()] -- 
        }

        for (i in 0 until 128) {
            if (map[i] != 0) return false
        }

        return true
    }
}