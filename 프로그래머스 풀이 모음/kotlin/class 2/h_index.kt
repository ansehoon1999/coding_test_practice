


fun main() {

    val citations = mutableListOf<Int>(3, 0, 6, 1, 5).toIntArray()
    val size = citations.size

    var result = 0
    for (i in 0 until size) {
        val h = i+1
        var count_up = 0
        var count_down = 0
        for (j in 0 until size) {
            if (citations[j] >  h) {
                count_up ++
            } else if (citations[j] < h) {
                count_down++
            } else {
                count_up ++
                count_down ++
            }
        }
        
        if (h <= count_up && count_down <= h) {
            result = Math.max(result, h)
        }
    }

    println(result)


}


