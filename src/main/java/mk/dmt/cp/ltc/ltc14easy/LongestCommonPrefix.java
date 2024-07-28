package mk.dmt.cp.ltc.ltc14easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower","flow","flight"};
        String[] strs2 = new String[]{"dog","racecar","car"};
        String[] strs3 = new String[]{"cir","car"};

        String l1 = longestCommonPrefix(strs1);
        System.out.println(l1);

        String l2 = longestCommonPrefix(strs2);
        System.out.println(l2);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String max = "";
        int maxLen = 0;
        for(String s : strs) {
            if(s.length() >= maxLen) {
                maxLen = s.length();
                max = s;
            }
        }
        for(int i = 0; i < strs.length - 1; i++) {

            String prefix = longestPrefix(strs[i], strs[i+1]);
            if(prefix.length() < max.length()) {
                max = prefix;
            }
        }
        return max;
    }

    private static String longestPrefix(String str1, String str2) {
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();

        int len = Math.min(str1.length(), str2.length());

        StringBuilder longestStr = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if(chr1[i] == chr2[i]) {
                longestStr.append(chr1[i]);
            } else {
                break;
            }
        }
        return longestStr.toString();
    }
}
