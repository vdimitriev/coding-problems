package mk.dmt.cp.ltc.ltc9easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("is palindrome = " + pn.isPalindrome(123321));
    }

    public boolean isPalindrome(int x) {
        String sx = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(x == 0) return true;
        if(x < 0) return false;
        while(x != 0) {
            int z = x % 10;
            sb.append(z);
            x = x / 10;
        }
        return sx.contentEquals(sb);
    }
}
