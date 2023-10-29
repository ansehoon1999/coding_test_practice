class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0

        val sectionArray = IntArray(n)

        section.forEach { pos ->
            sectionArray[pos-1] = 1
        }

        var curIdx = 0
        while(curIdx <= n - m) {

            val curSection = sectionArray[curIdx]
            if(curSection == 1) {

                for(idx in curIdx until curIdx + m) {
                    sectionArray[idx] = 0
                }
                answer ++
            }


            // println("${curIdx}: ${sectionArray.toList()}")
            curIdx ++
        }

        curIdx = n-1
        while(curIdx >= m-1) {

            val curSection = sectionArray[curIdx]
            if(curSection == 1) {

                for(idx in curIdx downTo curIdx - m + 1) {
                    sectionArray[idx] = 0

                }
                answer ++
            }

            curIdx --
        }



        return answer
    }
}