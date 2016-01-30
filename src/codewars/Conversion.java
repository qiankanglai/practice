package codewars;

/**
 * Created by qiank on 1/30/2016.
 */
public class Conversion {
    public String i2c(int t, char one, char five, char ten)
    {
        switch (t)
        {
            case 1: return ""+one;
            case 2: return ""+one+one;
            case 3: return ""+one+one+one;
            case 4: return ""+one+five;
            case 5: return ""+five;
            case 6: return ""+five+one;
            case 7: return ""+five+one+one;
            case 8: return ""+five+one+one+one;
            case 9: return ""+one+ten;
        }
        return "";
    }
    public String solution(int n) {
        String s = "";
        int t=(n/1000)%10;
        while(t>0)
        {
            s += "M";
            t--;
        }
        t = (n/100)%10;
        if(t > 0)
        {
            s += i2c(t, 'C', 'D', 'M');
        }
        t = (n/10)%10;
        if(t > 0)
        {
            s += i2c(t, 'X', 'L', 'C');
        }
        t = (n)%10;
        if(t > 0)
        {
            s += i2c(t, 'I', 'V', 'X');
        }
        return s;
    }

    public static void main(String args[])
    {
        System.out.println(new Conversion().solution(1990));
        System.out.println(new Conversion().solution(2008));
        System.out.println(new Conversion().solution(1666));
    }
}
