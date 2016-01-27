package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class Kata {
    public static int TripleDouble(long num1, long num2)
    {
        boolean []flag1 = new boolean[10];
        boolean []flag2 = new boolean[10];
        if(num1 > 99)
        {
            long x = 0;
            long y = num1%10;num1 /=10;
            long z = num1%10;num1 /=10;
            do{
                x=y;y=z;
                z = num1%10;num1 /=10;
                if(x==y&&y==z)
                {
                    flag1[(int)x] = true;
                }
            }while (num1>0);
        }
        if(num2 > 9)
        {
            long x = 0;
            long y = num2%10;num2 /=10;
            do{
                x=y;
                y = num2%10;num2 /=10;
                if(x==y)
                {
                    flag2[(int)x] = true;
                }
            }while (num2>0);
        }
        for(int i = 0; i < 10; i++)
        {
            if(flag1[i] && flag2[i]) return 1;
        }
        return 0;
    }
}
