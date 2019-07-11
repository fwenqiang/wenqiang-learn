package com.wq.datastructure.queue02;

public class Queue {

    private int defaultSize = 100;
    private Integer[] value;

    private int front=0;
    private int tail =0;

    public Queue(int size){
        this.defaultSize = size;
        value =new Integer[size];
    }

    public Queue(){
        value =new Integer[defaultSize];
    }

    public synchronized void enqueue(Integer item){
        if(isFull()){
            throw  new RuntimeException("队列满了啊");
        }
        value[tail]= item;
        tail++;
    }

    public synchronized Integer dequeue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空了啊");
        }
        Integer item = value[front];
        value[front]=null;
        front++;
        return item;
    }

    public Integer head(){
        if(isEmpty()){
            throw  new RuntimeException("队列空了啊");
        }
        return value[front];
    }

    public Integer tail(){
        if(isEmpty()){
            throw  new RuntimeException("队列空了啊");
        }
        return value[tail-1];
    }

    public int size(){
        return  (tail-front);
    }

    public boolean isFull(){
        if((tail-front)==defaultSize){
            return  true;
        }
        return  false;
    }
    public boolean isEmpty(){
        if(tail==front){
            return true;
        }
       return  false;
    }

    public boolean clear(){
        value=null;
        value=new Integer[defaultSize];
        return true;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(5);

        System.out.println("size:"+queue.size());
        System.out.println("head:"+queue.head());
        System.out.println("tail:"+queue.tail());


        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(99);
        queue.enqueue(100);
        System.out.println("操作之后.................");

        System.out.println("size:"+queue.size());
        System.out.println("head:"+queue.head());
        System.out.println("tail:"+queue.tail());

    }
}
