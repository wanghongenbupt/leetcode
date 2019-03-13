package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_133 {

    /*
    * 133. Clone Graph
    * bfs克隆全部节点，之后填每个节点邻居
     * */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        List<Node> list = new ArrayList<>();
        Map<Node, Node> map = new HashMap<>();
        Node n = new Node(); n.val = node.val;
        map.put(node, n);
        list.add(node);
        int i = 0;
        while (i < list.size()) {
            Node cur = list.get(i);
            for (Node next : cur.neighbors) {
                if (!map.containsKey(next)) {
                    Node nn = new Node();
                    nn.val = next.val;
                    map.put(next, nn);
                    list.add(next);
                }
            }
            i++;
        }
        for (Node cur : list) {
            Node next = map.get(cur);
            if (cur.neighbors == null) continue;
            next.neighbors = new ArrayList<>();
            for (Node nn : cur.neighbors) {
                next.neighbors.add(map.get(nn));
            }
        }
        return n;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};