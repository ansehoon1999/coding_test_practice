import kotlin.Float.Companion.MAX_VALUE

class Solution {

    private lateinit var matrix: Array<FloatArray>

    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {

        var maxAlp = 0
        var maxCop = 0

        problems.forEach {
            maxAlp = maxOf(maxAlp, it[0])
            maxCop = maxOf(maxCop, it[1])
        }

        matrix = Array(maxAlp+3) {
            FloatArray(maxCop+3) {
                MAX_VALUE
            }
        }

        var alp = minOf(alp, maxAlp)
        var cop = minOf(cop, maxCop)

        matrix[alp][cop] = 0f



        for(i in alp until maxAlp +1) {
            for(j in cop until maxCop + 1) {
                if(i+1 <= maxAlp) {
                    matrix[i+1][j] = minOf(matrix[i+1][j], matrix[i][j] + 1)
                }

                if(j+1 <= maxCop) {
                    matrix[i][j+1] = minOf(matrix[i][j+1], matrix[i][j] + 1)
                }

                problems.forEach {

                    val alp_req = it[0]
                    val cop_req = it[1]

                    val alp_rwd = it[2]
                    val cop_rwd = it[3]

                    val cost = it[4]

                    if(i >= alp_req && j >= cop_req) {
                        val next_alp = minOf(maxAlp, i + alp_rwd)
                        val next_cop = minOf(maxCop, j + cop_rwd)

                        matrix[next_alp][next_cop] = minOf(matrix[next_alp][next_cop], matrix[i][j] + cost)
                    }
                }
            }
        }

        return matrix[maxAlp][maxCop].toInt()
    }





}