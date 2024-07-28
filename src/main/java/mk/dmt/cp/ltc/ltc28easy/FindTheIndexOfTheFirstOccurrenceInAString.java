package mk.dmt.cp.ltc.ltc28easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        char[] hsa = haystack.toCharArray();
        char[] nda = needle.toCharArray();

        int index = -1;
        int hsal = hsa.length;

        for(int i = 0; i < hsal; i++) {
            if(hsa[i] == nda[0]) {
                index = i;
                for(int j = 0; j < nda.length; j++) {
                    int l = i + j;
                    if((l) >= hsal || hsa[l] != nda[j]) {
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
