class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""

        val alphabets = "abcdefghijklmnopqrstuvwxyz"
        val alphabetList = alphabets.toList()
        val skipList = skip.toList()

        val filteredList = mutableListOf<Char>()
        alphabetList.forEach { alphabet ->
            if(alphabet !in skipList) {
                filteredList.add(alphabet)
            }
        }

        s.forEach { sChar ->
            var idx = filteredList.indexOf(sChar) + index
            if(idx >= filteredList.size) idx = idx % filteredList.size

            answer += filteredList[idx]
        }

        return answer
    }
}