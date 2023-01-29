class Solution {
    
    var plusCount : Int = 0
    var totalCost  = 0.0
    var discount = listOf<Int>(0, 10, 20, 30, 40)
    
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        /*
            1. 이모티콘 각각의 할인률을 저장하는 리스트를 만든다.
            2. 각 이모티콘 마다 (40% ~ 최소)에서 할인 해보봄
                각 사용자 별로 탐색해봄
                    - 구매 가능한 이모티콘을 고름
                    - 계산 가격 >= 지정 가격 -> 플러스 가입자 + 1  
        
        */
        // var emoticonDiscountList = MutableList<Int>(emoticons.size) { 40 }
        
        
        
        fun find(emoticonDiscountList : List<Int>) {
            
            if (emoticonDiscountList.size == emoticons.size) {
                var tmpPlusCount = 0
                var tmpTotalCost = 0.0
                
                for (i in 0 until users.size) {
                    var total = 0.0
                    for (j in 0 until emoticonDiscountList.size) {
                        if (users[i][0] <= emoticonDiscountList[j]) {
                            total += emoticons[j] * (100 - emoticonDiscountList[j]) * 0.01
                        } 
                    }
                    
                    
                    if (total >= users[i][1]) tmpPlusCount ++
                    else tmpTotalCost += total
                    
                    
                }
                // println("${emoticonDiscountList} ${tmpPlusCount} ${tmpTotalCost}")
                
                if (plusCount < tmpPlusCount) {
                    plusCount = tmpPlusCount
                    totalCost = tmpTotalCost
                    
                } else if (plusCount == tmpPlusCount) {
                    if (totalCost < tmpTotalCost) {
                        totalCost = tmpTotalCost
                        
                    }
                }
                
                
                return
            }
            
            for (i in 0 until 5) {
                find(emoticonDiscountList + listOf(discount[i]))
            }
             
                        
        }
        
        find(listOf<Int>())
        
        
        return intArrayOf(plusCount, totalCost.toInt())
    }
}