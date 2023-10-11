import java.util.StringTokenizer

class Solution {

    var count = 0

    fun solution(info: Array<String>, query: Array<String>): IntArray {

        val answer = IntArray(query.size)

        val infoMap = mutableMapOf<String, ArrayList<Int>>()

        for(sen in info) {
            val tk = StringTokenizer(sen)
            val word = Array<Array<String>>(4) {
                Array<String>(2) {
                    "-"
                }
            }

            for(i in 0 until 4) {
                word[i][0] = tk.nextToken()
            }

            val score  = Integer.parseInt(tk.nextToken())
            dfs(infoMap, word, score, "", 0)
        }

        infoMap.forEach {
            it.value.sort()
        }

        for(i in query.indices) {
            val tk = StringTokenizer(query[i])
            var sentence = ""

            for(j in 0 until 8) {
                val str = tk.nextToken()
                if(j % 2 == 0) {
                    sentence += str
                } else if(j == 7) {
                    if(infoMap[sentence] == null) answer[i] = 0
                    else {
                        answer[i] = lower_bound(infoMap[sentence]!!, Integer.parseInt(str))
                    }
                }
            }
        }

        return answer
    }

    fun dfs(infoMap: MutableMap<String, ArrayList<Int>>, word: Array<Array<String>>, score: Int, sentence: String, cnt: Int) {
        if(cnt == 4) {
            count++
            if(infoMap[sentence] == null) {
                infoMap.put(sentence, ArrayList<Int>())
            }
            infoMap[sentence]?.add(score)
            return
        }

        dfs(infoMap, word, score, sentence + word[cnt][0], cnt + 1 )
        dfs(infoMap, word, score, sentence + word[cnt][1], cnt + 1)
    }

    fun lower_bound(arrNum: ArrayList<Int>, score: Int): Int {
        var low = 0
        var high = arrNum.size - 1

        while(low <= high) {
            var mid = (low + high) / 2

            if(arrNum[mid] < score) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return arrNum.size - low
    }
}