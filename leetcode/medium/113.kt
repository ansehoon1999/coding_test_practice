
class Solution {
    var visited = arrayOfNulls<Node?>(10000);
    private fun dfs(neighbors: ArrayList<Node?>): ArrayList<Node?>{
        var newNeighbors = ArrayList<Node?>();
        for(node in neighbors){
            if(visited[node!!.`val`]!=null){
                newNeighbors.add(visited[node!!.`val`]);
            }
            else{
                var newNode = Node(node!!.`val`);
                visited[newNode!!.`val`] = newNode;
                newNode.neighbors = dfs(node.neighbors);
                newNeighbors.add(newNode);
            }
        }
        return newNeighbors;
    }
    fun cloneGraph(node: Node?): Node? {
        if(node==null)
            return null;
        var newNode = Node(node!!.`val`);
        visited[newNode!!.`val`] = newNode;
        newNode.neighbors = dfs(node!!.neighbors);
        return newNode;
    }
}