class Solution {
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;

        String path = "";
        List<String> result = new ArrayList<>();

        backtrack(result, path, 0, 0);

        return result;
    }

    void backtrack(List<String> result, String path, int opened, int closed) {
        
            // if is a leaf, add to result
            if (path.length() == 2*n) {
                result.add(new String(path));
                return;
            }

            // if opened <= n => open
            if (opened < n) {
                path += "(";
                backtrack(result, path, opened+1, closed);
                // pop
                path = path.substring(0, path.length() - 1);
            }


            // if closed < opened => close
            if (closed < opened) {
                path += ")";
                backtrack(result, path, opened, closed+1);
                // pop
                path = path.substring(0, path.length() - 1);
            }

    }




}
