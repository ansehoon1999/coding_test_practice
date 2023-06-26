import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val game_board = arrayOf(
            intArrayOf(1,1,0,0,1,0),
            intArrayOf(0,0,1,0,1,0),
            intArrayOf(0,1,1,0,0,1),
            intArrayOf(1,1,0,1,1,1),
            intArrayOf(1,0,0,0,1,0),
            intArrayOf(0,1,1,1,0,0),
    )

    val table = arrayOf(
            intArrayOf(1,0,0,1,1,0),
            intArrayOf(1,0,1,0,1,0),
            intArrayOf(0,1,1,0,1,1),
            intArrayOf(0,0,1,0,0,0),
            intArrayOf(1,1,0,1,1,0),
            intArrayOf(0,1,0,0,0,0),
    )

    println(solution(game_board, table))
}

var yLength = 0
var xLength = 0
var answer = 0
lateinit var usedPuzzle: MutableList<Boolean>
val puzzleList = ArrayList<MutableList<MutableList<Int>>>()
val spaceList = ArrayList<MutableList<MutableList<Int>>>()
val direction = mutableListOf<MutableList<Int>>(
        mutableListOf(-1, 0),
        mutableListOf(0, 1),
        mutableListOf(1, 0),
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
            if(visited[y][x] || table[y][x] == 0) {
                continue
            }
            puzzleList.add(makePuzzlePiece(table, visited, y, x))
        }
    }

    usedPuzzle = MutableList<Boolean>(puzzleList.size) { false }
    visited = MutableList<MutableList<Boolean>>(yLength) {
        MutableList<Boolean>(xLength) { false }
    }
    for(y in 0 until yLength) {
        for(x in 0 until xLength) {
            if(visited[y][x] || gameBoard[y][x] == 1) continue

            spaceList.add(makeSpacePiece(gameBoard, visited, y, x))
        }
    }


    puzzleList.forEach {
        it.forEach {
            println(it)
        }
        println()
    }

    println()

    spaceList.forEach {
        it.forEach {
            println(it)
        }
        println()
    }

    backtracking(0, 0)

    return answer
}

fun backtracking(idx: Int, sum: Int) {

    answer = answer.coerceAtLeast(sum)
    if(idx == spaceList.size) {
        return
    }

    for(i in puzzleList.indices) {
        if(usedPuzzle[i]) {
            continue
        }

        for(j in 0 until 4) {
            val matchCnt = canMatchBoard(spaceList[idx], i)

            if(matchCnt == 0 ) {
                puzzleList[i] = rotate(i)
            } else {
                usedPuzzle[i] = true
                backtracking(idx+1, sum + matchCnt)

                break
            }
        }
    }

    backtracking(idx+1, sum)
}

fun canMatchBoard(space: MutableList<MutableList<Int>>, idx: Int): Int {
    val puzzle = puzzleList[idx]

    if(space.size != puzzle.size || space[0].size != puzzle[0].size) {
        return 0
    }

    var matchCnt = 0
    for(y in space.indices) {
        for(x in space[y].indices) {
            if(space[y][x] == puzzle[y][x]) return 0

            if(space[y][x] == 0) matchCnt++
        }
    }

    return matchCnt
}

fun rotate(idx: Int): MutableList<MutableList<Int>> {
    val xLen = puzzleList[idx][0].size
    val yLen = puzzleList[idx].size
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


fun makePuzzlePiece(table: Array<IntArray>, visited: MutableList<MutableList<Boolean>>, y: Int, x: Int): MutableList<MutableList<Int>> {

    val yxList = mutableListOf<Pair<Int, Int>>()

    var minY = y
    var maxY = y
    var minX = x
    var maxX = x

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(y, x))
    visited[y][x] = true
    yxList.add(Pair(y, x))

    while(deque.isNotEmpty()) {

        val first = deque.removeFirst()
        val elementX = first.second
        val elementY = first.first

        for(i in 0 until 4) {
            val newElementX = elementX + direction[i][1]
            val newElementY = elementY + direction[i][0]

            if(newElementX !in 0 until xLength || newElementY !in 0 until yLength) {
                continue
            }

            if(visited[newElementY][newElementX] ||  table[newElementY][newElementX] == 0) continue


            deque.add(Pair(newElementY, newElementX))
            visited[newElementY][newElementX] = true
            yxList.add(Pair(newElementY, newElementX))

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

fun makeSpacePiece(gameBoard: Array<IntArray>, visited: MutableList<MutableList<Boolean>>, y: Int, x: Int): MutableList<MutableList<Int>> {


    var minY = y
    var maxY = y
    var minX = x
    var maxX = x

    val yxList = mutableListOf<Pair<Int, Int>>()
    val deque = ArrayDeque<Pair<Int, Int>>()
    visited[y][x] = true

    yxList.add(Pair(y, x))
    deque.add(Pair(y, x))

    while(deque.isNotEmpty()) {
        val first = deque.removeFirst()

        val elementX = first.second
        val elementY = first.first

        for(i in 0 until 4) {
            val newElementY = elementY + direction[i][0]
            val newElementX = elementX + direction[i][1]

            if(newElementX !in 0 until xLength || newElementY !in 0 until yLength) continue

            if(visited[newElementY][newElementX]) continue

            if(gameBoard[newElementY][newElementX] == 1) continue

            yxList.add(Pair(newElementY, newElementX))
            deque.add(Pair(newElementY, newElementX))
            visited[newElementY][newElementX] = true

            minX = minX.coerceAtMost(newElementX)
            maxX = maxX.coerceAtLeast(newElementX)
            minY = minY.coerceAtMost(newElementY)
            maxY = maxY.coerceAtLeast(newElementY)
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