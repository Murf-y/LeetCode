class Solution {
    public boolean isValid(String str) {
        Stack<String> stack= new Stack<String>();
        String open = "([{";
        String close = ")}]";
        
        for(int i = 0; i < str.length(); i++){
            String curr = String.valueOf(str.charAt(i));
            if(open.contains(curr)){
                stack.push(curr);
            }
            else if(stack.isEmpty()){
                return false;
            }
            // curr is close type
            else{
                if(curr.equals(")")){
                    if(!"(".equals(stack.pop())){
                        return false;
                    }
                }
                if(curr.equals("]")){
                    if(!"[".equals(stack.pop())){
                        return false;
                    }
                }
                if(curr.equals("}")){
                    if(!"{".equals(stack.pop())){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}