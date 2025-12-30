class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(
                c == '(' ||
                c == '{' ||
                c == '['
            ){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                char head = stack.pop();
                switch (c) {
                    case ')':
                        if(head != '(') return false;
                        break;
                    case '}':
                        if(head != '{') return false;
                        break;
                    case ']':
                        if(head != '[') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}