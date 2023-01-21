class Solution {
    fun maxProfit(prices: IntArray): Int {

        var min = 1000000
        var max = -1
        var cost = -1
        for (i in 0 until prices.size) {
            if (min > prices[i]) {

                min = prices[i]
                max = -1
            } else {
                max = Math.max(max, prices[i])
                cost = Math.max(max - min, cost)
            }
        }

        if (cost < 0 ) return 0
        else return cost

    }
}