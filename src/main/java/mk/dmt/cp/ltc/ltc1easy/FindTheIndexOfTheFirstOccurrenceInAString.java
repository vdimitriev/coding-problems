package mk.dmt.cp.ltc.ltc1easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String hs = "mississippi";
        String nd = "issip";

        int k = strStr(hs, nd);
        System.out.println("k = " + k);
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        char[] hsa = haystack.toCharArray();
        char[] nda = needle.toCharArray();
        int index = -1;
        for(int i = 0; i < hsa.length; i++) {
            if(hsa[i] == nda[0]) {
                index = i;
                for(int j = 0; j < nda.length; j++) {
                    if((i + j) >= hsa.length || hsa[i + j] != nda[j]) {
                        index = -1;
                        break;
                    }
                }
                if(index > -1) {
                    return index;
                }
            }
        }
        return index;
    }
}
