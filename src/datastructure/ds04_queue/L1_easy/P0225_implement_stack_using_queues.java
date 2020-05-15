package datastructure.ds04_queue.L1_easy;


/*
    使用队列实现栈
 */

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class P0225_implement_stack_using_queues {


    Queue<Integer> queue_out;   //保持一个栈顶元素

    Queue<Integer> queue_in;

    /**
     * Initialize your data structure here.
     */
    public P0225_implement_stack_using_queues() {
        queue_out = new LinkedBlockingQueue<>();
        queue_in = new LinkedBlockingQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        if (queue_out.isEmpty())
            queue_out.add(x);
        else {
            queue_in.add(queue_out.poll());
            queue_out.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        int res = queue_out.poll();

        while (queue_in.size() > 1) {
            queue_out.add(queue_in.poll());
        }

        //引用交换
        Queue tmp = queue_in;
        queue_in = queue_out;
        queue_out = tmp;

        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue_out.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue_out.isEmpty();
    }

}
