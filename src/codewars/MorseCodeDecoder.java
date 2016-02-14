package codewars;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by anthony on 2/12/16.
 */
public class MorseCodeDecoder {
    private static Dictionary<String, String> MorseCode = new Hashtable<String, String>();

    public static String decodeBits(String bits) {
        // Trim
        if(bits.indexOf('1') < 0) return " ";
        bits = bits.substring(bits.indexOf('1'), bits.lastIndexOf('1')+1);

        boolean isZero = false;
        int minZeroCount = bits.length();
        int i=1;
        for(int k=1;k<bits.length();k++)
        {
            if(bits.charAt(k)==bits.charAt(k-1))
            {
                i++;
            }
            else
            {
                if(minZeroCount > i) minZeroCount = i;
                i=1;
            }
        }
        if(isZero && minZeroCount > i) minZeroCount = i;
        if(minZeroCount==0) return "."; // no zero...
        int len = bits.length()/minZeroCount;
        boolean []compact = new boolean[len];
        for(int k=0;k<len;k++)
        {
            compact[k] = (bits.charAt(k*minZeroCount)=='1');
        }
        String res = "";
        isZero = false;
        int zeroCount=0, oneCount=0;
        for(int k=0;k<len;k++)
        {
            if(compact[k])
            {
                if(isZero)
                {
                    if(zeroCount==3)
                        res += ' ';
                    else if(zeroCount==7)
                        res += "   ";
                    isZero = false;
                    oneCount=1;
                }
                else
                {
                    oneCount++;
                }
            }
            else
            {
                if(isZero)
                {
                    zeroCount++;
                }
                else
                {
                    if(oneCount==1)
                        res += '.';
                    else if(oneCount==3)
                        res += '-';
                    isZero = true;
                    zeroCount=1;
                }
            }
        }
        if(!isZero) {
            if (oneCount == 1)
                res += '.';
            else if (oneCount == 3)
                res += '-';
        }
        return res;
    }

    public static String decodeMorse(String morseCode) {
        String res = "";
        String[] words = morseCode.trim().split("   ");
        for(int i = 0; i < words.length; i++)
        {
            String[] characters = words[i].split(" ");
            for(int j=0;j<characters.length;j++)
            {
                res += MorseCode.get(characters[j]);
            }
            if(i+1<words.length)
                res += " ";
        }
        return res;
    }
}
