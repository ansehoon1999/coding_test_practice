class Solution {
    fun solution(s: String): IntArray {
        val answer = mutableListOf<Int>()
        
        val sList = s.substring(2, s.length - 2).split("},{")
        
        val comparator: Comparator<String> = compareBy { it.length }
        val newList = sList.sortedWith(comparator)
        val newList2 = newList.map { it.split(",").map { it.toInt()} }
                        
        answer.add(newList2[0][0])
        for(idx in 1 until newList2.size) {
            answer.add((newList2[idx] - newList2[idx-1])[0])
        }
        
            
        return answer.toIntArray()
    }
}