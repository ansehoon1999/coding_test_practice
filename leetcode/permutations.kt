

var endpoint = 0
val result = mutableListOf<List<Int>>()
val tmp = mutableListOf<Int>()


fun main() {
    val nums = mutableListOf<Int>(1,2,3,4).toIntArray()

    endpoint = nums.size

    for (i in 0 until endpoint) {
        permuation(i, nums)
    }

    println(result)
}

fun permuation(count : Int, nums : IntArray) {
    if (count == nums.size && nums.size == tmp.size) {

        result.add(tmp.toList())
        return


    } else {
        nums.forEach { num ->
            if (!tmp.contains(num)) {
                tmp.add(num)
                permuation(count+1, nums)
                tmp.remove(num)
            }
        }


    }
}