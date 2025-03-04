package mk.dmt.cp.ltc.ltc3medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharsHashMap {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharsHashMap object = new  LongestSubstringWithoutRepeatingCharsHashMap();
        String s = "abcabcbb";
        object.longestSubstringLength(s);
    }

    void longestSubstringLength(String s) {
        int leftCharIndex = 0, maxLength = 0;
        Map<Character,Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int rightCharIndex = 0; rightCharIndex < chars.length; rightCharIndex++) {
            char rightChar = chars[rightCharIndex];
            count.merge(rightChar, 1, Integer::sum);
            while(count.get(rightChar) > 1) {
                count.merge(chars[leftCharIndex], -1, Integer::sum);
                leftCharIndex++;
            }

            maxLength = Math.max(maxLength, rightCharIndex - leftCharIndex + 1);
        }
        System.out.println("max length = " + maxLength);
    }
}
