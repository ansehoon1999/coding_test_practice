
class Solution {

    val visited = MutableList(5) { false }
    val result = MutableList(5) { "" }
    lateinit var list : MutableList<String>
    lateinit var total : MutableList<String>

    fun solution(word: String): Int {

        list = mutableListOf<String>()
        list.apply {
            add("A")
            add("E")
            add("I")
            add("O")
            add("U")
        }

        total = mutableListOf()

        for(i in 4 downTo  0) {
            dupPermutation(i)
        }

        total.sort()

        return total.indexOf(word) + 1
    }

    fun dupPermutation(count: Int) {
        if(count == 5) {
            total.add(result.joinToString(""))
            return
        }

        for(i in 0 until 5) {
            result[count] = list[i]
            dupPermutation(count + 1)
        }
    }

}