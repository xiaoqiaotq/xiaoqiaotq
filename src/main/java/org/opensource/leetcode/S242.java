package org.opensource.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 https://leetcode-cn.com/problems/valid-anagram/
 */
public class S242 {
    public  static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] sChars = s.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            char sChar = s.charAt(i);
            Integer sCharCount = charCount.get(sChar);
            if (sCharCount==null) {
                charCount.putIfAbsent(sChar, 1);
            }else {
                charCount.put(sChar, ++sCharCount);
            }
            char tChar = t.charAt(i);
            Integer tCharCount = charCount.get(tChar);
            if (tCharCount==null) {
                charCount.put(tChar, -1);
            }else {
                charCount.put(tChar, --tCharCount);
            }
        }
        System.err.println(charCount);
        Integer result = charCount.values().stream().filter(integer -> integer != 0).findAny().orElse(null);

        return result==null;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aaab","baaa"));
        System.out.println(isAnagram("acaab","cbaaa"));
        System.out.println(isAnagram("acaabd","cbadaa"));
        System.out.println(isAnagram("eee","fff"));
    }
}
