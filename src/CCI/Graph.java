package CCI;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/16.
 */
public class Graph {
    ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
}

class GraphNode{
    ArrayList<GraphNode> adjacent = new ArrayList<GraphNode>();
    int val = -1;
}
