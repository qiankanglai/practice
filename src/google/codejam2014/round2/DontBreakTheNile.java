package google.codejam2014.round2;

import java.io.*;

/**
 * Created by anthony on 5/31/14.
 */
import java.util.*;

 class Bag<Item> implements Iterable<Item> {
    private int N;               // number of elements in bag
    private Node<Item> first;    // beginning of bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;
        N = 0;
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


    /**
     * Returns an iterator that iterates over the items in the bag in arbitrary order.
     * @return an iterator that iterates over the items in the bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}

class FlowEdge {
    private final int v;             // from
    private final int w;             // to
    private final double capacity;   // capacity
    private double flow;             // flow

    /**
     * Initializes an edge from vertex <tt>v</tt> to vertex <tt>w</tt> with
     * the given <tt>capacity</tt> and zero flow.
     * @param v the tail vertex
     * @param w the head vertex
     * @param capacity the capacity of the edge
     * @throws java.lang.IndexOutOfBoundsException if either <tt>v</tt> or <tt>w</tt>
     *    is a negative integer
     * @throws java.lang.IllegalArgumentException if <tt>capacity</tt> is negative
     */
    public FlowEdge(int v, int w, double capacity) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (!(capacity >= 0.0)) throw new IllegalArgumentException("Edge capacity must be nonnegaitve");
        this.v         = v;
        this.w         = w;
        this.capacity  = capacity;
        this.flow      = 0.0;
    }

    /**
     * Initializes an edge from vertex <tt>v</tt> to vertex <tt>w</tt> with
     * the given <tt>capacity</tt> and <tt>flow</tt>.
     * @param v the tail vertex
     * @param w the head vertex
     * @param capacity the capacity of the edge
     * @param flow the flow on the edge
     * @throws java.lang.IndexOutOfBoundsException if either <tt>v</tt> or <tt>w</tt>
     *    is a negative integer
     * @throws java.lang.IllegalArgumentException if <tt>capacity</tt> is negative
     * @throws java.lang.IllegalArgumentException unless <tt>flow</tt> is between
     *    <tt>0.0</tt> and <tt>capacity</tt>.
     */
    public FlowEdge(int v, int w, double capacity, double flow) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (!(capacity >= 0.0))  throw new IllegalArgumentException("Edge capacity must be nonnegaitve");
        if (!(flow <= capacity)) throw new IllegalArgumentException("Flow exceeds capacity");
        if (!(flow >= 0.0))      throw new IllegalArgumentException("Flow must be nonnnegative");
        this.v         = v;
        this.w         = w;
        this.capacity  = capacity;
        this.flow      = flow;
    }

    /**
     * Initializes a flow edge from another flow edge.
     * @param e the edge to copy
     */
    public FlowEdge(FlowEdge e) {
        this.v         = e.v;
        this.w         = e.w;
        this.capacity  = e.capacity;
        this.flow      = e.flow;
    }

    /**
     * Returns the tail vertex of the edge.
     * @return the tail vertex of the edge
     */
    public int from() {
        return v;
    }

    /**
     * Returns the head vertex of the edge.
     * @return the head vertex of the edge
     */
    public int to() {
        return w;
    }

    /**
     * Returns the capacity of the edge.
     * @return the capacity of the edge
     */
    public double capacity() {
        return capacity;
    }

    /**
     * Returns the flow on the edge.
     * @return the flow on the edge
     */
    public double flow() {
        return flow;
    }

    /**
     * Returns the endpoint of the edge that is different from the given vertex
     * (unless the edge represents a self-loop in which case it returns the same vertex).
     * @param vertex one endpoint of the edge
     * @return the endpoint of the edge that is different from the given vertex
     *   (unless the edge represents a self-loop in which case it returns the same vertex)
     * @throws java.lang.IllegalArgumentException if <tt>vertex</tt> is not one of the endpoints
     *   of the edge
     */
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Returns the residual capacity of the edge in the direction
     *  to the given <tt>vertex</tt>.
     * @param vertex one endpoint of the edge
     * @return the residual capacity of the edge in the direction to the given vertex
     *   If <tt>vertex</tt> is the tail vertex, the residual capacity equals
     *   <tt>capacity() - flow()</tt>; if <tt>vertex</tt> is the head vertex, the
     *   residual capacity equals <tt>flow()</tt>.
     * @throws java.lang.IllegalArgumentException if <tt>vertex</tt> is not one of the endpoints
     *   of the edge
     */
    public double residualCapacityTo(int vertex) {
        if      (vertex == v) return flow;              // backward edge
        else if (vertex == w) return capacity - flow;   // forward edge
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Increases the flow on the edge in the direction to the given vertex.
     *   If <tt>vertex</tt> is the tail vertex, this increases the flow on the edge by <tt>delta</tt>;
     *   if <tt>vertex</tt> is the head vertex, this decreases the flow on the edge by <tt>delta</tt>.
     * @param vertex one endpoint of the edge
     * @throws java.lang.IllegalArgumentException if <tt>vertex</tt> is not one of the endpoints
     *   of the edge
     * @throws java.lang.IllegalArgumentException if <tt>delta</tt> makes the flow on
     *   on the edge either negative or larger than its capacity
     * @throws java.lang.IllegalArgumentException if <tt>delta</tt> is <tt>NaN</tt>
     */
    public void addResidualFlowTo(int vertex, double delta) {
        if      (vertex == v) flow -= delta;           // backward edge
        else if (vertex == w) flow += delta;           // forward edge
        else throw new IllegalArgumentException("Illegal endpoint");
        if (Double.isNaN(delta)) throw new IllegalArgumentException("Change in flow = NaN");
        if (!(flow >= 0.0))      throw new IllegalArgumentException("Flow is negative");
        if (!(flow <= capacity)) throw new IllegalArgumentException("Flow exceeds capacity");
    }


    /**
     * Returns a string representation of the edge.
     * @return a string representation of the edge
     */
    public String toString() {
        return v + "->" + w + " " + flow + "/" + capacity;
    }
}

