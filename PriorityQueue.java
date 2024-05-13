package org.example;

import java.util.*;

public class q {
    public static void main(String[] args) {

        /**
         * NON PRIMITIVE WAY OF HEAP / PRIORITY QUEUE:
         */

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

        /**
         * PRIMITIVE WAY OF HEAP / PRIORITY QUEUE:
         */

        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(5);

        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Extracted Min: " + minHeap.extractMin());

        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(5);

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Extracted Max: " + maxHeap.extractMax());
    }

    static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full. Cannot insert.");
                return;
            }

            size++;
            int index = size - 1;
            heap[index] = value;
            heapifyUp(index);
        }

        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            while (index > 0 && heap[parentIndex] > heap[index]) {
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }

        public int extractMin() {
            if (size == 0) {
                System.out.println("Heap is empty. Cannot extract min.");
                return -1;
            }

            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return min;
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
                smallest = rightChildIndex;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full. Cannot insert.");
                return;
            }

            size++;
            int index = size - 1;
            heap[index] = value;
            heapifyUp(index);
        }

        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            while (index > 0 && heap[parentIndex] < heap[index]) {
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }

        public int extractMax() {
            if (size == 0) {
                System.out.println("Heap is empty. Cannot extract max.");
                return -1;
            }

            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return max;
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                swap(index, largest);
                heapifyDown(largest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
}
