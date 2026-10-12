class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        // iterate though tokens
        for (String token : tokens) {

            // try to cast token into Integer, and see if it's possible
            if (isSymbol(token)) {

                if (token.equals("+")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                else if (token.equals("-")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                else if (token.equals("*")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }                
                else if (token.equals("/")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push((int)(a / Math.floor(b)));
                }
            }
            else {
               stack.push(Integer.parseInt(token));
            }
           
        }

        return stack.pop();

    }

    boolean isSymbol(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(Exception e) {
            return true;
        }
    }
}
