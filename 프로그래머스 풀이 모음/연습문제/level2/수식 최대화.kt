import java.util.*

class Solution {

    val hashMap = hashMapOf<Set<String>, Array<Array<String>>>()

    var answer: Long = Long.MIN_VALUE

    fun solution(expression: String): Long {


        hashMap[setOf("-")] = arrayOf(arrayOf("-"))
        hashMap[setOf("+")] = arrayOf(arrayOf("+"))
        hashMap[setOf("*")] = arrayOf(arrayOf("*"))

        hashMap[setOf("-", "+")] = arrayOf(arrayOf("-", "+"), arrayOf("+", "-"))
        hashMap[setOf("-", "*")] = arrayOf(arrayOf("-", "*"), arrayOf("*", "-"))
        hashMap[setOf("+", "*")] = arrayOf(arrayOf("+", "*"), arrayOf("*", "+"))

        hashMap[setOf("-", "+", "*")] = arrayOf(
                arrayOf("-", "+", "*"),
                arrayOf("-", "*", "+"),
                arrayOf("+", "-", "*"),
                arrayOf("+", "*", "-"),
                arrayOf("*", "-", "+"),
                arrayOf("*", "+", "-")
        )

        val expressionList = mutableListOf<String>()
        val operationSet = mutableSetOf<String>()


        var tmp = ""
        for(idx in 0 until expression.length) {
            if(expression[idx] == '-' || expression[idx] == '*' || expression[idx] == '+') {
                expressionList.add(tmp)
                expressionList.add(expression[idx].toString())
                operationSet.add(expression[idx].toString())
                tmp = ""
            } else {
                tmp = tmp + expression[idx].toString()
            }
        }
        expressionList.add(tmp)

//         println(expressionList)
//         println(operationSet)

//         for((key, value) in hashMap) {
//             println("key: ${key}, value: ${value.toList().map { it.toList() }}")
//         }

        val caseList = hashMap[operationSet.toSet()]!!
        // println(caseList.toList().map { it.toList()})

        caseList.forEach { case ->
            calculate(case, expressionList, 0)
        }

        return answer
    }

    fun calculate(case: Array<String>, expressionList: MutableList<String>, idx: Int) {

        if(idx == case.size) {
            answer = maxOf(answer, Math.abs(expressionList[0].toLong()))
            // println(expressionList)
            return
        }

        val curOperation = case[idx].toString()
        val stk = Stack<String>()

        // println("case: ${case.toList()}")
        // println("expression: ${expressionList}")
        // println("curOperation: ${curOperation}")
        // println("idx: ${idx}")
        // println()

        for(idx in 0 until expressionList.size) {

            if(stk.isNotEmpty()) {

                val last = stk.pop() // -
                if(last == curOperation) {
                    val lastNum = stk.pop().toLong()
                    if(last == "*") {
                        stk.add((lastNum * expressionList[idx].toLong()).toString())
                    } else if(curOperation == "-") {
                        stk.add((lastNum - expressionList[idx].toLong()).toString())
                    } else if(curOperation == "+") {
                        stk.add((lastNum + expressionList[idx].toLong()).toString())
                    }
                } else {
                    stk.add(last)
                    stk.add(expressionList[idx])
                }

            } else {
                stk.add(expressionList[idx])
            }
        }

        calculate(case, stk.toMutableList(), idx + 1)

    }
}