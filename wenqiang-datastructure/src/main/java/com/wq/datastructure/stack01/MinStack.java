package com.wq.datastructure.stack01;

/**
 * 实现一个栈，并且包含min方法，时间复杂度O(1)
 * 实现逻辑
 * 1，两个stack处理
 * 2,一个stack保留值，一个stack保留当前位置时的最小值(这样不至于push时，找不到当前时刻的最小值了)。
 * 3，同时考虑push和pop时的处理。
 * by  Eric 2019-07-06 20:00
 */
public class MinStack {
    private Stack valueStack;
    private Stack minStack;

    public MinStack(int size) {
        valueStack = new Stack(size);
        minStack = new Stack(size);
    }

    public MinStack() {
        valueStack = new Stack();
        minStack = new Stack();
    }


    public  void  push(Integer item){
          valueStack.push(item);

          //永远记录，当前值进来时，对应的最小值是多少，这样两个栈是有一个一一对应的关系。当pop时，两边栈都同时pop，这样就不至于主栈pop时，不知道最小值是多少了。
          if(valueStack.getTop()==0 || minStack.peek()>item){
              minStack.push(item);
          }else if(minStack.peek()<item) {
              minStack.push(minStack.peek());
           /* *//*  //保留上一个最小值
              minStack.push(minStack.peek());*//*
              if(minStack.peek()<item){ //
                  minStack.push(minStack.peek());
              }*/
          }
    }

    public Integer pop(){
        minStack.pop();
        return valueStack.pop();
    }

    public Integer peek(){
        return valueStack.peek();
    }

    public Integer min(){
        return minStack.peek();
    }

    public Integer size(){
        return valueStack.size();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(4);
        minStack.push(8);
        minStack.push(1);

        System.out.println("size:"+minStack.size());
        System.out.println("peek:"+minStack.peek());
        System.out.println("min:"+minStack.min());
        minStack.pop();
        System.out.println("pop之后===================================");
        System.out.println("size:"+minStack.size());
        System.out.println("peek:"+minStack.peek());
        System.out.println("min:"+minStack.min());

        System.out.println("minSize:"+minStack.size());
    }
}
