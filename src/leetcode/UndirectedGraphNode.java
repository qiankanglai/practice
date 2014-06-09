package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 6/10/14.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
