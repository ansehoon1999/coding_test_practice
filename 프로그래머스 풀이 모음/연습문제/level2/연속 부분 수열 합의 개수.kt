class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0

        val elementSet = mutableSetOf<Int>()

        var len = 1
        while(len <= elements.size) {

            var startPoint = 0
            while(startPoint <= (elements.size)) {
                var sum = 0

                for(point in startPoint until startPoint + len) {
                    sum += elements[point % elements.size]
                }

                elementSet.add(sum)

                startPoint ++
            }

            len ++

        }


        return elementSet.size
    }
}