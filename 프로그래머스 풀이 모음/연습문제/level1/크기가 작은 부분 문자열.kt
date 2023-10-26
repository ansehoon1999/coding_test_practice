class Solution {
    fun solution(t: String, p: String): Int {

        val tList = mutableListOf<Long>()
        val pSize = p.length
        val tSize = t.length

        for(i in 0 until tSize - (pSize-1)) {
            tList.add(t.substring(i, i+ pSize).toLong())
        }

        var result = 0
        val targetValue = p.toLong()
        tList.forEach { tElement ->
            if(tElement <= targetValue) result ++
        }


        return result
    }
}