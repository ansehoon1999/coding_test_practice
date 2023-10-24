class Solution {

    fun solution(park: Array<String>, routes: Array<String>): IntArray {

        var currentRow = 0
        var currentCol = 0

        val parkGraph = park.map { it.toList() }

        for(row in 0 until parkGraph.size) {
            for(col in 0 until parkGraph[0].size) {
                if(parkGraph[row][col] == 'S') {
                    currentRow = row
                    currentCol = col
                }
            }
        }

        routes.forEach { route ->

            val routeList = route.split(' ')

            val direction = routeList[0]
            val directionCount = routeList[1].toInt()

            when(direction) {
                "E" -> {
                    val tmpCol = currentCol + directionCount
                    if(!isPrevented(parkGraph, direction, currentRow, currentCol, tmpCol)) {
                        currentCol = tmpCol
                    }
                }
                "S" -> {
                    val tmpRow = currentRow + directionCount
                    if(!isPrevented(parkGraph, direction, currentRow, currentCol, tmpRow)) {
                        currentRow = tmpRow
                    }
                }
                "W" -> {

                    val tmpCol = currentCol - directionCount
                    if(!isPrevented(parkGraph, direction, currentRow, currentCol, tmpCol)) {
                        currentCol = tmpCol
                    }
                }
                "N" -> {
                    val tmpRow = currentRow - directionCount
                    if(!isPrevented(parkGraph, direction, currentRow, currentCol, tmpRow)) {
                        currentRow = tmpRow
                    }
                }
                else -> {

                }
            }

        }

        return intArrayOf(currentRow, currentCol)
    }

    fun isPrevented(parkGraph: List<List<Char>>, direction: String, currentRow: Int, currentCol: Int, tmp: Int): Boolean {



        when(direction) {
            "E" -> {
                if(tmp >= parkGraph[0].size || tmp < 0) return true

                for(col in currentCol .. tmp) {
                    if(parkGraph[currentRow][col] == 'X') return true
                }
            }
            "S" -> {
                if(tmp >= parkGraph.size || tmp < 0) return true

                for(row in currentRow .. tmp) {
                    if(parkGraph[row][currentCol] == 'X') return true
                }
            }
            "W" -> {

                if(tmp >= parkGraph[0].size || tmp < 0) return true

                for(col in tmp .. currentCol) {
                    if(parkGraph[currentRow][col] == 'X') return true
                }
            }
            "N" -> {

                if(tmp >= parkGraph.size || tmp < 0) return true

                for(row in tmp .. currentRow) {
                    if(parkGraph[row][currentCol] == 'X') return true
                }
            }
            else -> {

            }
        }


        return false
    }
}