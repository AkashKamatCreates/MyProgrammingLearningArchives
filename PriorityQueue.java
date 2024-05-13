import java.util.*;

//in this code, the priority is set according to decending order. 

public class PriorityQueueDescendingOrderExample {
    public static void main(String[] args) {
        // Create a priority queue with a custom comparator for descending order
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to the priority queue
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(8);
        priorityQueue.offer(3);

        // Print the priority queue
        System.out.println("Priority Queue (Descending Order): " + priorityQueue);

        // Poll elements from the priority queue (in descending order)
        while (!priorityQueue.isEmpty()) {
            System.out.println("Polled: " + priorityQueue.poll());
        }
    }
}
