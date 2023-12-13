class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val arr1 = IntArray(topping.size) { 0 }
        val arr2 = IntArray(topping.size) { 0 }
        var menuCount = mutableSetOf<Int>()

        for(i in 0 .. topping.size - 1) {
            menuCount.add(topping[i])
            arr1[i] = menuCount.size
        }

        menuCount.clear()

        for(i in topping.size - 1 downTo 0) {
            menuCount.add(topping[i])
            arr2[i] = menuCount.size
        }

        for(i in 0 until topping.size - 1) {
            if(arr1[i] == arr2[i+1]) answer ++
        }

        return answer
    }
}