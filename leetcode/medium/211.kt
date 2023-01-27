class WordDictionary() {

    val root = Node('0')
    fun addWord(word: String) {
        var current = root
        for(letter in word) {
            if(current.children[letter - 'a'] == null) current.children[letter - 'a'] = Node(letter)
            current = current.children[letter - 'a']!!
        }
        current.isWord = true

    }

    fun search(word: String, node : Node = root, i : Int = 0): Boolean {
        val allChildren = node.children.filterNotNull()
        return when {
			// We reached the end of the search. If the last letter is a '.', check if any of the children are a word.
            i == word.lastIndex && word[i] == '.' -> allChildren.any{it.isWord}
			// We reached the end of the search. If the last letter is a letter, check if is a word.
            i == word.lastIndex -> node.children[word[i] - 'a']?.isWord == true
			// Still have more letters. Letter is not a '.' so validate the current letter and keep searching if it is valid.
            word[i] != '.' -> allChildren.any{it.value == word[i] && search(word, it, i + 1)}
			// Still have more letters. Letter is a '.' so skip the current letter and keep searching.
            else -> allChildren.any{search(word, it, i + 1)}
        }
    }

    data class Node(val value: Char, val children: Array<Node?> = arrayOfNulls(26), var isWord: Boolean = false)

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */