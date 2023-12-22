class Solution {

    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0

        val hashMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
        val bookTimeList = mutableListOf<Pair<Int, Int>>()

        book_time.forEach {
            val start = it[0].split(":")
            val startHour = start[0].toInt()
            val startMinute = start[1].toInt()

            val end = it[1].split(":")
            val endHour = end[0].toInt()
            val endMinute = end[1].toInt()

            bookTimeList.add(Pair(startHour * 60 + startMinute, endHour * 60 + endMinute))
        }

        bookTimeList.sortBy { it.second }
        bookTimeList.sortBy { it.first}

        var curCnt = 0

        bookTimeList.forEach { bookTime ->

            if(hashMap.isEmpty()) {
                hashMap[curCnt] = mutableListOf(bookTime)
                curCnt = 1
            } else {
                var flag = false

                for(cnt in 0 until curCnt) {
                    if(hashMap[cnt]!!.last().second + 10 <= bookTime.first) {
                        hashMap[cnt]!!.add(bookTime)
                        flag = true
                        break
                    }
                }

                if(!flag) {
                    hashMap[curCnt] = mutableListOf(bookTime)
                    curCnt ++
                }
            }

            // println(hashMap)
        }

        // println(bookTimeList)

        return hashMap.size
    }
}