class FlowNetwork {
    private int V;
    private int E;
    private Bag<FlowEdge>[] adj;

    /**
     * Initializes an empty flow network with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
     */
    public FlowNetwork(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<FlowEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<FlowEdge>();
    }

    /**
     * Returns the number of vertices in the edge-weighted graph.
     * @return the number of vertices in the edge-weighted graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the edge-weighted graph.
     * @return the number of edges in the edge-weighted graph
     */
    public int E() {
        return E;
    }

    /**
     * Adds the edge <tt>e</tt> to the network.
     * @param e the edge
     * @throws java.lang.IndexOutOfBoundsException unless endpoints of edge are between 0 and V-1
     */
    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * Returns the edges incident on vertex <tt>v</tt> (includes both edges pointing to
     * and from <tt>v</tt>).
     * @return the edges incident on vertex <tt>v</tt> as an Iterable
     * @param v the vertex
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<FlowEdge> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        return adj[v];
    }

    // return list of all edges - excludes self loops
    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> list = new Bag<FlowEdge>();
        for (int v = 0; v < V; v++)
            for (FlowEdge e : adj(v)) {
                if (e.to() != v)
                    list.add(e);
            }
        return list;
    }


    /**
     * Returns a string representation of the flow network.
     * This method takes time proportional to <em>E</em> + <em>V</em>.
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *    followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ":  ");
            for (FlowEdge e : adj[v]) {
                if (e.to() != v) s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
class FordFulkerson {
    private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private FlowEdge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private double value;         // current value of max flow

    /**
     * Compute a maximum flow and minimum cut in the network <tt>G</tt>
     * from vertex <tt>s</tt> to vertex <tt>t</tt>.
     * @param G the flow network
     * @param s the source vertex
     * @param t the sink vertex
     * @throws IndexOutOfBoundsException unless 0 <= s < V
     * @throws IndexOutOfBoundsException unless 0 <= t < V
     * @throws IllegalArgumentException if s = t
     * @throws IllegalArgumentException if initial flow is infeasible
     */
    public FordFulkerson(FlowNetwork G, int s, int t) {
        if (s < 0 || s >= G.V()) {
            throw new IndexOutOfBoundsException("Source s is invalid: " + s);
        }
        if (t < 0 || t >= G.V()) {
            throw new IndexOutOfBoundsException("Sink t is invalid: " + t);
        }
        if (s == t) {
            throw new IllegalArgumentException("Source equals sink");
        }
        value = excess(G, t);
        if (!isFeasible(G, s, t)) {
            throw new IllegalArgumentException("Initial flow is infeasible");
        }

        // while there exists an augmenting path, use it
        while (hasAugmentingPath(G, s, t)) {

            // compute bottleneck capacity
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            // augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }

        // check optimality conditions
        assert check(G, s, t);
    }

    /**
     * Returns the value of the maximum flow.
     * @return the value of the maximum flow
     */
    public double value()  {
        return value;
    }

    // is v in the s side of the min s-t cut?
    /**
     * Is vertex <tt>v</tt> on the <tt>s</tt> side of the minimum st-cut?
     * @return <tt>true</tt> if vertex <tt>v</tt> is on the <tt>s</tt> side of the micut,
     *    and <tt>false</tt> if vertex <tt>v</tt> is on the <tt>t</tt> side.
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public boolean inCut(int v)  {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        return marked[v];
    }


    // is there an augmenting path?
    // if so, upon termination edgeTo[] will contain a parent-link representation of such a path
    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        // breadth-first search
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.remove();

            for (FlowEdge e : G.adj(v)) {
                int w = e.other(v);

                // if residual capacity from v to w
                if (e.residualCapacityTo(w) > 0) {
                    if (!marked[w]) {
                        edgeTo[w] = e;
                        marked[w] = true;
                        q.add(w);
                    }
                }
            }
        }

        // is there an augmenting path?
        return marked[t];
    }



    // return excess flow at vertex v
    private double excess(FlowNetwork G, int v) {
        double excess = 0.0;
        for (FlowEdge e : G.adj(v)) {
            if (v == e.from()) excess -= e.flow();
            else               excess += e.flow();
        }
        return excess;
    }

    // return excess flow at vertex v
    private boolean isFeasible(FlowNetwork G, int s, int t) {
        double EPSILON = 1E-11;

        // check that capacity constraints are satisfied
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if (e.flow() < -EPSILON || e.flow() > e.capacity() + EPSILON) {
                    System.err.println("Edge does not satisfy capacity constraints: " + e);
                    return false;
                }
            }
        }

        // check that net flow into a vertex equals zero, except at source and sink
        if (Math.abs(value + excess(G, s)) > EPSILON) {
            System.err.println("Excess at source = " + excess(G, s));
            System.err.println("Max flow         = " + value);
            return false;
        }
        if (Math.abs(value - excess(G, t)) > EPSILON) {
            System.err.println("Excess at sink   = " + excess(G, t));
            System.err.println("Max flow         = " + value);
            return false;
        }
        for (int v = 0; v < G.V(); v++) {
            if (v == s || v == t) continue;
            else if (Math.abs(excess(G, v)) > EPSILON) {
                System.err.println("Net flow out of " + v + " doesn't equal zero");
                return false;
            }
        }
        return true;
    }



    // check optimality conditions
    private boolean check(FlowNetwork G, int s, int t) {

        // check that flow is feasible
        if (!isFeasible(G, s, t)) {
            System.err.println("Flow is infeasible");
            return false;
        }

        // check that s is on the source side of min cut and that t is not on source side
        if (!inCut(s)) {
            System.err.println("source " + s + " is not on source side of min cut");
            return false;
        }
        if (inCut(t)) {
            System.err.println("sink " + t + " is on source side of min cut");
            return false;
        }

        // check that value of min cut = value of max flow
        double mincutValue = 0.0;
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if ((v == e.from()) && inCut(e.from()) && !inCut(e.to()))
                    mincutValue += e.capacity();
            }
        }

        double EPSILON = 1E-11;
        if (Math.abs(mincutValue - value) > EPSILON) {
            System.err.println("Max flow value = " + value + ", min cut value = " + mincutValue);
            return false;
        }

        return true;
    }

}


public class DontBreakTheNile {

    public static int toIdx(int x, int y, int W, int H){
        return y*W+x;
    }
    public static int toX(int idx, int W, int H){
        return idx%W;
    }
    public static int toY(int idx, int W, int H){
        return idx/W;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round2/C-large.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round2/C-large.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);

            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int W = Integer.parseInt(temp2[0]);
            int H = Integer.parseInt(temp2[1]);
            int B = Integer.parseInt(temp2[2]);

            boolean isBuilding[] = new boolean[W*H];
            Arrays.fill(isBuilding, false);
            for(int i = 0; i < B; i++) {
                temp = reader.readLine();
                temp2 = temp.split(" ");
                int x0 = Integer.parseInt(temp2[0]);
                int y0 = Integer.parseInt(temp2[1]);
                int x1 = Integer.parseInt(temp2[2]);
                int y1 = Integer.parseInt(temp2[3]);
                for(int x = x0; x <= x1; x++)
                    for(int y = y0; y <= y1; y++)
                        isBuilding[toIdx(x,y,W,H)] = true;
            }

            int count = W*H*2;
            int src=count, dst=count+1;

            FlowNetwork f = new FlowNetwork(count+2);
            for(int i = 0; i < W*H; i++){
                if(!isBuilding[i])
                    f.addEdge(new FlowEdge(2*i, 2*i+1, 1));//node
            }
            int x = 0, y = 0;
            for(x = 0; x < W; x++){
                int idx1 = toIdx(x,y,W,H);
                if(!isBuilding[idx1])
                    f.addEdge(new FlowEdge(src, 2*idx1, 100000));
            }
            y = H-1;
            for(x = 0; x < W; x++){
                int idx1 = toIdx(x,y,W,H);
                if(!isBuilding[idx1])
                    f.addEdge(new FlowEdge(2*idx1+1, dst, 100000));
            }
            for(x = 0; x < W; x++) {
                for (y = 0; y < H; y++) {
                    int idx1 = toIdx(x,y,W,H);
                    if(isBuilding[idx1])
                        continue;
                    if(x+1 < W){
                        int idx2 = toIdx(x+1,y,W,H);
                        if(!isBuilding[idx2]){
                            f.addEdge(new FlowEdge(2*idx1+1, 2*idx2, 1));
                            f.addEdge(new FlowEdge(2*idx2+1, 2*idx1, 1));
                        }
                    }
                    if(y+1 < H){
                        int idx2 = toIdx(x,y+1,W,H);
                        if(!isBuilding[idx2]){
                            f.addEdge(new FlowEdge(2*idx1+1, 2*idx2, 1));
                            f.addEdge(new FlowEdge(2*idx2+1, 2*idx1, 1));
                        }
                    }
                }
            }



            FordFulkerson maxflow = new FordFulkerson(f, src, dst);
            int v = (int)maxflow.value();

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write("" + v);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
