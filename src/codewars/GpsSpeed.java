package codewars;

/**
 * Created by qiank on 1/27/2016.
 */
public class GpsSpeed {
    public static int gps(int s, double[] x) {
        int speed = 0;
        for(int i = 0; i+1 < x.length; i++)
        {
            double t = (x[i+1]-x[i])*3600/s;    // FUCKING ANNOYING: *s/3600 is wrong
            int t2 = (int)Math.floor(t);
            if(t2>speed) speed = t2;
        }
        return speed;
    }
    public static void main(String args[]){
        double []x = new double[] {0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84};
        System.out.println(gps(20, x));
    }
}
