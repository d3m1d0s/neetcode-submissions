class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':     
                case '{':
                stack.push(ch);
                break;
                case ')':
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') {
                  return false;
                }
                break;
                case ']':
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') {
                    return false;
                }
                break;
                case '}':
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') {
                    return false;
                }
                break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
