class Solution {

    private lateinit var childToParent: HashMap<String, String>
    private lateinit var enrollResult: HashMap<String, Double>

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {

        childToParent = hashMapOf()
        enrollResult = hashMapOf()

        for(i in enroll.indices) {
            childToParent[enroll[i]] = enroll[i]
            childToParent[enroll[i]] = referral[i]
            enrollResult[enroll[i]] = 0.0

        }

        for(i in seller.indices) {
            var curSeller = seller[i]
            var curAmount = amount[i] * 100

            find(curSeller, curAmount)
            //        while(true) {
            //
            //            if(curSeller == "-") {
            //                break
            //            }
            //
            //            val div = curAmount / 10
            //            val remain = curAmount - div
            //
            //            enrollResult[curSeller] = enrollResult[curSeller]!!.plus(remain)
            //            curAmount = div
            //
            //            curSeller = childToParent[curSeller]!!
            //
            //        }
        }

        val answer = IntArray(enroll.size) { 0 }
        for(i in enroll.indices) {
            answer[i] = enrollResult[enroll[i]]!!.toInt()
        }

        return answer
    }

    fun find(curSeller: String, curAmount: Int) {
        if(curSeller == "-") return

        val div = curAmount / 10
        val remain = curAmount - div

        enrollResult[curSeller] = enrollResult[curSeller]!!.plus(remain)

        if(div < 1) return

        find(childToParent[curSeller]!!, div)
    }




}