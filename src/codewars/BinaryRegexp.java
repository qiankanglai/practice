package codewars;

import java.util.regex.Pattern;

/**
 * Created by qiank on 1/30/2016.
 */
public class BinaryRegexp {
    //http://math.stackexchange.com/questions/140283/why-does-this-fsm-accept-binary-numbers-divisible-by-three
    //http://www.cnblogs.com/lgp687/p/3956849.html
    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("(0|11|10(1|00)*01)*");
    }

    public static void main(String args[])
    {
        System.out.println(multipleOf3().matcher("010").matches());
    }
}
