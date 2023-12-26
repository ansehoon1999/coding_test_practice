class Solution {

    private lateinit var boardResult: MutableList<MutableList<String>>

    var answer: Int = -1

    var tmp = 0

    fun solution(board: Array<String>): Int {

        boardResult = MutableList<MutableList<String>>(3) {
            MutableList<String>(3) { "." }
        }

        var oCnt = 0
        var xCnt = 0

        for(row in 0 until 3) {
            val rowList = board[row].toList().map { it.toString() }
            for(col in 0 until 3) {
                boardResult[row][col] = rowList[col]

                if(boardResult[row][col] == "O") oCnt ++
                if(boardResult[row][col] == "X") xCnt ++
            }
        }

        if(oCnt == xCnt + 1) {
            if(isValidX()) {
                return 0
            }


            return 1
        } else if(oCnt == xCnt) {
            if(isValidO()) return 0
            else return 1
        }

        return 0
    }

    fun isValidO(): Boolean {
        if(boardResult[0][0] == "O" && boardResult[1][0] == "O" && boardResult[2][0] == "O") return true
        if(boardResult[0][1] == "O" && boardResult[1][1] == "O" && boardResult[2][1] == "O") return true
        if(boardResult[0][2] == "O" && boardResult[1][2] == "O" && boardResult[2][2] == "O") return true

        if(boardResult[0][0] == "O" && boardResult[0][1] == "O" && boardResult[0][2] == "O") return true
        if(boardResult[1][0] == "O" && boardResult[1][1] == "O" && boardResult[1][2] == "O") return true
        if(boardResult[2][0] == "O" && boardResult[2][1] == "O" && boardResult[2][2] == "O") return true
        if(boardResult[0][0] == "O" && boardResult[1][1] == "O" && boardResult[2][2] == "O") return true
        if(boardResult[2][0] == "O" && boardResult[1][1] == "O" && boardResult[0][2] == "O") return true
        return false
    }

    fun isValidX(): Boolean {
        if(boardResult[0][0] == "X" && boardResult[1][0] == "X" && boardResult[2][0] == "X") return true
        if(boardResult[0][1] == "X" && boardResult[1][1] == "X" && boardResult[2][1] == "X") return true
        if(boardResult[0][2] == "X" && boardResult[1][2] == "X" && boardResult[2][2] == "X") return true

        if(boardResult[0][0] == "X" && boardResult[0][1] == "X" && boardResult[0][2] == "X") return true
        if(boardResult[1][0] == "X" && boardResult[1][1] == "X" && boardResult[1][2] == "X") return true
        if(boardResult[2][0] == "X" && boardResult[2][1] == "X" && boardResult[2][2] == "X") return true
        if(boardResult[0][0] == "X" && boardResult[1][1] == "X" && boardResult[2][2] == "X") return true
        if(boardResult[2][0] == "X" && boardResult[1][1] == "X" && boardResult[0][2] == "X") return true
        return false
    }
}