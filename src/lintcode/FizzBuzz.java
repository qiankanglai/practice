package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/24.
 */
public class FizzBuzz {
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> results = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0)
                results.add("fizz buzz");
            else if(i % 5 == 0)
                results.add("buzz");
            else if(i % 3 == 0)
                results.add("fizz");
            else
                results.add(""+i);
        }
        return results;
    }

    public static void main(String args[]){
        new FizzBuzz().fizzBuzz(15);
    }
}
