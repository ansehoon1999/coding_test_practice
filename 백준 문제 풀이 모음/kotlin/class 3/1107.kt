package class3

val btn : MutableList<String> = mutableListOf()
var count = 1
val can = mutableListOf<String>()
fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val count = readLine().toInt()
    if (count == 0) {
        print(Math.min(n.toString().toCharArray().size, Math.abs(n-100)))
    } else {
    val noBtn = readLine().split(' ').toList()

    for (i in 0 .. 9) {
        if (!noBtn.contains(i.toString())) {
            btn.add(i.toString())
        }
    }

//    for (i in 1 .. btn.size) {
//        dubPermutation(i)
//    }

        for (i in 1..6) {
            dubPermutation(0, i)
        }

        var min = Math.abs(100 - n)

        can.forEach {
//        println(it)
            min = Math.min(min, Math.abs(n - it.toInt()) + it.toCharArray().size)
        }

        print(min)
    }

}

val pickednum = mutableListOf<String>()

fun dubPermutation(cnt : Int ,depth : Int) {
    if (cnt == depth) {
        var result = ""
        pickednum.forEach {
            result = result + it
        }

        can.add(result)
        return
    }

    for (index in 0 until btn.size) {
        pickednum.add(btn[index])
        dubPermutation(cnt + 1, depth)
        pickednum.removeAt(pickednum.lastIndex)
    }

}






