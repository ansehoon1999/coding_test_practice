class Solution {
    var result = 1

    fun solution(numbers: LongArray): IntArray {
        var answer = mutableListOf<Int>()

        var binary = ""
        numbers.forEach { num ->
            result = 1
            binary = Integer.toBinaryString(num.toInt())

            // println(binary.length)

            var start = 0
            while(true) {
                val binaryCount = Math.pow((2).toDouble(), start.toDouble())

                if(binary.length <= binaryCount) {
                    break
                }

                start++
            }

            val finalBinaryCount = Math.pow((2).toDouble(), (start).toDouble()) - 1

            repeat((finalBinaryCount - binary.length).toInt()) {
                binary = "0$binary"
            }
            // println("start: " + binary)

            divider(binary)
            answer.add(result)
        }



        return answer.toIntArray()
    }

    fun divider(binary: String) {
        if(binary.length == 1) {
            return
        }

        val mid = binary.length / 2
        //    println(binary[mid])
        if(binary[mid] == '0') {
            result = 0
            return
        }

        val front = binary.substring(0, mid)
        val behind = binary.substring(mid+1, binary.length)
        //    println(front)
        //    println(behind)

        divider(front)
        divider(behind)

    }

}