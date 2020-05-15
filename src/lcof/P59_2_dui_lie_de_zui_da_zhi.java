package lcof;

import java.util.Deque;
import java.util.LinkedList;

public class P59_2_dui_lie_de_zui_da_zhi {

    class MaxQueue {

        class Entity {
            public Entity(int index, int data) {
                this.index = index;
                this.data = data;
            }

            public int index;
            public int data;

        }

        Deque<Entity> dataQueue;
        Deque<Entity> maxQueue;

        public MaxQueue() {
            dataQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            if (maxQueue.isEmpty())
                return -1;
            else
                return maxQueue.peek().data;
        }

        public void push_back(int value) {

            //队列为空
            if (dataQueue.isEmpty()) {
                dataQueue.add(new Entity(0, value));
                maxQueue.add(dataQueue.peek());
            } else {

                dataQueue.add(new Entity(dataQueue.peekLast().index + 1, value));

                while (!maxQueue.isEmpty() && maxQueue.peekLast().data < value)
                    maxQueue.pollLast();

                maxQueue.add(dataQueue.peekLast());
            }
        }

        public int pop_front() {

            if (dataQueue.isEmpty())
                return -1;

            Entity entity = dataQueue.poll();

            if (!maxQueue.isEmpty() && maxQueue.peek().index == entity.index)
                maxQueue.poll();

            return entity.data;
        }
    }


    public static void main(String[] args){

        MaxQueue maxQueue = new P59_2_dui_lie_de_zui_da_zhi().new MaxQueue();

        maxQueue.push_back(1);
        maxQueue.push_back(2);

        System.out.println(maxQueue.max_value());

        System.out.println(maxQueue.pop_front());

        System.out.println(maxQueue.max_value());


    }
}
