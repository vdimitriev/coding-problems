package mk.dmt.cp.ltc.ltc66easy;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{1,9,9,9};
        int[] result = plusOne(digits);

        for(int r : result) {
            System.out.print(r);
        }
        //result = 2 0 0 0

        // digits = 9
        // result = 10
        // digits = 99
        // result = 100
        // digits = 999
        // result = 1000
        // digits = 899
        // result = 900
        // digits = 9899
        // result = 9900
    }

    public static int[] plusOne(int[] digits) {

        boolean allNines = true;
        for(int d : digits) {
            if(d != 9) {
                allNines = false;
                break;
            }
        }
        int[] newDigits;
        if(allNines) {
            newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 1; i < newDigits.length; i++) {
                newDigits[i] = 0;
            }
        } else {
            newDigits = new int[digits.length];
            int carry = 0;
            int plusOne = 1;
            for(int i = digits.length - 1; i >= 0; i--) {
                int newValue = carry + digits[i] + plusOne;
                plusOne = 0;
                if(newValue > 9) {
                    carry = 1;
                    newValue = 0;
                } else {
                    carry = 0;
                }
                newDigits[i] = newValue;
            }
        }
        return newDigits;
    }
}
