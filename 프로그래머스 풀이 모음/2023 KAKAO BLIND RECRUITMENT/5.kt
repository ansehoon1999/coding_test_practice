import java.util.*

class Solution {
    private lateinit var req: MutableList<MutableList<String>>

    private lateinit var merge: MutableList<MutableList<Pair<Int, Int>>>

    fun solution(commands: Array<String>): Array<String> {
        var answerLength = 0

        val res: Queue<String> = LinkedList()

        req = MutableList<MutableList<String>>(51) {
            MutableList<String>(51) { "" }
        }

        merge = MutableList<MutableList<Pair<Int, Int>>>(51) { r ->
            MutableList<Pair<Int, Int>>(51) { c ->
                Pair(r, c)
            }
        }

        commands.forEach { command ->

            val commandList = command.split(" ")
            val commandSize = commandList.size

            when (commandList[0]) {
                "UPDATE" -> {
                    if (commandSize == 4) {
                        updatePointValue(commandList)
                    } else if (commandSize == 3) {
                        updateReplaceValue(commandList)
                    }
                }

                "MERGE" -> {
                    mergeTwoValues(commandList)
                }

                "UNMERGE" -> {
                    unmergeValues(commandList)
                }

                "PRINT" -> {
                    val r = commandList[1].toInt()
                    val c = commandList[2].toInt()
                    answerLength++

                    val newR = merge[r][c].first
                    val newC = merge[r][c].second

                    val str = req[newR][newC]

                    if(str == "") {
                        res.add("EMPTY")
                    } else {
                        res.add(str)
                    }
                }
            }

            //        req.forEach {
            //            println(it)
            //        }
            //
            //        merge.forEach {
            //            println(it)
            //        }
            //
            //        println()
        }

        var answer = MutableList<String>(answerLength) { "" }

        var idx = 0
        // while (!res.isEmpty()) {
        //     answer[idx] = res.poll()
        //     idx++
        // }


        return res.toTypedArray()
    }

    fun updatePointValue(commandList: List<String>) {
        val r = commandList[1].toInt()
        val c = commandList[2].toInt()
        val str = commandList[3]

        req[merge[r][c].first][merge[r][c].second] = str

    }

    fun updateReplaceValue(commandList: List<String>) {
        val str1 = commandList[1]
        val str2 = commandList[2]

        for (r in 0 until 51) {
            for (c in 0 until 51) {
                if (req[r][c] == str1) {
                    req[r][c] = str2
                }
            }
        }
    }

    fun mergeTwoValues(commandList: List<String>) {
        val r1 = commandList[1].toInt()
        val c1 = commandList[2].toInt()

        val r2 = commandList[3].toInt()
        val c2 = commandList[4].toInt()

        val newR1 = merge[r1][c1].first
        val newC1 = merge[r1][c1].second

        val newR2 = merge[r2][c2].first
        val newC2 = merge[r2][c2].second

        for(j in 0 until 51) {
            for(k in 0 until 51) {
                if(merge[j][k].first == newR2 && merge[j][k].second == newC2) {
                    merge[j][k] = Pair(newR1, newC1)
                }
            }
        }

        if(newR1 != newR2 || newC1 != newC2) {
            if(req[newR1][newC1] != "" && req[newR2][newC2] == "") {
                req[newR2][newC2] = req[newR1][newC1]
            } else if(req[newR1][newC1] == "" && req[newR2][newC2] != "") {
                req[newR1][newC1] = req[newR2][newC2]
            } else if(req[newR1][newC1] != "" && req[newR2][newC2] != "") {
                req[newR2][newC2] = req[newR1][newC1]
            }
        }


    }

    fun unmergeValues(commandList: List<String>) {
        val r = commandList[1].toInt()
        val c = commandList[2].toInt()

        val newR = merge[r][c].first
        val newC = merge[r][c].second
        val str = req[newR][newC]

        for(j in 1 until 51) {
            for(k in 1 until 51) {
                if(merge[j][k].first == newR && merge[j][k].second == newC) {
                    merge[j][k] = Pair(j, k)
                    req[j][k] = ""
                }
            }
        }

        req[r][c] = str

    }

}