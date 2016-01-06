package google.foobar;

/**

 Name that rabbit
 ================

 "You forgot to give Professor Boolean's favorite rabbit specimen a name? You know how picky the professor is! Only particular names will do! Fix this immediately, before you're... eliminated!"

 Luckily, your minion friend has already come up with a list of possible names, and we all know that the professor has always had a thing for names with lots of letters near the 'tail end' of the alphabet, so to speak. You realize that if you assign the value 1 to the letter A, 2 to B, and so on up to 26 for Z, and add up the values for all of the letters, the names with the highest total values will be the professor's favorites. For example, the name Annie has value 1 + 14 + 14 + 9 + 5 = 43, while the name Earz, though shorter, has value 5 + 1 + 18 + 26 = 50.

 If two names have the same value, Professor Boolean prefers the lexicographically larger name. For example, if the names were AL (value 13) and CJ (value 13), he prefers CJ.

 Write a function answer(names) which takes a list of names and returns the list sorted in descending order of how much the professor likes them.

 There will be at least 1 and no more than 1000 names.
 Each name will consist only of lower case letters. The length of each name will be at least 1 and no more than 8.

 Languages
 =========

 To provide a Python solution, edit solution.py
 To provide a Java solution, edit solution.java

 Test cases
 ==========

 Inputs:
 (string list) names = ["annie", "bonnie", "liz"]
 Output:
 (string list) ["bonnie", "liz", "annie"]

 Inputs:
 (string list) names = ["abcdefg", "vi"]
 Output:
 (string list) ["vi", "abcdefg"]
 */
public class solution2 {
    public static String[] answer(String[] names)
    {
        int cache[] = new int[names.length];
        for(int i = 0; i < names.length; i++)
        {
            cache[i] = 0;
            for(int j = 0; j < names[i].length(); j++)
            {
                cache[i] += names[i].charAt(j) - 'a'+1;
            }
        }

        for(int i = 0; i < names.length; i++)
        {
            for(int j = 0; j < names.length-1-i; j++)
            {
                if(cache[j] < cache[j+1] || (cache[j]==cache[j+1] && names[j].compareTo(names[j+1]) < 0))
                {
                    String t = names[j];
                    names[j] = names[j+1];
                    names[j+1] = t;

                    int t2 = cache[j];
                    cache[j] = cache[j+1];
                    cache[j+1] = t2;
                }
            }
        }
        return names;
    }

    public static void main(String args[]){
        ppp(answer(new String[]{"annie", "bonnie", "liz"}));
        ppp(answer(new String[]{"abcdefg", "vi"}));
        ppp(answer(new String[]{"al", "cj"}));
    }

    public static void ppp(String[] names){
        for(int i = 0; i < names.length; i++)
        {
            System.out.print(names[i]+",");
        }
        System.out.println();
    }
}
