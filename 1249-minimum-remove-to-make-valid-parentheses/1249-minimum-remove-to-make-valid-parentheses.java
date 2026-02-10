class Solution {
    public String minRemoveToMakeValid(String s) {
        int extraL = 0;
        int extraR = 0;
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    extraR++;
                }
            }
        }

        extraL = stack.size();

        for (int i = sb.length() - 1; i >= 0 && extraL > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                extraL--;
            }
        }

        for (int i = 0; i < sb.length() && extraR > 0; i++) {
            if (sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
                i--; 
                extraR--;
            }
        }

        return sb.toString();
    }
}