import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    HashMap<Integer, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return cloneNeighbor(node);
    }

    public Node cloneNeighbor(Node node) {
        if(node == null) return node;
        if (map.containsKey(node.val))
            return map.get(node.val);
        map.put(node.val, new Node(node.val));
        for (Node n : node.neighbors) {
            map.get(node.val).neighbors.add(cloneNeighbor(n));
        }
        return map.get(node.val);
    }

}



/*
 * https://leetcode.com/problems/clone-graph/description/
 */