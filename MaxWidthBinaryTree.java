import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import CommonFile.TreeNode;

public class MaxWidthBinaryTree {

    Map<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int index, int depth) {
        if (node == null) {
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) + 1,
                Math.max(dfs(node.left, index * 2, depth + 1), dfs(node.right, index * 2 + 1, depth + 1)));
    }

    //Implement in BFS
    public int widthOfBinaryTreeBfs(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> node = new LinkedList<>();
        node.add(root);
        int depth = 1;
        int index = 1;
        int diff = 0;
        while(!node.isEmpty()) {
            TreeNode currentNode = node.poll();
            if(currentNode.left != null) {
                
            }
        }
        return 0;
    }
}
