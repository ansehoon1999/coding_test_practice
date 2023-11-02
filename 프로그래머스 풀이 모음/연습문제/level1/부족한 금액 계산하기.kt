class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = 0L

        var cnt = 1

        while(cnt <= count) {

            answer += price.toLong() * cnt

            cnt ++
        }

        if(answer - money.toLong() >= 0) return answer - money.toLong()
        else return 0
    }
}