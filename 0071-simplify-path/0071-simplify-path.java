class Solution {
    public String simplifyPath(String path) {
        Stack<String>stack = new Stack();
        int n = path.length();
        String[] st = path.split("/");
        for(String s :st)
        {
            if(s.equals(".") || s.equals("")) continue;
            else if(s.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!s.equals("..")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        for(String i : stack)
        {
            sb.append("/");
            sb.append(i);
        }
        String str = sb.toString();
        return str.length() == 0?"/":sb.toString();
    }
}