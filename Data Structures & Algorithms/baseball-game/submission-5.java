class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (String op : operations) {
            if (op.equals("+")) {
               int top = stack.pop();
               int newTop = top + stack.peek();
               stack.push(top);
               sum += stack.push(newTop);
            } 
            else if (op.equals("D"))
            {
              sum += stack.push(2 * stack.peek());
            }
            else if (op.equals("C")) 
            {
                sum -= stack.pop();
            }
            else {
                sum += stack.push(Integer.parseInt(op));
            }
        }

        return sum;
    }
}