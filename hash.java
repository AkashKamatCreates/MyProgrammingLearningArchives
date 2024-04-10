import java.util.*;

public class hash {
    public static void main(String[] args) {
        System.out.println("-----HASHSET-----");
        //Create
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(8);
        set.add(5);
        set.add(4);

        //contains
        if(set.contains(3)){
            System.out.println("set contains 3!!!");
        }
        if(!set.contains(6)){
            System.out.println("doesnt contain 6");
        }

        //size of set
        System.out.println("size of set is: "+ set.size());
        
        //printing the set
        System.out.println(set);
        System.out.println("above hashset may look ordered but hashsets are unordered and the order of elements can change over time.");


        //iterator
        //in normal arrays, we use for(int i=0; i<n; i++) where i is iterator used as index. 
        //ITERATOR IN SETS IS AS FOLLOWS:
        Iterator it = set.iterator();
        //functions in iterators: hasNext(); and next;
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println("-----HASHMAP-----");
        //HASHMAP - unordered data structure
        //hashmap is a key-value pair where key is unique (non-repeating).
        //value can be repeating (duplicates)
        //rollno(key), student(value)
        HashMap<Integer, String> map = new HashMap<>();

        //insertion
        map.put(1, "akash");
        map.put(2, "anupam"); //here 2 is allocated as anupam
        map.put(2, "samyak"); //since 2 is allocated here as samyak, samyak will replace anupam as 2's value.
        map.put(3, "anant");

        //printing the map. 
        System.out.println(map);
        System.out.println("the above map is unordered(just like hashset).");
        //printing/getting value for a key
        System.out.println(map.get(3));
        System.out.println(map.get(2));

        //searching
        if(map.containsKey(1)){
            System.out.println("yes, key 1 is present");
        }
        if(!map.containsValue("anupam")){
            System.out.println("anupam doesnot exist!!");
        }

        //Iterator for HashMap
        //for (int val:arr)
        for(Map.Entry<Integer, String> val: map.entrySet()){
            System.out.println("key: "+val.getKey() +", value: "+val.getValue());
        }

        //Maintaining a FREQUENCY hashmap with element:frequency format:
        //method 1:
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(A1[i]))
                map.put(A1[i], 1);
            else
                map.put(A1[i], map.get(A1[i]) + 1);
        }
        //Method 2: using getOrDefault:
        for (int i = 0; i < N; i++) {
            map.put(A1[i], map.getOrDefault(A1[i], 0) + 1);
            //map.getOrDefault(key, default value) +1 for ++ increment.
        }

        //iterating Set view of keys of hashmap.
        Set<Integer> keys = map.keySet();
        for(Integer key:keys){
            System.out.println(key +" "+ map.get(key));
        }

        //removing a pair from hashmap: 
        //removing a key removes the whole pair from the map since only value without a key in a map cannot exist. 
        map.remove(3);
        System.out.println(map);

        //hashmap works internally in java by array of linked lists. 
        //one node of any linked list is one key-value pair
        //one array element can contain 1 or more noded linkedlist. 
        
        //put() function: 
        //checks if the key-value pair exists, if yes: updates it, if no: creates and adds new key-value pair. 
        
        //hashing is process of changing form of a human understandable input and outputs a non-understandable output 
        //hashing is internally done through a hash function. 
        //hashing is used to store sensitive data like financial data, passwords etc. 

    }
}
