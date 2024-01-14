import java.util.StringTokenizer

class Solution {

    val hashMap = hashMapOf<String, MutableList<Int>>()
    var count=0
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)


//         info.forEach { infoStr ->
//             val infoList = infoStr.split(" ")

//             var lang = listOf<String>("-", infoList[0])
//             var job = listOf<String>("-", infoList[1])
//             var career = listOf<String>("-", infoList[2])
//             var soul = listOf<String>("-", infoList[3])

//             val newInfoList = listOf(lang, job, career, soul)
//             val score = infoList[4].toInt()

//             combination(0, score, "", newInfoList)
//         }

//         for((key, value) in hashMap) {
//             value.sort()
//         }

        for(sen in info){
            val tk = StringTokenizer(sen)
            val word= Array<Array<String>>(4){Array<String>(2){"-"} }
            for(i in 0 until 4){
                word[i][0]=tk.nextToken()
            }
            val score = Integer.parseInt(tk.nextToken())
            combination(0, score, "", word)
            count=0
        }
        for(i in hashMap){
            i.value.sort()
        }

        // println(hashMap)


        for(i in query.indices){
            val tk = StringTokenizer(query[i])
            var sentence =""

            for(j in 0 until 8){
                val str = tk.nextToken()
                if(j%2==0)
                    sentence+=str
                else if(j==7){
                    if(hashMap[sentence]==null){
                        answer[i]=0
                    }
                    else{
                        answer[i] = lowerBound(hashMap[sentence]!!,Integer.parseInt(str))
                    }
                }

            }

        }

        return answer
    }

    fun lowerBound(list: MutableList<Int>, score: Int): Int {

        var low = 0
        var high = list.size - 1

        while(low <= high) {
            var mid = (low + high) / 2
            if(list[mid] < score) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return list.size - low

    }


    fun combination(depth: Int, score: Int, str: String, newInfoList: Array<Array<String>>) {

        if(depth == 4) {


            if(hashMap[str] == null) {
                hashMap[str] = mutableListOf<Int>(score)
            } else {
                hashMap[str]?.add(score)
            }

            return
        }

        combination(depth + 1, score, str + newInfoList[depth][0], newInfoList)
        combination(depth + 1, score, str + newInfoList[depth][1], newInfoList)


    }
}