package com.wq.datastructure.stack01;

import java.util.Stack;

/**
 * 通过stack 实现后缀运算
 */
public class Count {

    public static void main(String[] args) {
        String[] s={"4","13","5","/","+"};
        Stack stack =new Stack();
        for(int i =0;i<s.length;i++){
            String item =  s[i];
            if("+".equals(item)){
               int v1= Integer.parseInt(stack.pop().toString());
               int v2= Integer.parseInt(stack.pop().toString());
               int result = v2+v1;
               stack.push(result);
            } else if("-".equals(item)){
                int v1= Integer.parseInt(stack.pop().toString());
                int v2= Integer.parseInt(stack.pop().toString());
                int result = v2-v1;
                stack.push(result);
            } else if("*".equals(item)){
                int v1= Integer.parseInt(stack.pop().toString());
                int v2= Integer.parseInt(stack.pop().toString());
                int result =  v2*v1;
                stack.push(result);
            } else if("/".equals(item)){
                int v1= Integer.parseInt(stack.pop().toString());
                int v2= Integer.parseInt(stack.pop().toString());
                int result =  v2/v1;
                stack.push(result);
            }else {
                stack.push(item);
            }
        }
        System.out.println(stack.peek());
    }
}
