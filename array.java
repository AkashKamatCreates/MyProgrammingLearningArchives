import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Basics of arrays in java
        
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(); //taking array size from user
        int n = 10; //size of array declared instead of taking from user 
        int[] arrname = new int[n];
        System.out.println(Arrays.toString(arrname));

        //by default int array stores 0 in all elements memory space, string stores empty string " ", float stores 0.0, boolean stores false and so on. 
        //array elements are stored in contigious manner in the memory (one after the other).
        
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //LINEAR SEARCH IN ARRAYS: simply traverse through array, if key==arr[i], return i as the position of found key.
        
        
        public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
        }    
        public static void main(String a[]){    
            int[] a1= {10,20,30,50,70,90};    
            int key = 50;    
            System.out.println(key+" is found at index: "+linearSearch(a1, key));    
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------      
    }
}
