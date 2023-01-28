class Solution {
    fun getSum(a: Int, b: Int): Int {
        var at=a
        var bt=b
        while(bt !=0){
            
            var carry = at and bt
            at = at xor bt
            bt = carry  shl 1
        }
        return at
    }
}