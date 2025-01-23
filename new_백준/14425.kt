import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


data class TrieNode(
    val childNode: MutableMap<Char, TrieNode> = mutableMapOf()
)

var result = 0

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val rootNode = TrieNode()

    repeat(n) {
        st = StringTokenizer(br.readLine())
        addNode(rootNode, st.nextToken().toString())
    }


    repeat(m) {
        st = StringTokenizer(br.readLine())
        val tmpStr = st.nextToken().toString()
        val node = getNode(rootNode, tmpStr)
        if(node != null) {
            if(node == TrieNode()) {
                result ++
            }


        }
    }

    bw.write(result.toString())

    bw.flush()
    bw.close()

}

fun addNode(rootNode: TrieNode, word: String) {
    var tmpNode = rootNode

    word.forEach { c ->
        val tmpChildNode = tmpNode.childNode[c]
        tmpNode = tmpChildNode ?: tmpNode.childNode.computeIfAbsent(c) { TrieNode() }

    }
}

fun getNode(rootNode: TrieNode, word: String): TrieNode? {
    var tmpNode = rootNode

    word.forEach { c ->
        val tmpChildNode = tmpNode.childNode[c] ?: return null
        tmpNode = tmpChildNode
    }

    return tmpNode
}

//
//fun dfs(cnt: Int, rootList: MutableList<Node?>, tmpList: List<Int>) {
//    if(cnt == tmpList.size) return
//
//    val curCharInt = tmpList[cnt]
//    if(rootList[curCharInt] == null) {
//        rootList[curCharInt] = Node(
//            curChar = curCharInt,
//            nextNode = MutableList<Node?>(26) { null }
//        )
//    }
//
//    dfs(cnt+1, rootList[curCharInt]?.nextNode!!, tmpList)
//}
//
//fun findNode(cnt: Int, rootList: MutableList<Node?>?, tmpList: List<Int>, tmpStr: String) {
//    if(cnt == tmpList.size) {
//
////        if(rootList?.count { it == null} == 26) {
////            result ++
////        }
//        result ++
//        return
//    }
//
//    if(rootList == null) return
//
//
//    val curCharInt = tmpList[cnt]
//    rootList?.let {
//        findNode(cnt+1, it[curCharInt]?.nextNode, tmpList, tmpStr)
//    }
//
//}


//fun main(): Unit = with(System.`in`.bufferedReader()) {
//    val (n, m) = readLine().split(" ").map { it.toInt() }
//    val hashSet = HashSet<String>()
//
//    repeat(n) {
//        hashSet.add(readLine())
//    }
//
//    var cnt = 0
//    repeat(m) {
//        val tmp = readLine()
//        if (hashSet.contains(tmp)) {
//            println(tmp)
//            cnt++
//        }
//    }
//
//    println(cnt)
//}
