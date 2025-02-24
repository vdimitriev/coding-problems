package mk.dmt.cp.ltc.ltc67easy;

public class AddBinary {

    public static void main(String[] args) {
//        String a = "1010111";
//        String b = "11001";

        String a = "101111";
        String b = "10";

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        AddBinary ab = new AddBinary();
        String c = ab.addBinary(a, b);
        System.out.println("a + b = " + c);
    }

    public String addBinary(String a, String b) {

        char[] ca = new StringBuilder(a).reverse().toString().toCharArray();
        char[] cb = new StringBuilder(b).reverse().toString().toCharArray();

        int la = a.length();
        int lb = b.length();

        int lenMin = Math.min(la, lb);
        int lenMax = Math.max(la, lb);

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < lenMin; i++) {
            int sum = Character.getNumericValue(ca[i]) + Character.getNumericValue(cb[i]) + carry;
            if(sum == 0) {
                result.append("0");
                carry = 0;
            } else if(sum == 1) {
                result.append("1");
                carry = 0;
            } else if(sum == 2) {
                result.append("0");
                carry = 1;
            } else if(sum == 3) {
                result.append("1");
                carry = 1;
            }
        }

        if(la > lb) {
            carry = calculateRest(result, carry, lenMin, lenMax, ca);
        } else if(lb > la) {
            carry = calculateRest(result, carry, lenMin, lenMax, cb);
        }

        if(carry == 1) {
            result.append(carry);
        }

        if(result.length() == 1) return result.toString();

        char[] rca = result.toString().toCharArray();
        for(int i = result.length() - 1; i >= 0; i--) {
          if(rca[i] == '0') {
              result.deleteCharAt(i);
          } else {
              break;
          }
        }
        return result.reverse().toString();
    }

    private int calculateRest(StringBuilder result, int carry, int lenMin, int lenMax, char[] charArray) {
        for(int i = lenMin; i < lenMax; i++) {
            int sum = Character.getNumericValue(charArray[i]) + carry;
            if(sum == 0) {
                result.append("0");
                carry = 0;
            } else if(sum == 1) {
                result.append("1");
                carry = 0;
            } else if(sum == 2) {
                result.append("0");
                carry = 1;
            }
        }
        return carry;
    }
}
