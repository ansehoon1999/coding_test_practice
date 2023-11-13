class Solution {

    val numHashMap = hashMapOf<String, Pair<Int, Int>>(
            "1" to Pair(0, 0),
            "2" to Pair(0, 1),
            "3" to Pair(0, 2),
            "4" to Pair(1, 0),
            "5" to Pair(1, 1),
            "6" to Pair(1, 2),
            "7" to Pair(2, 0),
            "8" to Pair(2, 1),
            "9" to Pair(2, 2),
            "*" to Pair(3, 0),
            "0" to Pair(3, 1),
            "#" to Pair(3, 2)
    )


    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        var leftHand = "*"
        var leftPosition = numHashMap[leftHand]!!

        var rightHand = "#"
        var rightPosition = numHashMap[rightHand]!!


        numbers.forEach { num ->
            if(num == 1 || num == 4 || num == 7) {
                leftHand = num.toString()
                leftPosition = numHashMap[num.toString()]!!

                answer += "L"
            }

            if(num == 3 || num == 6 || num == 9) {
                rightHand = num.toString()
                rightPosition = numHashMap[num.toString()]!!

                answer += "R"
            }

            if(num == 2 || num == 5 || num == 8 || num == 0) {
                val leftLen = Math.abs(leftPosition.first - numHashMap[num.toString()]!!.first) + Math.abs(leftPosition.second - numHashMap[num.toString()]!!.second)



                val rightLen = Math.abs(rightPosition.first - numHashMap[num.toString()]!!.first) + Math.abs(rightPosition.second - numHashMap[num.toString()]!!.second)

                if(leftLen > rightLen) {
                    rightHand = num.toString()
                    rightPosition = numHashMap[num.toString()]!!

                    answer += "R"
                } else if(leftLen < rightLen) {
                    leftHand = num.toString()
                    leftPosition = numHashMap[num.toString()]!!

                    answer += "L"
                } else {
                    println("same")
                    if(hand == "left") {
                        leftHand = num.toString()
                        leftPosition = numHashMap[num.toString()]!!

                        answer += "L"
                    } else {
                        rightHand = num.toString()
                        rightPosition = numHashMap[num.toString()]!!

                        answer += "R"
                    }
                }
            }

        }


        return answer
    }
}