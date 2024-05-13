
package org.example;
import java.util.*;

public class Stack1 {
    private int[] array;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack1(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1; // Empty stack initially
    }

    // Push operation to add an element to the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push element " + element + ", Stack is full.");
            return;
        }
        array[++top] = element;
    }

    // Pop operation to remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop from an empty stack.");
            return Integer.MIN_VALUE; // Return a sentinel value indicating stack underflow
        }
        return array[top--];
    }

    // Peek operation to return the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE; // Return a sentinel value indicating stack is empty
        }
        return array[top];
    }

    // Empty operation to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Search operation to find the position of an element in the stack (1-based index)
    public int search(int element) {
        for (int i = top; i >= 0; i--) {
            if (array[i] == element) {
                return top - i + 1;
            }
        }
        return -1; // Element not found in the stack
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        Stack1 stack = new Stack1(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Search for 2: " + stack.search(2));

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        /**
         * NON PRIMITIVE WAY FOR STACK IMPLEMETATION AND OPERATIONS:
         */

        Stack<String> newstack = new Stack<>();

        // Push operation to add elements to the stack
        newstack.push("Java");
        newstack.push("Python");
        newstack.push("C++");

        // Peek operation to return the top element of the stack without removing it
        String topElement = null;
        try {
            topElement = newstack.peek();
            System.out.println("Top element: " + topElement);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty.");
        }

        // Pop operation to remove and return the top element from the stack
        String poppedElement = null;
        try {
            poppedElement = newstack.pop();
            System.out.println("Popped element: " + poppedElement);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty.");
        }

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Search operation to find the position of an element in the stack (1-based index)
        int position = newstack.search("Java");
        if (position != -1) {
            System.out.println("Position of 'Java': " + position);
        } else {
            System.out.println("'Java' not found in the stack.");
        }
    }
}


