package CCI;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/16.
 */
public class Chapter5 {
    public static void main(String args[]){
        //System.out.println(Integer.toBinaryString(new Chapter5().updateBits(Integer.parseInt("10011", 2), Integer.parseInt("10000000000", 2), 2, 6)));
        //System.out.println(Integer.toBinaryString(new Chapter5().getPrev(Integer.parseInt("101011", 2))));
        //System.out.println(new Chapter5().bitSwapRequired2(31, 14));
        //System.out.println(new Chapter5().swapOddEvenBits(31));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(5);
        System.out.println(new Chapter5().findMissing(arr));
    }

    //5.1
    public int updateBits(int M, int N, int i, int j){
        M = M << i;
        int mask = (1 << i - 1) ^ (1 << j - 1);
        N = N & ~mask;
        return N | M;
    }

    //5.2
    public String generateBinary(double x){
        if(x < 0 || x > 1)
            return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        int count = 0;
        while(x != 0){
            double x2 = x * 2;
            sb.append((x2 >= 1)?'1':'0');
            x = (x2 >= 1)?(x2-1):x2;
            count++;
            if(count >= 32)
                break;
        }
        if(count >= 32)
            return "ERROR";
        else{
            return sb.toString();
        }
    }

    //5.3
    //我做的是位操作法~看下算数法
    public int getPrev(int x){
        if(x == 0) return 0;
        int x2 = x;
        int lowestOne = 0;
        while(x2 % 2 == 1){
            lowestOne ++;
            x2 /= 2;
        }
        int lowestZero2 = lowestOne;
        while(x2 % 2 == 0){
            lowestZero2 ++;
            x2 /= 2;
        }
        x = x & ~(1 << lowestZero2);
        x = x | ((1 << lowestZero2) - 1);
        x = x & ~((1 << (lowestZero2 - lowestOne - 1)) - 1);
        return x;
    }
    public int getNext(int x){
        if(x == 0) return 0;
        int x2 = x;
        int lowestOne = 0;
        while(x2 % 2 == 0){
            lowestOne ++;
            x2 /= 2;
        }
        int lowestZero2 = lowestOne;
        while(x2 % 2 == 1){
            lowestZero2 ++;
            x2 /= 2;
        }
        x = x | (1 << lowestZero2);
        x = x & ~((1 << lowestZero2) - 1);
        int leftOnes = lowestZero2 - lowestOne - 1;
        x = x | ((1 << leftOnes) - 1);
        return x;
    }

    //5.4: n的二进制表示中只有一个1, 也就是2^x

    //5.5
    public int bitSwapRequired(int x, int y){
        int count = 0;
        while(x != 0 || y != 0){
            if(x % 2 != y % 2)
                count++;
            x /= 2;
            y /= 2;
        }
        return count;
    }
    public int bitSwapRequired2(int x, int y) {
    //看了答案~精巧的计算t里有几个1
        int t = x ^ y;
        int count = 0;
        while(t != 0){
            t = t & (t-1);
            count++;
        }
        return count;
    }

    //5.6
    public int swapOddEvenBits(int x){
        int mask = 0;
        for(int i = 0; i < 16; i++){
            mask = (mask << 2) + 1;
        }
        int x2 = (x & mask) << 1 | (x & ~mask) >> 1;
        return x2;
    }

    //5.7
    //看了答案，理解上应该是0-n中一个数没出现，其他都出现一次
    //一开始误解答案了-.-
    public int findMissing(ArrayList<Integer> A, int j){
        if(j > 31)
            return 0;

        ArrayList<Integer> ones = new ArrayList<Integer>();
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        for(int i = 0; i < A.size(); i++){
                int bit = A.get(i) & (1 << j);
                if(bit > 0)
                    ones.add(A.get(i));
                else
                    zeros.add(A.get(i));
            }
        if(zeros.size() <= ones.size()){
            return (findMissing(zeros, j+1) << 1) | 0;
        }
        else
            return (findMissing(ones, j+1) << 1) | 1;
    }

    public int findMissing(ArrayList<Integer> A){
        return findMissing(A, 0);
    }

    //5.9
    //没仔细检查我自己写的代码
    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
        int offset = y * width / 8;
        if(x1 / 8 == x2 / 8){
            offset += (x1 / 8);
            int mask = (1 << (8 - x1%8)) - 1;
            mask &= ~((1 << (8 - x2%8)) - 1);
            screen[offset] |= mask;
        }
        else{
            offset += (x1 / 8);
            int mask = (1 << (8 - x1%8)) - 1;
            screen[offset] |= mask;
            int count = (x2/8) - (x1/8) - 1;
            for(int i = 0; i < count; i++){
                offset++;
                screen[offset] = (byte) 255;
            }
            offset++;
            mask = (~0) << (8 - x2%8);
            screen[offset] |= mask;
        }
    }
}
