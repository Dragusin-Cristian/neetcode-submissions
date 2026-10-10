class Solution {
    public int evalRPN(String[] tokens) {
        // edge case: empty array, only one item in array


        Stack<Integer> nums = new Stack<>();

        for (String t : tokens) {
            // if t is a symbol, compute for the last 2 numbers, 
            // pop them and push the result
            if (t.equals("+")) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push(a +b);
            }
            else if (t.equals("-")) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push(a -b);
            }
            else if (t.equals("*")) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push(a *b);
            }
            else if (t.equals("/")) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push((int)Math.floor(a/b));
            }
            else {
                // if t is a number, push to stack
                nums.push(Integer.parseInt(t));
            }
        }

        return nums.pop();
    }
}
