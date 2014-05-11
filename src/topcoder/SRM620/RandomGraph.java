package topcoder.SRM620;

/**
 * Created by anthony on 5/11/14.
 */
public class RandomGraph {
    public double probability2(int n, int p){
        if(p <= 0) return 1;
        if(n <= 3) return 1;
        if(prob_cache[n] >= 0) return prob_cache[n];

        double _p = p/1000.0;

        double prob = 0;
        prob += Math.pow(1-_p, n-1)*probability2(n-1,p);
        prob += Math.pow(1-_p, n-2)*_p*(n-1)*(Math.pow(1-_p,2*(n-3))*_p*(n-2)*probability2(n-3,p)+Math.pow(1-_p,n-2)*probability2(n-2,p));
        prob += Math.pow(1-_p, 3*(n-3))*_p*_p*(n-1)*(n-2)/2*probability2(n-3,p);

        prob_cache[n]=prob;
        return prob;
    }
    double []prob_cache;
    public double probability(int n, int p){
        if(n <= 3) return 0;

        prob_cache = new double[n+1];
        for(int i=0;i<=n;i++)
            prob_cache[i] = -1;

        return 1-probability2(n,p);
    }


    public static void main(String args[]){
        System.out.println(new RandomGraph().probability(33,33));
        System.out.println(new RandomGraph().probability(3,620));
        System.out.println(new RandomGraph().probability(4,500));
        System.out.println(new RandomGraph().probability(8,100));
        System.out.println(new RandomGraph().probability(15,50));
        System.out.println(new RandomGraph().probability(50,10));
        System.out.println(new RandomGraph().probability(50,1000));
    }
}
