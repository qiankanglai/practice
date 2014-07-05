package microsoft.AutumnCampus.FollowDirections;

import java.io.*;

/**
 * Created by anthony on 7/5/14.
 */
public class FollowDirections {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/microsoft/AutumnCampus/FollowDirections/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/FollowDirections/FollowDirections.txt"));

        int x = 0, y = 0;
        int direction = 0;  //North, East, South, Wast
        final int dx[] = {0, 1, 0, -1};
        final int dy[] = {1, 0, -1, 0};
        while(true) {
            String temp = reader.readLine();
            if(temp == null || temp.length() == 0)
                break;
            String[] temp2 = temp.split(" ");
            if(temp2[0].equals("Move")){
                int steps = Integer.parseInt(temp2[1]);
                x += dx[direction] * steps;
                y += dy[direction] * steps;
            }
            else if(temp2[0].equals("Turn")){
                if(temp2[1].equals("right")){
                    direction = (direction+1)%4;
                }
                else if(temp2[1].equals("left")){
                    direction = (direction+3)%4;
                }
            }
        }
        writer.write(String.valueOf(x));
        writer.write(',');
        writer.write(String.valueOf(y));
        reader.close();
        writer.close();
    }
}
