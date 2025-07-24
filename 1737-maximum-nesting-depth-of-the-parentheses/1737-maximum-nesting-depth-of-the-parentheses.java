class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int maxDepth = 0;
        int currDepth = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                currDepth++;
                maxDepth = Math.max(maxDepth, currDepth);
            } else if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
                currDepth--;
            }
        }
        return maxDepth;
    }
}