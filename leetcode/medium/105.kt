// /**
//  * Example:
//  * var ti = TreeNode(5)
//  * var v = ti.`val`
//  * Definition for a binary tree node.
//  * class TreeNode(var `val`: Int) {
//  *     var left: TreeNode? = null
//  *     var right: TreeNode? = null
//  * }
//  */
class Solution {
    fun buildTree(
        preorder: IntArray, inorder: IntArray,
        preLeft: Int = 0, preRight: Int = preorder.size-1,
        inLeft: Int = 0, inRight: Int = inorder.size-1
    ): TreeNode? {
        if (preRight < preLeft || inRight < inLeft) return null

        val node = TreeNode(preorder[preLeft])

        val nodeInOrderIndex = inorder.indexOf(node.`val`)

        // println("${preLeft+1} ${preLeft+nodeInOrderIndex-inLeft} | ${inLeft} ${nodeInOrderIndex-1}")
        // println("${preLeft+nodeInOrderIndex+1} ${preRight} | ${nodeInOrderIndex+1} ${inRight}")
        // println()
        node.left = buildTree(
            preorder, inorder,
            preLeft+1, preLeft+nodeInOrderIndex-inLeft,
            inLeft, nodeInOrderIndex-1
        )

        node.right = buildTree(
            preorder, inorder,
            preLeft+nodeInOrderIndex-inLeft+1, preRight,
            nodeInOrderIndex+1, inRight        
        )
        
        return node
    }
}


// class Solution {
//     fun buildTree(
//         preorder: IntArray, inorder: IntArray,
//         preLeft: Int = 0, preRight: Int = preorder.size-1,
//         inLeft: Int = 0, inRight: Int = inorder.size-1
//     ): TreeNode? {
//         if(inRight<inLeft || preRight<preLeft) return null;
        
//         val node = TreeNode(preorder[preLeft])
        
//         var nodeIndexInInOrder = inLeft
//         while(node.`val` != inorder[nodeIndexInInOrder]) {
//             nodeIndexInInOrder++
//         }
        
//         val sizeOfLeftInOrder = nodeIndexInInOrder-inLeft
        
//         println("${preLeft+1} ${preLeft+sizeOfLeftInOrder} | ${inLeft} ${nodeIndexInInOrder-1}")
//         println("${preLeft+sizeOfLeftInOrder+1} ${preRight} | ${nodeIndexInInOrder+1} ${inRight}")
//         println()

//         node.left = buildTree(
//             preorder,inorder,
//             preLeft+1,preLeft+sizeOfLeftInOrder,
//             inLeft,nodeIndexInInOrder-1
//         )
//         node.right = buildTree(
//             preorder,inorder,
//             preLeft+sizeOfLeftInOrder+1,preRight,
//             nodeIndexInInOrder+1,inRight
//         )
        
//         return node
//     }
// }
