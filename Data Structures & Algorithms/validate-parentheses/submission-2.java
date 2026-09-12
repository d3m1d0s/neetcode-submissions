class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':     
                case '{':
                stack.push(ch);
                break;
                case ')':
                if (stack.empty()) return false;
                if (stack.pop() != '(') {
                  return false;
                }
                break;
                case ']':
                if (stack.empty()) return false;
                if (stack.pop() != '[') {
                    return false;
                }
                break;
                case '}':
                if (stack.empty()) return false;
                if (stack.pop() != '{') {
                    return false;
                }
                break;
            }
        }

        if (!stack.empty()) {
            return false;
        }
        
        return true;
    }
}
