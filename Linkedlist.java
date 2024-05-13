package org.example;
import java.util.*;

    /*
     * types of linkedlist:
     *  - singly linkedlist (one direction)
     *  - doubly linkedlist (travells both directions)
     *  - circular linkedlist (last node and first node are the same)
     */

//singly linked list:
class listnode {
    int value;
    listnode next;
    listnode (int x){
        value = x;
        next=null;
    }
}

//doubly linked list:
class doublylistnode {
    int value;
    doublylistnode next;
    doublylistnode prev;
    doublylistnode (int x){
        value = x;
        next=null;
        prev=null;
    }
}

//circular linked list: same as singly or doubly linked list with last.next to head


public class LinkedList1 {
    public static void main(String[] args) {

        //old code: 
        LinkedList<String> list = new LinkedList<>();
        
        //adding nodes to the linkedlist
        //addFirst adds to the start of the linkedlist
        list.addFirst("akash");
        list.addFirst("kamat");
        list.addFirst("this is first node");
        list.addFirst("sample to be removed");

        //adding to the last of the linkedlist
        //.add and .addLast are basically the same, adding elements to the last.
        list.add("this is added at the last");
        list.addLast("last addition using addLast");

        //printing the linked list
        System.out.println(list);

        //printing linked list size
        System.out.println(list.size());

        //iterating through the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Searching for an element in linkedlist
        if(list.contains("kamat")){
                System.out.println("yes");
        }
        
        //removing from the linkedlist 
        System.out.println(list);
        list.removeFirst(); //removes first element of the list
        System.out.println(list);
        list.removeLast(); //removes the last element of the list
        System.out.println(list);
        list.remove(3); //removes element on the index. 
        System.out.println(list);

        
        /**
        *
        * NEW CODE HEREON:
        *
        */
        //NEW CODE:        
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
        List<Integer> doublyLinkedList = new LinkedList<>();
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
