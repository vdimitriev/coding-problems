package mk.dmt.cp.ltc.ltc20easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s0 = "]";
        boolean b0 = vp.isValid(s0);
        System.out.println("Valid: " + b0);
        String s1 = "()";
        boolean b1 = vp.isValid(s1);
        System.out.println("Valid: " + b1);
        String s2 = "()[]{}";
        boolean b2 = vp.isValid(s2);
        System.out.println("Valid: " + b2);
        String s3 = "(]";
        boolean b3 = vp.isValid(s3);
        System.out.println("Valid: " + b3);
        String s4 = "{[()]}";
        boolean b4 = vp.isValid(s4);
        System.out.println("Valid: " + b4);
        String s5 = "{[()]}{[([{}])]}{[()]}";
        boolean b5 = vp.isValid(s5);
        System.out.println("Valid: " + b5);
    }

    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;

        char[] chars = s.toCharArray();
        LinkedList<Bracket> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            Bracket bracket = getBracket(chars[i]);
            if(bracket != null && bracket.isOpen()) {
                stack.push(bracket);
            } else if(stack.isEmpty()) {
                return false;
            } else if(bracket != null && bracket.isClosed()) {
                Bracket poped = stack.pop();
                if(poped != null && poped.type != bracket.type) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Bracket getBracket(char chr) {
        switch (chr) {
            case '(': return new Bracket(BracketType.SMALL, BracketStatus.OPEN, chr);
            case '[': return new Bracket(BracketType.MIDDLE, BracketStatus.OPEN, chr);
            case '{': return new Bracket(BracketType.LARGE, BracketStatus.OPEN, chr);
            case ')': return new Bracket(BracketType.SMALL, BracketStatus.CLOSED, chr);
            case ']': return new Bracket(BracketType.MIDDLE, BracketStatus.CLOSED, chr);
            case '}': return new Bracket(BracketType.LARGE, BracketStatus.CLOSED, chr);
            default: return null;
        }
    }

    private static boolean isOpenBracket(Bracket bracket) {
        return new HashSet<>(Arrays.asList('(', '[', '{')).contains(bracket.character);
    }

    private static boolean isClosedBracket(char chr) {
        return new HashSet<>(Arrays.asList(')', ']', '}')).contains(chr);
    }

    private enum BracketType {
        SMALL,
        MIDDLE,
        LARGE
    }

    private enum BracketStatus {
        OPEN,
        CLOSED
    }

    private class Bracket {
        BracketType type;
        BracketStatus status;
        Character character;

        public Bracket(BracketType type, BracketStatus status, Character character) {
            this.type = type;
            this.status = status;
            this.character = character;
        }

        boolean isOpen() {
            return BracketStatus.OPEN == status;
        }

        boolean isClosed() {
            return BracketStatus.CLOSED == status;
        }
    }
}
