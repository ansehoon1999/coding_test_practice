class Solution {
    fun solution(elements: IntArray): Int {
        var answerSet = mutableSetOf<Int>()
        
        val elementList = elements.toList()
        val totalElements = elementList + elementList
        
        for(size in 1 .. elements.size) {
            
            var startIdx = 0
            while(true) {
                
                if(startIdx >= elements.size) {
                    break
                }
                
                var totalCnt = 0
                for(idx in startIdx until startIdx + size) {
                    totalCnt += totalElements[idx]
                }
                
                answerSet.add(totalCnt)
                startIdx ++
                // println(totalCnt)
            }
            
        }
        
        
        return answerSet.size
    }
}