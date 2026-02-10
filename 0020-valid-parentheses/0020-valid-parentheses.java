class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray(); // converted into character of array
        int n = array.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            else{
                if (stack.empty()) {
                return false;
            }
            char x = stack.pop();
            if ((x == '(' && c != ')') ||
                    (x == '{' && c != '}') ||
                    (x == '[' && c != ']')) {

                return false;

            }
            }
            
        }
        return stack.empty();
    }
}