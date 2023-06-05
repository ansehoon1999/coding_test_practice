class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        commands.forEach { arr ->
            val list = mutableListOf<Int>()

            for(i in arr[0]-1 until arr[1]) {
                list.add(array[i])
            }

            list.sort()

            answer.add(list[arr[2] - 1])
        }


        return answer.toIntArray()
    }
}