import kotlin.math.abs

class Solution {

    var hashMap = hashMapOf<Set<String>, Array<Array<String>>>()

    fun solution(expression: String): Long {
        var answer: Long = 0

        hashMap[setOf("+")] = arrayOf(arrayOf("+"))
        hashMap[setOf("-")] = arrayOf(arrayOf("-"))
        hashMap[setOf("*")] = arrayOf(arrayOf("*"))
        hashMap[setOf("+", "-")] = arrayOf(arrayOf("+", "-"), arrayOf("-", "+"))
        hashMap[setOf("+", "*")] = arrayOf(arrayOf("+", "*"), arrayOf("*", "+"))
        hashMap[setOf("-", "*")] = arrayOf(arrayOf("-", "*"), arrayOf("*", "-"))
        hashMap[setOf("-", "+", "*")] = arrayOf(
                arrayOf("-", "+", "*"),
                arrayOf("-", "*", "+"),
                arrayOf("+", "-", "*"),
                arrayOf("+", "*", "-"),
                arrayOf("*", "-", "+"),
                arrayOf("*", "+", "-"),
        )


        val expressionTmpList = expression.toList()

        val expressionList = mutableListOf<String>()
        val expressionSet = mutableSetOf<String>()

        var num = ""
        var result: Long = Long.MIN_VALUE

        for(i in 0 until expressionTmpList.size) {
            num += expressionTmpList[i]

            if(expressionTmpList[i] == '-' || expressionTmpList[i] == '*' || expressionTmpList[i] == '+') {
                expressionList.add(num.substring(0, num.length-1))
                expressionList.add(expressionTmpList[i].toString())
                expressionSet.add(expressionTmpList[i].toString())
                num = ""
            }
        }
        expressionList.add(num)

        val expressionSequence = hashMap[expressionSet]

        expressionSequence!!.forEach {
            // println(it)

            var initList = expressionList

            it.forEach { op ->
                val tmpList = mutableListOf<String>()
                tmpList.add(initList[0])

                for(i in 1 until initList.size step 2) {
                    if(op == initList[i]) {
                        val lastNumIndex = tmpList.lastIndex
                        val lastNum = tmpList.last()

                        if(op == "-") {
                            tmpList[lastNumIndex] = (lastNum.toLong() - initList[i+1].toLong()).toString()
                        } else if(op == "+") {
                            tmpList[lastNumIndex] = (lastNum.toLong() + initList[i+1].toLong()).toString()
                        } else if(op == "*") {
                            tmpList[lastNumIndex] = (lastNum.toLong() * initList[i+1].toLong()).toString()
                        }
                    } else {
                        tmpList.add(initList[i])
                        tmpList.add(initList[i+1])
                    }
                }

                initList = tmpList

                // println(tmpList)
                if(tmpList.size == 1) {
                    result = Math.max(result, abs(tmpList[0].toLong()))
                }

            }

            // println()

        }


        return result.toLong()
    }
}