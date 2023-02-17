class Solution {
    fun lengthOfLastWord(s: String): Int {
    var res = 0
    var i = s.length-1

    while (i >= 0) {
        if (s[i] != ' ') res++
        else if (s[i] == ' ' && res > 0) return res
        i--
    }

    return res
    }
}