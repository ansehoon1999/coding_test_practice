class Solution {

    var M = 0
    var N = 0

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var answer = true

        M = key.size
        N = lock.size

        val newLock = MutableList<MutableList<Int>>(N * 3) {
            MutableList<Int>(N * 3) { 0 }
        }

        for(r in 0 until N) {
            for(c in 0 until N) {
                newLock[N + r][N + c] = lock[r][c]
            }
        }

        // newLock.forEach {
        //     println(it)
        // }
        // println()

        for(r in 0 .. 2 * N) {
            for(c in 0 .. 2 * N) {
                for(rot in 0 until 4) {

                    val tmpLock = MutableList<MutableList<Int>>(newLock.size) {
                        MutableList<Int>(newLock.size) { 0 }
                    }

                    for(r in 0 until newLock.size) {
                        for(c in 0 until newLock[0].size) {
                            tmpLock[r][c] = newLock[r][c]
                        }
                    }

                    val newKey = rotation(key, rot)

                    if(check(r, c, tmpLock, newKey)) return true
                }
            }
        }

        return false
    }

    fun rotation(key: Array<IntArray>, rotation: Int): Array<IntArray> {

        val tmpKey = Array<IntArray>(key.size) {
            IntArray(key[0].size) { 0 }
        }

        if(rotation == 0) {

            // 0 0 0
            // 1 0 0
            // 0 1 1

            for(r in 0 until key.size) {
                for(c in 0 until key.size) {
                    tmpKey[r][c] = key[r][c]
                }
            }
        } else if(rotation == 1) {

            // 0 1 0
            // 1 0 0
            // 1 0 0

            for(r in 0 until key.size) {
                for(c in 0 until key.size) {
                    tmpKey[r][c] = key[key.size - 1 - c][r]
                }
            }
        } else if(rotation == 2) {

            // 1 1 0
            // 0 0 1
            // 0 0 0

            for(r in 0 until key.size) {
                for(c in 0 until key.size) {
                    tmpKey[r][c] = key[key.size - 1 - r][key.size - 1 - c]
                }
            }
        } else if(rotation == 3) {
            // 0 0 1
            // 0 0 1
            // 0 1 0

            for(r in 0 until key.size) {
                for(c in 0 until key.size) {
                    tmpKey[r][c] = key[c][key.size - 1 - r]
                }
            }
        }

//         when(rotation) {
//             0 -> {



//                 for(r in 0 until key.size) {
//                     for(c in 0 until key.size) {
//                         tmpKey[r][c] = key[r][c]
//                     }
//                 }
//             1 -> {

//                 // 0 1 0
//                 // 1 0 0
//                 // 1 0 0

//                 for(r in 0 until key.size) {
//                     for(c in 0 until key.size) {
//                         tmpKey[r][c] = key[c][r]
//                     }
//                 }
//             }

//             2 -> {

//             }

//             3 -> {

//             }

//         }

        // tmpKey.forEach {
        //     println(it.toList())
        // }
        // println()

        return tmpKey

    }

    fun check(startR: Int, startC: Int, lock: MutableList<MutableList<Int>>, key: Array<IntArray>): Boolean {

        for(r in 0 until key.size) {
            for(c in 0 until key.size) {
                lock[startR + r][startC + c] = lock[startR + r][startC + c] + key[r][c]
            }
        }

        // lock.forEach {
        //     println(it)
        // }
        // println()

        for(r in (lock.size / 3) until (lock.size / 3 * 2)) {
            for(c in (lock.size / 3) until (lock.size / 3 * 2)) {
                if(lock[r][c] != 1) return false
            }
        }

        return true
    }
}