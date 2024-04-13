class Solution {
    
    
    
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        
        val arr1Col = arr1.size
        val arr1Row = arr1[0].size
        
        val arr2Col = arr2.size
        val arr2Row = arr2[0].size
        
        val answer = MutableList(arr1Col) {
            IntArray(arr2Row)
        }

        for(arr1Idx in 0 until arr1Col) {
            
            val curArr1 = arr1[arr1Idx]
            
            for(arr2RowIdx in 0 until arr2Row) {
        
                val arr2List = mutableListOf<Int>()
                
                for(arr2ColIdx in 0 until arr2Col) {
                    
                    arr2List.add(arr2[arr2ColIdx][arr2RowIdx])
                }
                
                // println(arr2List)
                val curArr2 = arr2List
                
                calculateAnswer(answer, curArr1, curArr2, arr1Idx, arr2RowIdx)
            }
        }
        
    
        return answer.toTypedArray()
    }
    
    fun calculateAnswer(answer: MutableList<IntArray>, curArr1: IntArray, curArr2: MutableList<Int>, arr1Idx: Int, arr2Idx: Int) {
        var result = 0
        
        val size = curArr1.size
        
        for(idx in 0 until size) {
            val curArr1Ele = curArr1[idx]
            val curArr2Ele = curArr2[idx]
            
            result += (curArr1Ele * curArr2Ele)
        }
        
        answer[arr1Idx][arr2Idx] = result
        
    }
}