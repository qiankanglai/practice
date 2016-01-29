package codewars;
import java.util.*;

/**
 * Created by Anthony on 1/29/2016.
 */
public class Tour {
    private static String find(String name, String[][] ftwns) {
        for (int i = 0; i < ftwns.length; i++) {
            if (name.equals(ftwns[i][0])) {
                return ftwns[i][1];
            }
        }
        return null;
    }

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        String lastTown = null;
        double sum = 0;
        for (int i = 0; i < arrFriends.length; i++) {
            String town = find(arrFriends[i], ftwns);
            if (town == null) continue;

            if (lastTown == null) {
                sum += h.get(town);
            } else {
                double t1=h.get(town),t2=h.get(lastTown);
                sum += Math.sqrt(t1*t1-t2*t2);
            }
            lastTown = town;
        }
        sum += h.get(lastTown);
        return (int) Math.floor(sum);
    }

    public static void main(String args[])
    {
        String[] friends1 = new String[] { "A1", "A2", "A3", "A4", "A5" };
        String[][] fTowns1 = { new String[] {"A1", "X1"}, new String[] {"A2", "X2"}, new String[] {"A3", "X3"},
                new String[] {"A4", "X4"} };
        Map<String, Double> distTable1 = new HashMap<String, Double>();
        distTable1.put("X1", 100.0); distTable1.put("X2", 200.0); distTable1.put("X3", 250.0);
        distTable1.put("X4", 300.0);
        System.out.println(Tour.tour(friends1, fTowns1, distTable1));
    }
}
