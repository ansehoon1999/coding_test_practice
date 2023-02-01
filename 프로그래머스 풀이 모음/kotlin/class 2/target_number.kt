class Solution {
    
    lateinit var list : MutableList<Int>
    var size = 0
    var answer = 0

    
    fun solution(numbers: IntArray, target: Int): Int {
        size = numbers.size
        list = MutableList<Int>(size) { 0 }


        // dfs 방식
        dfs(numbers, target, 0)


        // 1. list를 차례로 하나씩 살펴보는 방법
        // 2. target == list.sum()!! 확인 -> answer ++


        return answer
    }

    fun dfs(numbers: IntArray, target : Int, count : Int) {
        if (count == size ) {
            if (list.sum()!! == target) answer ++
            return
        }


        list[count] = (-1) * numbers[count]
        dfs(numbers, target, count+1)

        list[count] = numbers[count]
        dfs(numbers, target, count+1)

    }
    

}