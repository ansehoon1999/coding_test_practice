class Solution {

    val wantHashMap = hashMapOf<String, Int>()

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        for(idx in 0 until want.size) {
            wantHashMap[want[idx]] = number[idx]
        }

        var discountIdx = 0
        while(discountIdx + 9 < discount.size) {

            val discountHashMap = hashMapOf<String, Int>()

            for(idx in discountIdx until discountIdx + 10) {
                if(discountHashMap[discount[idx]] == null) {
                    discountHashMap[discount[idx]] = 1
                } else {
                    discountHashMap[discount[idx]] = discountHashMap[discount[idx]]!! + 1
                }
            }

            var count = 0
            for((wantKey, wantValue) in wantHashMap) {
                val discountValue = discountHashMap[wantKey]
                if(discountValue == null) break

                if(wantValue == discountHashMap[wantKey]) {
                    count ++
                }

            }

            if(count == want.size) answer ++
            discountIdx ++
        }


        return answer
    }
}