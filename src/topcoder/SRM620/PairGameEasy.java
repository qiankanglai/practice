package topcoder.SRM620;

/**
 * Created by anthony on 5/11/14.
 */
public class PairGameEasy {
    public boolean test2(int a, int b, int c, int d){
        if(a>c || b>d)
            return false;
        if(a==c&&b==d)
            return true;
        return test2(a + b, b, c, d)||test2(a, a + b, c, d);
    }
    public boolean test(int a, int b, int c, int d){
        if(a>c || b>d)
            return false;
        if(a==c&&b==d)
            return true;
        if(c<d)
            return test(a, b, c, d-c);
        else
            return test(a, b, c-d, d);
    }
    public String able(int a, int b, int c, int d){
        if(test2(a, b, c, d))
            return "Able to generate";
        else
            return "Not able to generate";
    }
    public static void main(String args[]){
        long a = System.currentTimeMillis();
        /*System.out.println(new PairGameEasy().test2(1,2,3,5));
        System.out.println(new PairGameEasy().test2(1,2,2,1));
        System.out.println(new PairGameEasy().test2(2,2,2,999));
        System.out.println(new PairGameEasy().test2(2,2,2,1000));
        System.out.println(new PairGameEasy().test2(47,58,384,221));   */
        System.out.println(new PairGameEasy().test2(1,1,999,1000));
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }
}
