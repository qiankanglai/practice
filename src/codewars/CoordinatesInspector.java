package codewars;
import java.awt.geom.Point2D;

/**
 * Created by qiank on 1/28/2016.
 */
public class CoordinatesInspector {
    public Point2D coordinates(Double degrees, Double radius) {
        double x = radius*Math.cos(Math.toRadians(degrees));
        double y = radius*Math.sin(Math.toRadians(degrees));
        x = Math.round(x*1e10)/1e10;
        y = Math.round(y*1e10)/1e10;
        return new Point2D.Double(x, y);
    }

    public static void main(String args[])
    {
        Point2D p = new CoordinatesInspector().coordinates(90.0, 1.0);
        System.out.println(p.toString());
    }
}
