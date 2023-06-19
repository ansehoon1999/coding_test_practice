import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.max




fun main(args: Array<String>) {


    val maps = arrayOf(
            intArrayOf(1,0,1,1,1),
            intArrayOf(1,0,1,0,1),
            intArrayOf(1,0,1,1,1),
            intArrayOf(1,1,1,0,1),
            intArrayOf(0,0,0,0,1)
    )

    println(solution(maps))

}

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

lateinit var visited: MutableList<MutableList<Boolean>>

var xLength = 0
var yLength = 0

var result = 10000000

fun solution(maps: Array<IntArray>): Int {

    xLength = maps.size
    yLength = maps[0].size

    visited = MutableList<MutableList<Boolean>>(xLength) { MutableList<Boolean>(yLength) { false } }

    for(i in 0 until xLength) {
        for(j in 0 until yLength) {
            if(maps[i][j] == 0) {
                visited[i][j] = true
            }
        }
    }

    visited[0][0] = true
    dfs(0, 0, 1)

    if (result == 10000000) {
        return -1
    } else {
        return result
    }
}

fun dfs(posX: Int, posY: Int, count: Int) {
//    println("${posX} ${posY}")
//    visited.forEach {
//        println(it)
//    }
//    println()

    if(posX == xLength-1 && posY == yLength-1) {

        result = minOf (result, count)
        return
    }

    for(i in 0 until 4) {
        val newPosX = posX + dx[i]
        val newPosY = posY + dy[i]

        if(newPosX in 0 until xLength && newPosY in 0 until yLength) {

            if(!visited[newPosX][newPosY]) {
                visited[newPosX][newPosY] = true
                dfs(newPosX, newPosY, count+1)
                visited[newPosX][newPosY] = false
            }
        }
    }

}


//fun solution(maps: Array<IntArray>): Int {
//
//    val xLength = maps.size
//    val yLength = maps[0].size
//
//    val visited = MutableList<MutableList<Boolean>>(xLength) { MutableList<Boolean>(yLength) { false } }
//
//    for(i in 0 until xLength) {
//        for(j in 0 until yLength) {
//            if(maps[i][j] == 0) {
//                visited[i][j] = true
//            }
//        }
//    }
//
//    val deque = ArrayDeque<Pair<Int, Int>>()
//    deque.add(Pair(0, 0))
//    visited[0][0] = true
//    var cnt = 1
//
//    while(deque.isNotEmpty()) {
//        val element = deque.removeFirst()
//        cnt ++
//
//        val elementX = element.first
//        val elementY = element.second
//
//        for(i in 0 until 4) {
//            val newElementX = elementX + dx[i]
//            val newElementY = elementY + dy[i]
//
//            if(newElementX in 0 until xLength && newElementY in 0 until yLength) {
//
//                if(!visited[newElementX][newElementY]) {
//                    visited[newElementX][newElementY] = true
//                    deque.add(Pair(newElementX, newElementY))
//                }
//            }
//        }
//
//        println(deque)
//    }
//
//    return cnt
//
//}







