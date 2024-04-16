class Solution {
    
    var answer = 0
    var result = 0
    
    val wordList = listOf<String>("A", "E", "I", "O", "U")
    
    fun solution(word: String): Int {
        
        permutate("", wordList, word)
        
        return result
    }
    
    fun permutate(wordStr: String, wordList: List<String>, word: String) {
        
        if(wordStr == word) {
            result = answer
            return
        }
        
        if(wordStr.length >= 5) return
        
        for(idx in 0 until wordList.size) {
            answer ++
            permutate(wordStr + wordList[idx], wordList, word)
        }
        
        
        
    }
}