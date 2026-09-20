class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] bracketsArr = s.toCharArray();
        Map<Character, Character> bracketsMap = new HashMap<>(
            Map.of('(', ')', '[', ']', '{', '}')
            );

        // start stack with first open bracket
        Character firstBracket = bracketsArr[0];
        if (bracketsMap.get(firstBracket) == null) {
            return false;
        } else {
            stack.push(firstBracket);
        }

        for (int i = 1; i < bracketsArr.length; i++ ) {
            // add open brackets to stack  
            if (bracketsMap.get(bracketsArr[i]) != null) {
                stack.push(bracketsArr[i]);
            }

            // maybe handle case when stack is null, and is a closing bracket
            else if (stack.size() == 0) {
                return false;
            }

            // if close bracket is not the same with latest open bracket
            // from stack, return false;
            // if it is, remove the latest open bracket from stack
            else if (bracketsArr[i] != bracketsMap.get(stack.pop())) {
                return false;
            } 
        }

        // after loop, if stack is empty return true, else return false
        return stack.size() == 0;

    }
}
