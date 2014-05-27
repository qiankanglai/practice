package leetcode;

/**
 * Created by Anthony on 2014/5/27.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(nRows <= 1) return s;

        StringBuilder sbs[] = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++)
            sbs[i] = new StringBuilder();

        boolean flag = true;
        int row = 0;
        for(int i = 0; i < s.length(); i++){
            sbs[row].append(s.charAt(i));
            if(flag){
                if(row >=nRows-1){
                    flag = false;
                    row = (row+nRows-1) % nRows;
                }
                else
                    row++;
            }
            else{
                if(row <= 0){
                    flag = true;
                    row = 1;
                }
                else
                    row--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nRows; i++)
            sb.append(sbs[i].toString());
        return sb.toString();
    }
    public static void main(String args[]){
        System.out.println(new ZigZagConversion().convert("ABCD", 2));
    }
}
