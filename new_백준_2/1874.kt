import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.Stack

data class Node(
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 1. Stack
     */



    val stk = Stack<Int>()

    var tmpNum = 1

    val n = br.readLine().toInt()
    val inputList = mutableListOf<Int>()
    repeat(n) {
        val input = br.readLine().toInt()
        inputList.add(input)
    }

    val opList = mutableListOf<String>()

    inputList.forEach { num ->

//        println("opList: ${opList}")
//        println("stk: ${stk}")

        if(tmpNum <= num) {

            while(stk.isEmpty() || tmpNum <= num) {

                stk.add(tmpNum)
                opList.add("+")
                tmpNum ++
            }

            stk.pop()
            opList.add("-")
        } else {

            if(stk.isNotEmpty() && stk.last() == num) {
                stk.pop()
                opList.add("-")
            }
        }

    }


    if(stk.isEmpty()) {
        opList.forEach {
            println(it)
        }
    } else {
        println("NO")
    }



    writer.flush()
    writer.close()
}

