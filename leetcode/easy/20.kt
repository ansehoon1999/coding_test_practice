class Solution {
    fun isValid(s: String): Boolean {
        val list = s.toCharArray()

        val stack = Stack<Char>()

        list.forEach { ch ->
            when (ch) {
                '(' -> stack.push(ch)
                '[' -> stack.push(ch)
                '{' -> stack.push(ch)

                ')' -> {
                    if(stack.isNotEmpty()) {
                        if (stack.last() == '(') stack.pop()
                        else stack.push(ch)
                    } else {
                        stack.push(ch)
                    }
                }
                ']' -> {
                    if(stack.isNotEmpty()) {
                        if (stack.last() == '[' ) stack.pop()
                        else stack.push(ch)
                    } else {
                        stack.push(ch)
                    }
                }
                '}' -> {
                    if(stack.isNotEmpty()) {
                        if (stack.last() == '{') stack.pop()
                        else stack.push(ch)
                    } else {
                        stack.push(ch)
                    }
                }

            }

        }

        println(stack)
        if (stack.isEmpty()) return true
        else return false
    
    }
}