package library;

/**
 * Created by anthony on 7/13/14.
 */
public class BitIndexTree {
    int MaxVal = 0;
    int tree[] = null;
    public BitIndexTree(int MaxVal){
        assert (MaxVal > 0);
        this.MaxVal = MaxVal;
        tree = new int[MaxVal + 1];
    }

    public void update(int idx, int val){
        assert (idx > 0);
        while(idx <= MaxVal){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }

    public int read(int idx){
        int sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public static void main(String args[]){
        BitIndexTree tree = new BitIndexTree(16);
        tree.update(1, 1);
        tree.update(3, 2);
        tree.update(4, 1);
        tree.update(5, 1);
        tree.update(6, 3);
        tree.update(8, 4);
        tree.update(9, 2);
        tree.update(10, 5);
        tree.update(11, 2);
        tree.update(12, 2);
        tree.update(13, 3);
        tree.update(14, 1);
        tree.update(16, 2);

        System.out.println(tree.read(6));   //8
        System.out.println(tree.read(12));   //23
        System.out.println(tree.read(16));   //29
    }
}
