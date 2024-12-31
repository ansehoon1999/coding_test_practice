import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (s, p) = readln().split(" ").map { it.toInt() }
    val dnaList = readln().toList().map { it.toString() }

    val (needA, needC, needG, needT) = readln().split(" ").map { it.toInt() }

    val dnaHashMap = hashMapOf<String, Long>(
        "A" to 0,
        "C" to 0,
        "G" to 0,
        "T" to 0
    )

    var result = 0


    for (idx in 0 until p) {
        val curDna = dnaList[idx]

        if (dnaHashMap[curDna] == null) {
            dnaHashMap[curDna] = 1
        } else {
            dnaHashMap[curDna] = dnaHashMap[curDna]!! + 1
        }
    }

    if (
        needA <= dnaHashMap["A"]!!
        && needC <= dnaHashMap["C"]!!
        && needG <= dnaHashMap["G"]!!
        && needT <= dnaHashMap["T"]!!
        && p.toLong() == (dnaHashMap["A"]!! + dnaHashMap["C"]!! + dnaHashMap["G"]!! + dnaHashMap["T"]!!)
    ) {
        result += 1
    }

    for (idx in 1 .. s - p) {
        val deletedDna =  dnaList[idx-1]
        dnaHashMap[deletedDna] = dnaHashMap[deletedDna]!! - 1

        val addedDna = dnaList[idx - 1 + p]
        dnaHashMap[addedDna] = dnaHashMap[addedDna]!! + 1

        if (
            needA <= dnaHashMap["A"]!!
            && needC <= dnaHashMap["C"]!!
            && needG <= dnaHashMap["G"]!!
            && needT <= dnaHashMap["T"]!!
            && p.toLong() == (dnaHashMap["A"]!! + dnaHashMap["C"]!! + dnaHashMap["G"]!! + dnaHashMap["T"]!!)
        ) {
            result += 1
        }
    }

    println(result)

}
