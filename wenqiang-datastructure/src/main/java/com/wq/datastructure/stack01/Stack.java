package com.wq.datastructure.stack01;

/**
 * 数组实现stack类
 * by  Eric 2019-07-06 20:00
 *
 * 注意点：
 * 1.包含一个默认的大小
 * 2.包含一个指针，指向最后一个元素
 * 3.push和pop方法，考虑多线程环境同步问题
 * 4.push和pop时，考虑数组满和空的问题
 */
public class Stack {

    private int size = 100;
    private  Integer[] items;
    private int top;

   public Stack(int size){
       if(size>0){
           items = new Integer[size];
           this.size= size;
       }else{
           items = new Integer[size];
       }
       top= -1;
   }

    public Stack(){
        items = new Integer[size];
        top= -1;
    }


    /**
     * 放入一个元素
     * @param item
     */
    public synchronized void push(Integer item){
        if(isFull()){
            throw  new RuntimeException("push时stack满了");
        }
        top++;
        items[top]=item;
    }

    /**
     * 返回一个栈顶元素,并移除
     */
    public synchronized Integer pop(){
        if(isEmpty()){
            throw  new RuntimeException("pop时没有元素了");
        }
        Integer topItem = items[top];
        items[top]=null;
        top--;
        return topItem;
    }

    /**
     * 返回栈顶元素,但不移除
     */
    public Integer peek(){
        if(isEmpty()){
            throw  new RuntimeException("peek时stack为空");
        }
        return items[top];
    }

    public int size(){
        return  top+1;
    }

    public boolean isEmpty(){
        return  top==-1;
    }


    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public boolean isFull(){
       return  top+1==size;
    }

    //1.栈实现
    //2.栈实现后缀表达式加减乘除
    //3.中缀表达式，如何转成后缀表达式
}
