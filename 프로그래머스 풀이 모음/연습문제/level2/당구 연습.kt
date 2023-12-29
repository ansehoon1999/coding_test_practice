class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(balls.size)

        balls.forEachIndexed { idx, ball ->

            val ballX = ball[0]
            val ballY = ball[1]

            var result = 0

            if(startX == ballX) {
                val d1 = (startY - ballY) * (startY - ballY) + 4 * startX * startX
                val d2 = (startY - ballY) * (startY - ballY) + 4 * (m - startX) * (m - startX)

                val d3 = if(startY < ballY) (ballY + startY) * (ballY + startY) else (2 * n - ballY - startY) * (2 * n - ballY - startY)

                answer[idx] = minOf(minOf(d1, d2), d3)

            } else if(startY == ballY) {

                val d1 = (startX - ballX) * (startX - ballX) + 4 * startY * startY
                val d2 = (startX - ballX) * (startX - ballX) + 4 * (n - startY) * (n - startY)

                val d3 = if(startX < ballX) (ballX + startX) * (ballX + startX) else (2 * m - ballX - startX) * (2 * m - ballX - startX)

                // println("${d1}, ${d2} ${d3}")
                answer[idx] = minOf(minOf(d1, d2), d3)

            } else {

                val d1 = (startX + ballX) * (startX + ballX) + (startY - ballY) * (startY - ballY)
                val d2 = (2 * m - startX - ballX) * (2 * m - startX - ballX) + (startY - ballY) * (startY - ballY)

                val d3 = (startY + ballY) * (startY + ballY) + (startX - ballX) * (startX - ballX)
                val d4 = (2 * n - startY - ballY) * (2 * n - startY - ballY) + (startX - ballX) * (startX - ballX)

                answer[idx] = minOf(minOf(d1, d2), minOf(d3, d4))
            }


        }

        return answer
    }
}