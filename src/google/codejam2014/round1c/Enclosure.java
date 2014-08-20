package google.codejam2014.round1c;

import java.io.*;

/**
 * Created by Anthony on 2014/5/11.
 */
public class Enclosure {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1c/C-small-attempt1.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C-small.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);

            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int N = Integer.parseInt(temp2[0]);
            int M = Integer.parseInt(temp2[1]);
            int K = Integer.parseInt(temp2[2]);

            int min_stone = N*M;
            if(M<=2 || N<=2 || K < 5)
                min_stone = K;
            else {
                for (int x = 2; x <= N; x++)
                    for (int y = 2; y <= M; y++) {
                        int stones = 2 * (x+y-2);
                        int enclosing = x * y;
                        if (enclosing >= K) {
                            if (stones < min_stone)
                                min_stone = stones;
                        }
                        else{
                            int y_space = M-y;
                            int x_space = x-2;
                            while(true){
                                if(y_space <= 0 || x_space <= 0)
                                    break;
                                enclosing += x_space;
                                y_space--;
                                if(y_space <= 0 || x_space <= 0)
                                    break;
                                enclosing += x_space;
                                y_space--;
                                x_space -= 2;
                            }

                            x_space = N-x;
                            y_space = y-2;
                            while(true){
                                if(y_space <= 0 || x_space <= 0)
                                    break;
                                enclosing += y_space;
                                x_space--;
                                if(y_space <= 0 || x_space <= 0)
                                    break;
                                enclosing += y_space;
                                x_space--;
                                y_space -= 2;
                            }
                            //Grow!
                            if (enclosing >= K) {
                                if (stones < min_stone)
                                    min_stone = stones;
                            }
                            else{
                                //Go on Grow!
                                int grow_count_x = 0, grow_count_y = 0;
                                if(x < N)
                                    grow_count_y = Math.min(N-x,2)*((y==2)?1:2);
                                if(y < M)
                                    grow_count_x = Math.min(M-y,2)*((x==2)?1:2);

                                while(enclosing<K && grow_count_x>0){
                                    enclosing++;
                                    stones++;
                                    grow_count_x--;
                                }
                                while(enclosing<K && grow_count_y>0){
                                    enclosing++;
                                    stones++;
                                    grow_count_y--;
                                }
                                if (enclosing >= K) {
                                    if (stones < min_stone)
                                        min_stone = stones;
                                }//oooops
                            }
                        }

                    }
            }

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write(""+min_stone);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
