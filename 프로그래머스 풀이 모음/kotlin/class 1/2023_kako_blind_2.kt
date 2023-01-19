



fun main() {
    val cap = 4
    val n = 5
    val deliveries = intArrayOf(1, 0, 3, 1, 2)
    val pickups = intArrayOf(0, 3, 0, 4, 0)
    deliveries.size

    var cur = n - 1 // 4
    //4
    var result : Long = 0
    var dis : Long = (n - 1).toLong()
    while (dis != -1L) {
        var count = cap
        var end = 0
        for (i in dis downTo 0) {
            if (deliveries[i.toInt()] > count) {
                deliveries[i.toInt()] -= count
                count = 0
            } else {
                count -= deliveries[i.toInt()]
                deliveries[i.toInt()] = 0
            }

            if (count == 0) break
        }

        for (i in dis downTo 0) {
            val store = cap - end

            if (store > pickups[i.toInt()]) {
                end += pickups[i.toInt()]
                pickups[i.toInt()] = 0
            } else {
                pickups[i.toInt()] -= store
                end = cap
            }

            if (end == cap) break
        }

        if (!(count == cap) && !(end == 0)) {
            result += (dis + 1) * 2
        }

        for (i in dis downTo 0) {
            if (deliveries[i.toInt()] == 0 && pickups[i.toInt()] == 0) dis--
            else break
        }
    }

    println(result)

}

