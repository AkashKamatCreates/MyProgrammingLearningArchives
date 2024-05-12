import java.util.*;

public class linkedlist {

    /*
     * types of linkedlist:
     *  - singly linkedlist (one direction)
     *  - doubly linkedlist (travells both directions)
     *  - circular linkedlist (last node and first node are the same)
     */
    public static void main(String[] args) {
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

        
    }
}
