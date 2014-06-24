package CCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Anthony on 2014/6/23.
 */
public class Chapter11 {
    //11.1
    public void merge(int []a, int []b, int lengthA, int lengthB){
        int ptrA = lengthA - 1, ptrB = lengthB - 1, ptr = lengthA + lengthA - 1;
        while(ptrA >= 0 && ptrB >= 0){
            if(a[ptrA] > b[ptrB]){
                a[ptr] = a[ptrA];
                ptrA--;
            }
            else{
                b[ptr] = b[ptrB];
                ptrB--;
            }
            ptr--;
        }
        while(ptrB >= 0){
            a[ptr] = b[ptrB];
            ptrB--;
            ptr--;
        }
    }

    //11.2
    public void sort(String arr[]){
        HashMap<String, ArrayList<String>> cache = new HashMap<String, ArrayList<String>>();
        for(String s: arr){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!cache.containsKey(key))
                cache.put(key, new ArrayList<String>());
            cache.get(key).add(s);
        }
        int ptr = 0;
        for(String key : cache.keySet()){
            ArrayList<String> list = cache.get(key);
            for(String s: list){
                arr[ptr] = s;
                ptr++;
            }
        }
    }

    //11.3
    public int search(int arr[], int target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target)
                return mid;
            if(arr[low] < arr[mid]){
                if(target >= arr[low] && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(arr[mid] < arr[high]){
                if(target >= arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else
                low++;
        }
        return -1;
    }

    //11.4 外部排序，k路归并
    public int search(String arr[], String target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            while(arr[low].equals(""))
                low ++;
            while(arr[high].equals(""))
                high --;
            int mid = (low+high) / 2;
            while(arr[mid].equals(""))
                mid ++;
            if(arr[mid].equals(target))
                return mid;
            else if(arr[mid].compareTo(target) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    //11.5
    public boolean findElement(int matrix[][], int target){
        int row = matrix.length, col = matrix[0].length;
        int y = 0, x = col - 1;
        while (x >= 0 && y < row){
            if(matrix[y][x] == target)
                return true;
            else if(matrix[y][x] > target)
                x--;
            else
                y++;
        }
        return false;
    }

    //11.6
    class LuoHan{
        public int height, weight;
    }
    public int increasingSequence(LuoHan []men){
        for(int i = 0; i < men.length; i++){
            for(int j = 0; j + i + 1 < men.length; j++){
                if((men[j].height > men[j+1].height) || (men[j].height == men[j].height && men[j].weight > men[j].weight)){
                    LuoHan t = men[j];
                    men[j] = men[j+1];
                    men[j+1] = t;
                }
            }
        }
        int counts[] = new int[men.length];
        Arrays.fill(counts, 0);
        int max = 0;
        for(int i = 0; i < men.length; i++){
            int m = 1;
            for(int j = 0; j < i; j++){
                if(men[j].height < men[i].height && men[j].weight < men[i].weight){
                    int t = counts[j]+1;
                    if(t > m)
                        m = t;
                }
            }
            counts[i] = m;
            if(m > max)
                max = m;
        }
        return max;
    }
    //11.7 其实感觉是线段树
    class RankNode{
        RankNode left, right;
        int value, left_children, count;
        public RankNode(int v){
            value = v;
            left_children = 0;
            count = 1;
            left = null;
            right = null;
        }
    }
    RankNode root = null;
    public int getRank(int x){
        if(root == null)
            return -1;
        int s = 0;
        RankNode p = root;
        while(p != null){
            if(p.value == x)
                //<=x的数，但要扣掉自己
                return s + p.left_children + p.count - 1;
            else if(p.value > x)
                p = p.left;
            else{
                s += p.left_children + p.count;
                p = p.right;
            }
        }
        return -1;
    }

    public void track(int x){
        if(root == null){
            root = new RankNode(x);
            return;
        }
        RankNode p = root;
        while(p != null) {
            if (p.value == x) {
                p.count ++;
                return;
            }
            if (p.value < x) {
                if(p.right != null)
                    p = p.right;
                else {
                    p.right = new RankNode(x);
                    return;
                }
            }
            else{
                p.left_children++;
                if(p.left != null)
                    p = p.left;
                else {
                    p.left = new RankNode(x);
                    return;
                }
            }
        }
    }

    public static void main(String args[]){
        //System.out.println(new Chapter11().search(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
        Chapter11 chap = new Chapter11();
        chap.track(5);
        chap.track(1);
        chap.track(4);
        chap.track(4);
        chap.track(5);
        chap.track(9);
        chap.track(7);
        chap.track(13);
        chap.track(3);
        System.out.println(chap.getRank(1));
        System.out.println(chap.getRank(3));
        System.out.println(chap.getRank(4));
    }

}
