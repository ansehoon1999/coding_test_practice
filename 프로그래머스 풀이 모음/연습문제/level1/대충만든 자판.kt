class Solution {

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = IntArray(targets.size)

        val hashMap = hashMapOf<Char, Int>()

        keymap.forEach { key  ->

            key.forEachIndexed { idx, keyChar ->

                if(hashMap[keyChar] == null) {
                    hashMap[keyChar] = idx + 1
                } else {
                    hashMap[keyChar] = minOf(hashMap[keyChar]!!, idx + 1)
                }
            }
        }

        targets.forEachIndexed { idx, target ->

            var tmp = 0
            for(i in 0 until target.length) {
                if(hashMap[target[i]] == null) {
                    tmp = 0
                    break
                } else {
                    tmp += hashMap[target[i]]!!
                }
            }


            answer[idx] = tmp
        }

        for(i in 0 until answer.size) {
            if(answer[i] == 0) answer[i] = -1
        }
        return answer
    }
}