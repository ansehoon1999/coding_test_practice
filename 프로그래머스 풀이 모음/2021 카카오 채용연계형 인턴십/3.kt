import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min


fun main(args: Array<String>) {

    val n = 8
    val k = 2
    val cmd = arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C")

    println(solution(n, k, cmd))
}

private lateinit var map: HashMap<Int, Boolean>
private var curPosition = 0
private var backStk = Stack<Int>()

fun solution(n: Int, k: Int, cmd: Array<String>): String {

    map = hashMapOf()
    for(i in 0 until n) {
        map[i] = true
    }

    curPosition = k

    cmd.forEach {
        val state = it.split(" ")
        val op = state[0]

        println(it)

        when(op) {
            "U" -> {
                uOperation(state[1].toInt())
            }
            "D" -> {
                dOperation(state[1].toInt())
            }
            "C" -> {
                cOperation(n)
            }
            "Z" -> {
                zOperation()
            }
        }
    }


    println(map)


    val str = StringBuilder()

    for(i in 0 until n) {
        if(map[i] == true) {
            str.append("O")
        } else {
            str.append("X")
        }
    }

    return str.toString()
}



fun uOperation(uCount: Int) {
    var count = uCount
    var tmpPosition = curPosition

    while(count != 0) {
        val nextPosition = tmpPosition - 1
        if(map[nextPosition] == true) {
            count --
        }

        tmpPosition --
    }

    curPosition = tmpPosition

    println("curPosition: ${curPosition}")
    println("map: ${map}")
}

fun dOperation(dCount: Int) {
    var count = dCount
    var tmpPosition = curPosition

//    println("count: ${count}")
//    println("tmpPosition: ${tmpPosition}")

    while(count != 0) {
        val nexPosition = tmpPosition + 1
        if(map[nexPosition] == true) {
            count --
        }

        tmpPosition ++
    }

    curPosition = tmpPosition

    println("curPosition: ${curPosition}")
    println("map: ${map}")

}

fun cOperation(n: Int) {
    map[curPosition] = false
    backStk.add(curPosition)

    var tmpPosition = curPosition + 1
    var finalState = false

    while(true) {
        if(tmpPosition == n) {
            finalState = true
            break
        }

        if(map[tmpPosition] == true) {
            curPosition = tmpPosition
            break
        } else if(map[tmpPosition] == false) {
            tmpPosition ++
        }
    }

    if(finalState) {
        var reTmpPosition = curPosition - 1

        while(true) {
            if(map[reTmpPosition] == true) {
                curPosition = reTmpPosition
                break
            } else if(map[reTmpPosition] == false) {
                reTmpPosition --
            }
        }
    }

    println("curPosition: ${curPosition}")
    println("map: ${map}")

}

fun zOperation() {
    val top = backStk.pop()
    map[top] = true

    println("curPosition: ${curPosition}")
    println("map: ${map}")
}

