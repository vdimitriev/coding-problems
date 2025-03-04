package mk.dmt.cp.ltc.ltc3medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharsSlidingWindow {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharsSlidingWindow object = new  LongestSubstringWithoutRepeatingCharsSlidingWindow();
        String s = "abcabcbb";
        object.longestSubstringLength(s);
    }

    void longestSubstringLength(String s) {
        int leftCharIndex = 0, maxLength = 0;
        char[] chars = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(int rightCharIndex = 0; rightCharIndex < chars.length; rightCharIndex++) {
            char rightChar = chars[rightCharIndex];
            while(charSet.contains(rightChar)) {
                charSet.remove(chars[leftCharIndex]);
                leftCharIndex++;
            }
            charSet.add(rightChar);
            maxLength = Math.max(maxLength, rightCharIndex - leftCharIndex + 1);
        }
        System.out.println("max length = " + maxLength);
    }
}
