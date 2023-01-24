class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val map = hashMapOf<Int, Int>()
        val n = board.size
        val destination = n * n
        fun bfs(start : Int) : Int {
            
            var state = false
            val deque = ArrayDeque<MutableSet<Int>>()
            deque.add(mutableSetOf(start))

            var count = 0

            while (deque!!.first.size != 0) {
                val tmp = mutableSetOf<Int>()
                val nodes = deque.removeFirst()
                
                println(nodes)

                if (nodes.contains(destination)) {
                    state = true
                    break
                }
                
                nodes.forEach { node ->
                    for (i in 1 .. 6) {
                        var num = node + i
                        if (map[num] != null) num = map[num]!!

                        if (num > destination) continue

                        if (num == start) continue
                        tmp.add(num)
                    }
                }

                if(nodes == tmp) {
                    break
                }
                
                deque.add(tmp)
                count ++
            }

            if (state) return count
            else return -1
        }

        for (row in n-1 downTo 0) {
            for (col in 0 until n) {
                if (board[row][col] != -1) {
                    var num = -1

                    if (n % 2 ==0) {
                        when (row % 2) {
                            0 -> num = (n-row-1) * n + (n - col) 
                            1 -> num = (n-row-1) * n + (col + 1) 
                        }
                    } else {
                        when (row % 2) {
                            0 -> num = (n-row-1) * n + (col + 1) 
                            1 -> num = (n-row-1) * n + (n - col) 
                        }                        
                    }
                    
                    println("row ${row} col ${col} num ${num}")
                    // if (num == destination || num == 1 ) continue
                    
                    map.put(num, board[row][col])
                    
                }
            }
        }


        println(map)


        return bfs(1)
    }
}