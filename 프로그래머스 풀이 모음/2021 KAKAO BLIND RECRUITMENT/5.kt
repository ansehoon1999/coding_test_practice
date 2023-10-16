class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer: String = ""

        val playTime = strToInt(play_time)
        val advTime = strToInt(adv_time)
        val allTime = MutableList<Long>(playTime + 1) { 0L }

        //    println(allTime)


        logs.forEach { log ->

            val logList = log.split("-")

            val startLogTime = strToInt(logList[0])
            val endLogTime = strToInt(logList[1])

            allTime[startLogTime] += 1L
            allTime[endLogTime] -= 1L
        }

        for (i in 1 .. playTime) {
            allTime[i] += allTime[i - 1]
        }

        for (i in 1 .. playTime) {
            allTime[i] += allTime[i - 1]
        }

        var mostView = allTime[advTime - 1]
        var maxTime = 0

        for (i in advTime until playTime) {
            if(mostView < allTime[i] - allTime[i - advTime]) {
                mostView = allTime[i] - allTime[i - advTime]
                maxTime = i - advTime + 1
            }
        }

        return intToStr(maxTime)
    }


    fun strToInt(strTime: String): Int {
        val strTimeList = strTime.split(":")
        val hh = strTimeList[0].toInt()
        val mm = strTimeList[1].toInt()
        val ss = strTimeList[2].toInt()

        return hh * 3600 + mm * 60 + ss
    }

    fun intToStr(time: Int): String {
        var time = time

        var t: String? = ""
        val hour: Int = time / 3600
        time %= 3600
        t += if (hour < 10) "0$hour:" else "$hour:"

        val minute: Int = time / 60
        time %= 60
        t += if (minute < 10) "0$minute:" else "$minute:"

        val second: Int = time
        if (second < 10) t += "0$second" else t += second

        return t!!

    }
}