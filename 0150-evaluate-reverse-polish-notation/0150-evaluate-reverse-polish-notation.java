class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(!isOperator(s)){
                stack.push(Integer.parseInt(s));
            } else {
                char op = s.charAt(0);
                int b = stack.pop();
                int a = stack.pop();
                switch (op) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        if (s == null || s.length() != 1) return false;
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}