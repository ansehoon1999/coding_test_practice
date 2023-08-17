class Solution {
    lateinit var apacheList : IntArray
    lateinit var lionList: IntArray
    var arrowCount : Int = 0
    lateinit var resultList: IntArray

    var list = IntArray(11)
    var size = 0
    var max = -1000000000

    fun solution(n: Int, info: IntArray): IntArray {

        apacheList = info
        lionList = IntArray(11) { 0 }
        arrowCount = n
        resultList = intArrayOf()

        backtracking(arrowCount, listOf(), 0)

        if(resultList.isEmpty()) {
            return intArrayOf(-1)
        } else {
            return resultList
        }
    }

    fun backtracking(arrowCount: Int, list: List<Int>, count: Int) {
        if(count == 11) {
            if(arrowCount == 0) {
                decideTheAnswer(list)

            }

            return
        }

        for(cnt in arrowCount downTo  0) {
            backtracking(arrowCount - cnt, list + listOf(cnt), count + 1)
        }

    }

    fun decideTheAnswer(list: List<Int>) {

        lionList = list.toTypedArray().toIntArray()
        apacheList = apacheList


        var apacheCount = 0
        var lionCount = 0

        for(i in 0 until 11) {
            val curApache = apacheList[i]
            val curLion = lionList[i]

            if(curApache == 0 && curLion == 0) {
                continue
            }

            if(curApache < curLion) {
                lionCount += 11 - i - 1
            } else {
                apacheCount += 11 - i - 1
            }
        }



        if(lionCount > apacheCount) {
            if(max < lionCount - apacheCount) {
                //            println("apacheList: ${apacheList.toList()}, apacheCount: ${apacheCount} / lionList: ${lionList.toList()}, lionCount: ${lionCount}")

                max = lionCount - apacheCount
                resultList = lionList
            } else if(max == lionCount - apacheCount) {
                //            println("apacheList: ${apacheList.toList()}, apacheCount: ${apacheCount} / lionList: ${lionList.toList()}, lionCount: ${lionCount}")

                resultList = compareList(resultList, lionList)
                //            println(resultList.toList())
            }

        }

    }

    fun compareList(resultList: IntArray, lionList: IntArray): IntArray {
        var flag = 0

        for(i in 10 downTo 0) {
            if (resultList[i] == lionList[i]) {
                continue
            } else if (resultList[i] < lionList[i]) {
                flag = 1
                break
            } else {
                flag = 0
                break
            }
        }

        return if(flag == 0) {
            resultList
        } else {
            lionList
        }
    }


}