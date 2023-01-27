class Trie() {
    class Node () {
        var endOfWord = false
        var children = Array<Node?>(26) { null } 
    }

    private val root = Node()
    
    fun insert(word: String) {
        var current = root
        for (i in 0 until word.length) {
            if (current.children[word[i] - 'a'] == null) {
                val node = Node()
                current.children[word[i] - 'a'] = node
                current = node
            } else {
                current = current.children[word[i] - 'a']!!
            }
        }

        current.endOfWord = true
    }

    fun search(word: String): Boolean = searchHelper(word)?.endOfWord ?: false

    fun startsWith(prefix: String): Boolean = searchHelper(prefix) != null
    
    private fun searchHelper(word: String): Node? {
        var current = root
        for (i in 0 until word.length) {
            if (current.children[word[i] - 'a'] == null) {
                return null
            } else {
                current = current.children[word[i] - 'a']!!
            }
        }

        return current

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */