package mk.dmt.cp.ltc.ltc3medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharsLastPosition {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharsLastPosition object = new  LongestSubstringWithoutRepeatingCharsLastPosition();
        String s = "abcabcbb";
        object.longestSubstringLength(s);
    }

    void longestSubstringLength(String s) {
        int leftCharIndex = 0, maxLength = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int rightCharIndex = 0; rightCharIndex < chars.length; rightCharIndex++) {
            char rightChar = chars[rightCharIndex];
            if(lastSeen.containsKey(rightChar) && lastSeen.get(rightChar) >= leftCharIndex) {
                leftCharIndex = lastSeen.get(rightChar) + 1;
            }

            maxLength = Math.max(maxLength, rightCharIndex - leftCharIndex + 1);
            lastSeen.put(rightChar, rightCharIndex);
        }
        System.out.println("max length = " + maxLength);
    }
}
