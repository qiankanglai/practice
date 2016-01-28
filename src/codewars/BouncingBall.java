package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if(bounce <= 0 || h <= 0 || window <= 0) return -1;
        if(bounce >= 1 || h <= window) return -1;
        double k = Math.log(window/h)/Math.log(bounce);
        return (int)Math.floor(k)*2+1;
    }
}
