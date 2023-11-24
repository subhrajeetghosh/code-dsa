package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * @author subhrajeetghosh
 */

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) { // Bruteforce approch time complexity O(n)^n
        if (n < 1)
            return new ArrayList<>();
        return generateTrees_2ndMethod(1, n);
        // return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = generateTrees(start, i - 1);
            List<TreeNode> rightSubTree = generateTrees(i + 1, end);

            for (TreeNode rightNode : rightSubTree) {
                for (TreeNode leftNode : leftSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }

    /*
     * dynamic programming approch
     * time complexity - O(4^n/√n)
     */

    Map<String, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> generateTrees_2ndMethod(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (map.containsKey(start + " " + end)) {
            return map.get(start + " " + end);
        }
        if (start > end) {
            treeNodes.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = generateTrees_2ndMethod(start, i - 1);
            List<TreeNode> rightSubTree = generateTrees_2ndMethod(i + 1, end);

            for (TreeNode rightNode : rightSubTree) {
                for (TreeNode leftNode : leftSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    treeNodes.add(root);
                }
            }
        }
        map.put(start + " " + end, treeNodes);
        return map.get(start + " " + end);
    }

}