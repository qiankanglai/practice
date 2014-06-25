package lintcode;

import library.KMP;

/**
 * Created by anthony on 6/25/14.
 */
public class strStr {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        return new KMP().indexOf(source.toCharArray(), target.toCharArray());
    }
}
