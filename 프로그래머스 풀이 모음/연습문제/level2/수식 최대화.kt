class Solution {

    val hashMap = hashMapOf<Set<String>, Array<Array<String>>>()

    fun solution(expression: String): Long {
        var answer: Long = Long.MIN_VALUE

        hashMap[setOf("+")] = arrayOf(arrayOf("+"))
        hashMap[setOf("-")] = arrayOf(arrayOf("-"))
        hashMap[setOf("*")] = arrayOf(arrayOf("*"))

        hashMap[setOf("+", "-")] = arrayOf(arrayOf("+", "-"), arrayOf("-", "+"))
        hashMap[setOf("+", "*")] = arrayOf(arrayOf("+", "*"), arrayOf("*", "+"))
        hashMap[setOf("-", "*")] = arrayOf(arrayOf("-", "*"), arrayOf("*", "-"))

        hashMap[setOf("+", "-", "*")] = arrayOf(
                arrayOf("+", "-", "*"),
                arrayOf("+", "*", "-"),
                arrayOf("-", "+", "*"),
                arrayOf("-", "*", "+"),
                arrayOf("*", "+", "-"),
                arrayOf("*", "-", "+"),
        )

        val expressionList = expression.toList()

        val expressionSet = mutableSetOf<String>()
        val expressionValueList = mutableListOf<String>()
        var num = ""

        for(idx in 0 until expressionList.size) {
            if(expressionList[idx] == '+' || expressionList[idx] == '-' || expressionList[idx] == '*') {
                expressionSet.add(expressionList[idx].toString())
                expressionValueList.add(num)
                expressionValueList.add(expressionList[idx].toString())

                num = ""
            } else {
                num += expressionList[idx].toString()
            }
        }

        expressionValueList.add(num)

        val curOperationList = hashMap[expressionSet]!!

        curOperationList.forEach { subList ->

            var initList = expressionValueList

            subList.forEach { op ->

                val tmpList = mutableListOf<String>(initList[0])

                for(idx in 1 until initList.size step(2)) {
                    if(op.toString() == initList[idx].toString()) {
                        val lastIdx = tmpList.size - 1
                        val lastNum = tmpList.last()

                        if(op == "+") {
                            tmpList[lastIdx] = (lastNum.toLong() + initList[idx+1].toLong()).toString()
                        } else if(op == "-") {
                            tmpList[lastIdx] = (lastNum.toLong() - initList[idx+1].toLong()).toString()
                        } else if(op == "*") {
                            tmpList[lastIdx] = (lastNum.toLong() * initList[idx+1].toLong()).toString()
                        }
                    } else {
                        tmpList.add(initList[idx])
                        tmpList.add(initList[idx+1])
                    }
                }

                initList = tmpList
            }

            answer = maxOf(answer, Math.abs(initList[0].toLong()))

        }


        return answer
    }
}