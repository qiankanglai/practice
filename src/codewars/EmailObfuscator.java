package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class EmailObfuscator {
    public static String obfuscate(String email) {
        return email.replaceAll("@", " [at] ").replaceAll("\\.", " [dot] ");
    }
}
