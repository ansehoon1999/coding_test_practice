class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0

        var emptyBottle = n

        while(emptyBottle >= a) {

            val cola = (emptyBottle / a) * b
            val elseCola = emptyBottle % a

            emptyBottle = cola + elseCola
            answer += cola

            println(emptyBottle)
        }


        return answer
    }
}