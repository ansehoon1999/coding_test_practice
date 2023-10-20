class Solution {

    var N = 0
    var M = 0

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {

        N = lock.size
        M = key.size

        for(row in 0 until N * 2) {
            for(col in 0 until N * 2) {
                for(rotateType in 0 until 4) {
                    val newLock = Array(N * 3) { IntArray(N * 3) { 0 } }

                    for(i in lock.indices) {
                        for(j in lock.indices) {
                            newLock[i+N][j+N] = lock[i][j]
                        }
                    }

                    rotate(newLock, key, rotateType, row, col)

                    if(check(newLock)) return true

                }
            }
        }


        return false
    }

    fun rotate(newLock: Array<IntArray>, key: Array<IntArray>, rotateType: Int, row: Int, col: Int) {

        when(rotateType) {
            0 -> { // itself
                for(i in 0 until M) {
                    for(j in 0 until M) {
                        newLock[i+row][j+col] += key[i][j]
                    }
                }
            }

            1 -> { // 90
                for(i in 0 until M) {
                    for(j in 0 until M) {
                        newLock[i+row][j+col] += key[j][M - i - 1]
                    }
                }
            }

            2 -> {
                for(i in 0 until M) {
                    for(j in 0 until M) {
                        newLock[i+row][j+col] += key[M-i-1][M-j-1]
                    }
                }
            }

            3 -> {
                for(i in 0 until M) {
                    for(j in 0 until M) {
                        newLock[i+row][j+col] += key[M-j-1][i]
                    }
                }
            }

            else -> {}
        }

    }

    fun check(newLock: Array<IntArray>): Boolean {
        for(i in N until 2 * N) {
            for(j in N until 2 * N) {
                if(newLock[i][j] != 1) return false
            }
        }

        return true
    }



}