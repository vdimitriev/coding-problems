package mk.dmt.cp.ltc.ltc13easy;

public class RomanToNumber {

    public static void main(String[] args) {
        RomanToNumber trn = new RomanToNumber();
        int result = trn.romanToInt("MCMXCIV");
        System.out.println(result);

    }

    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        for(int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'I') { sum = sum + 1; }
            if(c == 'V') {
                if(i > 0 && s.charAt(i - 1) == 'I') {
                    sum = sum + 4;
                    i = i - 1;
                } else {
                    sum = sum + 5;
                }
            }
            if(c == 'X') {
                if(i > 0 && s.charAt(i - 1) == 'I') {
                    sum = sum + 9;
                    i = i - 1;
                } else {
                    sum = sum + 10;
                }
            }
            if(c == 'L') {
                if(i > 0 && s.charAt(i - 1) == 'X') {
                    sum = sum + 40;
                    i = i - 1;
                } else {
                    sum = sum + 50;
                }
            }
            if(c == 'C') {
                if(i > 0 && s.charAt(i - 1) == 'X') {
                    sum = sum + 90;
                    i = i - 1;
                } else {
                    sum = sum + 100;
                }
            }
            if(c == 'D') {
                if(i > 0 && s.charAt(i - 1) == 'C') {
                    sum = sum + 400;
                    i = i - 1;
                } else {
                    sum = sum + 500;
                }
            }
            if(c == 'M') {
                if(i > 0 && s.charAt(i - 1) == 'C') {
                    sum = sum + 900;
                    i = i - 1;
                } else {
                    sum = sum + 1000;
                }
            }
        }
        return sum;
    }
}
