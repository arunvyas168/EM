package M;


import java.util.Stack;

/*
    SOLUTION:
        1. Split with /  ---> into an array
        2. Use stack traverse array
        3. if string = .. then we pop() --> check if empty
        4. if string is NOT  "" or . then push
        5. NOTE: --> if stack is empty after all this then return "/";
        6.NOTE: ---> not to use stack.pop() --> use (String s : stack)
*/


public class SimplifyUnixPath {
    public static String simplifyPath(String path) {
        if (path==null){
            return path;
        }
        String[] token = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String string: token){
            if(string.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if((!string.equals(""))&&(!string.equals("."))){
                stack.push(string);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        //NOTE: ---> not to use stack.pop() --> use (String s : stack)
        for(String str: stack){
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String input = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(input));
    }
}
