fun solution(info: Array<String>, query: Array<String>): IntArray {

    val answer = IntArray(info.size)

    val infoMap = mutableMapOf<String, ArrayList<Int>>()

    info.forEach {
        val infoList = it.split(" ")
        val subList = Array<Array<String>>(4) {
            Array<String>(2) { "-" }
        }

        for (i in 0 until 4) {
            subList[i][0] = infoList[i]
        }

        val score = infoList[4].toInt()

        makeCase(infoMap, subList, score, "", 0)
    }

    infoMap.forEach {
        it.value.sort()
    }

    for(i in query.indices) {
        val queryList = query[i].split(" ")
        var sentence = ""

        for(j in queryList.indices) {
            if(j % 2 == 0) {
                sentence += queryList[j]
            } else if(j == 7) {
                if(infoMap[sentence] == null) answer[i] = 0
                else answer[i] = lowerBound(infoMap[sentence]!!, queryList[7].toInt())
            }
        }

    }

    return answer
}

fun makeCase(infoMap: MutableMap<String, ArrayList<Int>>, subList: Array<Array<String>>, score: Int, sentence: String, cnt: Int) {

    if (cnt == 4) {

        if(infoMap[sentence] == null) {
            infoMap[sentence] = arrayListOf()
        }

        infoMap[sentence]?.add(score)

        return
    }

    makeCase(infoMap, subList, score, sentence + subList[cnt][0], cnt + 1)
    makeCase(infoMap, subList, score, sentence + subList[cnt][1], cnt + 1)

}

fun lowerBound(infoMapList: ArrayList<Int>, score: Int): Int {

    var low = 0
    var high = infoMapList.size - 1

    while(low <= high) {
        val mid = (low + high) / 2
        if(infoMapList[mid] < score) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return infoMapList.size - low
}

