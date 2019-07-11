package com.wq.datastructure.queue02;

public class TestQueueStack {
    public static void main(String[] args) {
        QueueStack queueStack =new QueueStack();
        queueStack.push(1);
        queueStack.push(3);
        queueStack.push(7);
        queueStack.push(5);
        queueStack.push(19);

        System.out.println(queueStack.peek());
        System.out.println(queueStack.size());


        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());

        System.out.println("操作后");
        System.out.println(queueStack.peek());
        System.out.println(queueStack.size());

    }
}
