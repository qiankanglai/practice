package google.round2;

import java.io.*;
import java.util.Arrays;

/**
 * Created by anthony on 5/31/14.
 */
public class UpandDown {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round2/B-small-attempt2.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round2/B-small-attempt2.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);

            temp = reader.readLine();
            int N = Integer.parseInt(temp);
            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int _data[] = new int[N];
            for (int i = 0; i < N; i++)
                _data[i] = Integer.parseInt(temp2[i]);

            int max = _data[0], maxID = 0;
            for(int i = 0; i < N; i++)
                if(_data[i] > max){
                    max = _data[i];
                    maxID = i;
                }
            int count = 0;
            int l = maxID;
            int r = maxID;
            int min = max;
            while(min > 0)
            {
                max = Integer.MIN_VALUE;
                maxID = -1;
                for(int i = 0;i < N;i++)
                {
                    if(_data[i] < min && _data[i] > max)
                    {
                        max = _data[i];
                        maxID = i;
                    }
                }
                if(maxID < l){
                    l = maxID;
                }else if(maxID > r){
                    r = maxID;
                }
                else if(maxID - l < r - maxID)
                {
                    for(int i = maxID;i > l;i--)
                    {
                        int t = _data[i];
                        _data[i] = _data[i-1];
                        _data[i-1] = t;
                        count++;
                    }
                }else
                {
                    for(int i = maxID;i < r;i++)
                    {
                        int t = _data[i];
                        _data[i] = _data[i+1];
                        _data[i+1] = t;
                        count++;
                    }
                }

                min = max;
            }
            /*int max_id = 0;
            for(int i = 1; i < N; i++)
                if(_data[i] > _data[max_id])
                    max_id = i;

            int min_count = 9999999;

            for(int mp = 0; mp < N; mp++) {
                int data[] = Arrays.copyOf(_data, N);
                if(mp < max_id){
                    for(int t = max_id; t > mp; t--)
                        data[t] = data[t-1];
                    data[mp] = _data[max_id];
                }
                else if(mp > max_id){
                    for(int t = max_id; t < mp; t++)
                        data[t] = data[t+1];
                    data[mp] = _data[max_id];
                }
                int count = Math.abs(max_id-mp);
                for (int i = 0; i < max_id; i++)
                    for (int j = 0; j < max_id - 1 - i; j++)
                        if (data[j] > data[j + 1]) {
                            int t = data[j + 1];
                            data[j + 1] = data[j];
                            data[j] = t;
                            count++;
                        }
                if(count > min_count)
                    continue;
                for (int i = 0; i < N - max_id; i++)
                    for (int j = N - 1; j > max_id + 1 + i; j--)
                        if (data[j] > data[j - 1]) {
                            int t = data[j - 1];
                            data[j - 1] = data[j];
                            data[j] = t;
                            count++;
                        }

                if(count < min_count)
                    min_count = count;
                if(min_count == 0)
                    break;
            }                     */

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write("" + count);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
