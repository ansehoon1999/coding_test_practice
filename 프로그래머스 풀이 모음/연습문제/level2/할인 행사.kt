class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        
        val discountSize = discount.size
        val wantSize = want.size
        val numberSize = number.size
        
        val hashMap = hashMapOf<String, Int>()
        for(idx in 0 until wantSize) {
            hashMap[want[idx]] = number[idx]
        }
        
        for(idx in 0 until discountSize - 9) {
            
            val tmpHashMap = hashMapOf<String, Int>()
        
            repeat(10) {
            
                val curDiscountWant = discount[it + idx]
                
                if(tmpHashMap[curDiscountWant] == null) {
                    tmpHashMap[curDiscountWant] = 1
                } else {
                    tmpHashMap[curDiscountWant] = tmpHashMap[curDiscountWant]!! + 1
                }
            }
            
            var flag = true
            for((key, value) in tmpHashMap) {
                if(value != hashMap[key]) {
                    flag = false
                }
            }
            
            if(flag) {
                answer++
            }
        
        }
            
        
        return answer
    }
}