class Solution {

    var answer = mutableListOf<IntArray>()

    fun solution(n: Int): Array<IntArray> {

        hanoi(n, 1, 3, 2)

        return answer.toTypedArray()
    }

    fun hanoi(n: Int, start: Int, end: Int, via: Int) {
        if(n == 1) {
            answer.add(intArrayOf(start, end))
            return
        }

        hanoi(n-1, start, via, end)
        answer.add(intArrayOf(start, end))
        hanoi(n-1, via, end, start)

    }
}