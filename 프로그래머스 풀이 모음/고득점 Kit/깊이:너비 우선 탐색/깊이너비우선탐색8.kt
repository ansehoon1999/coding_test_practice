class Solution {


    var xLength = 0
    var yLength = 0
    lateinit var usedPuzzle: MutableList<Boolean>
    var puzzleList = ArrayList<MutableList<MutableList<Int>>>()
    var spaceList = ArrayList<MutableList<MutableList<Int>>>()
    var result = 0

    var direction = mutableListOf<MutableList<Int>>(
            mutableListOf(1, 0),
            mutableListOf(-1, 0),
            mutableListOf(0, 1),
            mutableListOf(0, -1)
    )


    fun solution(gameBoard: Array<IntArray>, table: Array<IntArray>): Int {

        yLength = gameBoard.size
        xLength = gameBoard[0].size

        var visited = MutableList<MutableList<Boolean>>(yLength) {
            MutableList<Boolean>(xLength) { false }
        }

        for(y in 0 until yLength) {
            for(x in 0 until xLength) {
                if(visited[y][x] || gameBoard[y][x] == 1) continue

                spaceList.add(makeSpacePiece(y, x, visited, gameBoard))
            }
        }

        visited = MutableList<MutableList<Boolean>>(yLength) {
            MutableList<Boolean>(xLength) { false }
        }
        for(y in 0 until yLength) {
            for(x in 0 until xLength) {
                if(visited[y][x] || table[y][x] == 0) continue

                puzzleList.add(makePuzzlePiece(y, x, visited, table))
            }
        }

        usedPuzzle = MutableList<Boolean>(puzzleList.size) { false }

        puzzleList.forEach {
            it.forEach {
                println(it)
            }
            println()
        }

        backtracking(0, 0)
        return result
    }

    fun backtracking(idx: Int, sum: Int) {
        result = result.coerceAtLeast(sum)

        if(idx == spaceList.size) return

        for(i in puzzleList.indices) {
            if(usedPuzzle[i]) {
                continue
            }

            for(j in 0 until 4) {
                val matchCnt = canMatchBoard(spaceList[idx], i)

                if(matchCnt == 0) {
                    puzzleList[i] = rotate(i)
                } else {
                    usedPuzzle[i] = true
                    backtracking(idx + 1, sum+matchCnt)

                    break
                }
            }
        }

        backtracking(idx+1, sum)
    }

    fun rotate(idx: Int): MutableList<MutableList<Int>> {
        val yLen = puzzleList[idx].size
        val xLen = puzzleList[idx][0].size
        val tmp = MutableList<MutableList<Int>>(xLen) {
            MutableList<Int>(yLen) { 0 }
        }

        for(x in 0 until xLen) {
            for(y in 0 until yLen) {
                tmp[x][y] = puzzleList[idx][yLen-y-1][x]
            }
        }

        return tmp
    }

    fun canMatchBoard(space: MutableList<MutableList<Int>>, idx: Int): Int {
        val puzzle = puzzleList[idx]
        if(space.size != puzzle.size || space[0].size != puzzle[0].size) {
            return 0
        }

        var matchCnt = 0
        for(y in space.indices) {
            for(x in space[y].indices) {
                if(space[y][x] == puzzle[y][x]) {
                    return 0
                }

                if(space[y][x] == 0) matchCnt ++
            }
        }
        return matchCnt
    }

    fun makePuzzlePiece(y: Int, x: Int, visited: MutableList<MutableList<Boolean>>, table: Array<IntArray>): MutableList<MutableList<Int>> {

        var minY = y
        var maxY = y
        var minX = x
        var maxX = x

        val yxList = ArrayList<Pair<Int, Int>>()
        val deque = ArrayDeque<Pair<Int, Int>>()
        yxList.add(Pair(y, x))
        deque.add(Pair(y, x))
        visited[y][x] = true

        while(deque.isNotEmpty()) {
            val first = deque.removeFirst()
            val elementY = first.first
            val elementX = first.second

            for(i in 0 until 4) {
                val newElementY = elementY + direction[i][0]
                val newElementX = elementX + direction[i][1]

                if(newElementY !in 0 until yLength || newElementX !in 0 until xLength) continue

                if(visited[newElementY][newElementX]) continue

                if(table[newElementY][newElementX] == 0) continue

                yxList.add(Pair(newElementY, newElementX))
                deque.add(Pair(newElementY, newElementX))
                visited[newElementY][newElementX] = true
                minY = minY.coerceAtMost(newElementY)
                maxY = maxY.coerceAtLeast(newElementY)
                minX = minX.coerceAtMost(newElementX)
                maxX = maxX.coerceAtLeast(newElementX)
            }
        }

        val piece = MutableList<MutableList<Int>>(maxY-minY+1) {
            MutableList<Int>(maxX-minX+1) { 0 }
        }

        for((yy, xx) in yxList) {
            piece[yy-minY][xx-minX] = 1
        }

        return piece
    }

    fun makeSpacePiece(y: Int, x: Int, visited: MutableList<MutableList<Boolean>>, gameBoard: Array<IntArray>): MutableList<MutableList<Int>> {

        var minY = y
        var maxY = y
        var minX = x
        var maxX = x

        val yxList = ArrayList<Pair<Int, Int>>()
        val deque = ArrayDeque<Pair<Int, Int>>()
        yxList.add(Pair(y, x))
        deque.add(Pair(y, x))
        visited[y][x] = true

        while(deque.isNotEmpty()) {

            val first = deque.removeFirst()
            val elementY = first.first
            val elementX = first.second

            for(i in 0 until 4) {
                val newElementY = elementY + direction[i][0]
                val newElementX = elementX + direction[i][1]

                if(newElementX !in 0 until yLength || newElementY !in 0 until xLength) {
                    continue
                }

                if(visited[newElementY][newElementX]) continue

                if(gameBoard[newElementY][newElementX] == 1) continue

                yxList.add(Pair(newElementY, newElementX))
                deque.add(Pair(newElementY, newElementX))
                visited[newElementY][newElementX] = true

                minY = minY.coerceAtMost(newElementY)
                maxY = maxY.coerceAtLeast(newElementY)
                minX = minX.coerceAtMost(newElementX)
                maxX = maxX.coerceAtLeast(newElementX)
            }
        }

        val piece = MutableList<MutableList<Int>>(maxY-minY+1) {
            MutableList<Int>(maxX-minX+1) { 1 }
        }

        for((yy, xx) in yxList) {
            piece[yy-minY][xx-minX] = 0
        }

        return piece
    }



}