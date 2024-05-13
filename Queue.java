package org.example;
import java.util.*;

class PrimitiveQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public PrimitiveQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void push(int item) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot push.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot pop.");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[front];
    }

    public boolean empty() {
        return size == 0;
    }

    public int search(int item) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            if (queue[index] == item) {
                return i + 1;
            }
        }
        return -1;
    }


}

public class Queue1 {
    public static void main(String[] args) {
        PrimitiveQueue queue = new PrimitiveQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Search for 2: " + queue.search(2));
        System.out.println("Is queue empty? " + queue.empty());
        while (!queue.empty()) {
            System.out.println("Popped: " + queue.pop());
        }

        /**
         * NON PRIMITIVE QUEUE:
         */
        Queue<Integer> newqueue = new LinkedList<>();

        // Enqueue elements to the queue
        newqueue.offer(1);
        newqueue.offer(2);
        newqueue.offer(3);
        newqueue.offer(4);

        // Print the queue
        System.out.println("Queue: " + newqueue);

        // Peek at the head of the queue
        System.out.println("Peek: " + newqueue.peek()); // Returns 1

        // Retrieve and remove elements from the queue
        while (!newqueue.isEmpty()) {
            System.out.println("Polled: " + newqueue.poll()); // Retrieves and removes the head of the queue
        }

        // After removing all elements, the queue is empty
        System.out.println("Queue is empty: " + newqueue.isEmpty());

        // Adding element after removing all element from queue
        newqueue.add(4); // or use offer(4)

        // Print the queue
        System.out.println("Queue: " + newqueue);

        // Retrieve and remove elements from the queue
        while (!newqueue.isEmpty()) {
            System.out.println("Removed: " + newqueue.remove()); // Retrieves and removes the head of the queue
        }

    }
}
