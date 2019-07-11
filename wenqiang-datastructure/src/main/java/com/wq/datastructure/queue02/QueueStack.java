package com.wq.datastructure.queue02;

/**
 * 两个堆，实现一个栈
 */
public class QueueStack {
    private Queue queue1;
    private Queue queue2;

    private Queue dataQueue = null;
    private Queue emptyQueue = null;

    public QueueStack(int size){
        queue1 = new Queue(size);
        queue2 = new Queue(size);
    }

    public QueueStack(){
        queue1 = new Queue();
        queue2 = new Queue();
    }

    public synchronized  void push(int item){
        if(queue1.size()==0 && queue2.size()==0){
            queue1.enqueue(item);

            dataQueue = queue1;
            emptyQueue = queue2;
        }else if(queue1.size()>0){
            queue1.enqueue(item);

            dataQueue = queue1;
            emptyQueue = queue2;
        }else  if(queue2.size()>0){
            queue2.enqueue(item);

            dataQueue = queue2;
            emptyQueue = queue1;
        }
    }

    public synchronized  int pop(){
        //将不为空队列的尾部元素放入空队列
        int tailItem =  dataQueue.tail();
        if(emptyQueue==null){
            emptyQueue = queue1.size()==0?queue1:queue2;
        }
        emptyQueue.enqueue(tailItem);
        //遍历queue1队列，一次放入queue2
        int size = dataQueue.size();
        for(int i=0;i<size;i++){
            //最后一个元素，只能弹出，不能放入队列
            if(i==size-1){
                dataQueue.dequeue();
            }else {
                emptyQueue.enqueue(dataQueue.dequeue());
            }
        }
        dataQueue = emptyQueue;
        emptyQueue = null;
        return  dataQueue.dequeue();

       /* if(queue1.size()>0){
            //将不为空队列的尾部元素放入空队列
            int tailItem =  queue1.tail();
            queue2.enqueue(tailItem);
            //遍历queue1队列，一次放入queue2
            int size = queue1.size();
            for(int i=0;i<size;i++){
                //最后一个元素，只能弹出，不能放入队列
                if(i==size-1){
                    queue1.dequeue();
                }else {
                    queue2.enqueue(queue1.dequeue());
                }
            }
            return  queue2.dequeue();
        }else {
            //将不为空队列的尾部元素放入空队列
            int tailItem =  queue2.tail();
            queue1.enqueue(tailItem);
            //遍历queue1队列，一次放入queue2
            int size = queue2.size();
            for(int i=0;i<size;i++){
                //最后一个元素，只能弹出，不能放入队列
                if(i==size-1){
                    queue2.dequeue();
                }else {
                    queue1.enqueue(queue2.dequeue());
                }
            }
            return  queue1.dequeue();
        }*/
    }

    public  int peek(){
        if(dataQueue.size()>0){
            return   dataQueue.tail();
        }else {
            return dataQueue.tail();
        }
    }

    public  int size(){
        if(dataQueue.size()>0){
            return   dataQueue.size();
        }else {
            return dataQueue.size();
        }
    }
}
