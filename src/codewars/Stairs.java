package codewars;

/**
 * Created by qiank on 1/28/2016.
 */
public class Stairs {
    public static int NumberOfSteps(int n, int m)
    {
        if(n<=0)
        {
            return -1;
        }
        else if(n==1)
        {
            return (m==1)?1:-1;
        }
        else if(n==2)
        {
            if(m==1) return 1;
            if(m==2) return 2;
            return -1;
        }
        if(m < 1) return -1;
        int []setA = new int[m];
        int []setB = new int[m];
        int []setC = new int[m];

        setA[1%m] = 1;
        setB[2%m] = 2;
        setB[1%m] = 1;

        for(int k=3; k<= n; k++)
        {
            for(int i=0;i<m;i++) setC[i] = 0;
            for(int i=0;i<m;i++){
                if(setA[i] > 0){
                    int t = (setA[i]+1)%m;
                    if(setC[t] == 0 || setC[t] > setA[i]+1) setC[t] = setA[i]+1;
                }
            }
            for(int i=0;i<m;i++){
                if(setB[i] > 0){
                    int t = (setB[i]+1)%m;
                    if(setC[t] == 0 || setC[t] > setB[i]+1) setC[t] = setB[i]+1;
                }
            }
            int []tmp = setA;
            setA = setB;
            setB = setC;
            setC = tmp;
        }
        return setB[0]==0?-1:setB[0];
    }

    public static void main(String args[])
    {
        System.out.println(new Stairs().NumberOfSteps(3, 5));
    }
}
