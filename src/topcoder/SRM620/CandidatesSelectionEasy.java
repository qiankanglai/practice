package topcoder.SRM620;

/**
 * Created by anthony on 5/11/14.
 */
public class CandidatesSelectionEasy {
    public int[] sort(String []score, int x){
        int []idx = new int[score.length];
        for(int i = 0; i < score.length; i++)
            idx[i] = i;
        for(int i = score.length-1; i>=0; i--)
            for(int j = 0; j < i; j++){
                if(score[idx[j]].charAt(x) > score[idx[j+1]].charAt(x)){
                    int a = idx[j];
                    idx[j] = idx[j+1];
                    idx[j+1] = a;
                }
            }
        return idx;
    }

    public static void main(String args[]){
        new CandidatesSelectionEasy().sort(new String[]{"ACB", "AAC", "CBA"}, 0);
        //new CandidatesSelectionEasy().sort(new String[]{"A", "C", "B", "C", "A"}, 0);
        //new CandidatesSelectionEasy().sort(new String[]{"LAX", "BUR", "ONT", "LGB", "SAN", "SNA", "SFO", "OAK", "SJC"}, 2);
    }
}
