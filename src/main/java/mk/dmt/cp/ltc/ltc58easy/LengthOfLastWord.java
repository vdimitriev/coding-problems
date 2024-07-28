package mk.dmt.cp.ltc.ltc58easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s1 = "   fly me   to   the moon  ";
        String s2 = "luffy is still joyboy";

        int l1 = lengthOfLastWord(s1);
        int l2 = lengthOfLastWord(s2);

        System.out.println("L1 = " + l1);
        System.out.println("L2 = " + l2);
    }

    public static int lengthOfLastWord(String s) {
        if(s == null) return -1;
        String[] ss = s.split(" ");
        return ss[ss.length - 1].length();
    }
}
