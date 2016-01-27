package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class Ghostbusters {
    public static String ghostBusters(String building) {
        return building.contains(" ")?building.replaceAll(" ", ""):"You just wanted my autograph didn't you?";
    }
}
