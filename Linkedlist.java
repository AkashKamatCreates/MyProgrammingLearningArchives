package org.example;
import java.util.*;

class listnode {
    int value;
    listnode next;
    listnode (int x){
        value = x;
        next=null;
    }
}


public class LinkedList1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Adding elements to the LinkedList
        list.add(10);
        list.add(20);
        list.add(490);
        list.add(4342);
        list.add(129000);

        // Displaying elements of the LinkedList
        System.out.println("ORIGINAL LINKED LIST: ");
        for (Integer num : list) {
            System.out.print(num+" ");
        }

        System.out.println("\nMIDDLE ELEMENT: " + middleElement(list));

        System.out.println(list);

        //Doubly linked list non-primitive way:
        LinkedList<Integer> doublyLinkedList = new LinkedList<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);

        // Iterate over the list to fetch previous and next elements
        ListIterator<Integer> iterator = doublyLinkedList.listIterator();
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            Integer previous = null;
            Integer next = null;

            // If there's a previous element, fetch it
            if (iterator.hasPrevious()) {
                previous = iterator.previous();
                iterator.next(); // Reset the iterator to its original position
            }

            // If there's a next element, fetch it
            if (iterator.hasNext()) {
                next = iterator.next();
                iterator.previous(); // Reset the iterator to its original position
            }

            System.out.println("Current: " + current + ", Previous: " + previous + ", Next: " + next);
        }
    }

    private static int middleElement(LinkedList<Integer> list){
        int i = list.size();
        int result = list.get(i/2);
        return result;
    }

    public boolean hasCycle(listnode head) {
        listnode fast = head;
        listnode slow = head;
        if(head==null || head.next==null) return false;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) return true;
        }

        return false;
    }
}
