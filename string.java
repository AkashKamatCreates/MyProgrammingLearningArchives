import java.util.*;
public class string {
    public static void main(String[] args) {

        
        //Declaration of string
        String name = "akash";
        String fullname = "akash kamat"; //space is a valid character in a string.

        
        //taking string input from user
        /*
         * Scanner in = new Scanner(System.in);
           String nam = in.nextLine();
           System.out.println("your name is "+name);
         */

        
        //concatenation: joining two strings. 
        String firstname = "akash";
        String lastname = "kamat";
        String fullnname = firstname+" "+lastname;
        System.out.println(fullnname);

        
        //length of string
        System.out.println(fullname.length());

        
        //charAt and iterating through String
        for (int i = 0; i < fullname.length(); i++) {
            System.out.println(fullname.charAt(i));
        }

        
        //comparing two strings
        String s1 = "thisisstring";
        String s2 = "thisisstring";
        //using .equals
        if(s1.equals(s2)){
            System.out.println("yes, s1 and s2 are equal");
        }
        //using .contentEquals
        if(s1.contentEquals(s2)){
            System.out.println("yes, s1 and s2 are same");
        }
        // == can work but in many test cases in the questions, s1==s2 may not work which is why content.Equals and .equals should be used. 

        
        //substrings: 
        String sen = "hello, this is akash kamat!";
        String subsen = sen.substring(3, 22); //(starting index, ending index)
        System.out.println(subsen);
        String subs = sen.substring(4); // here string will be from 6th index to the end. end is not specified so string length is the end. 
        System.out.println(subs);

        //Strings are immutable i.e., nothing can be added or deleted in the string once the string is made. 
        /*StringBuilder are used to counter the above con of strings. 
         * stringbuilder works as a string but they are mutable and are more efficient than string for update, delete, addition operations. 
         * 
         * in case of string, in the heap, if h is string and we want to make it hi, a new memory hi is created and old h is deleted. 
         * this causes very bad efficiency for strings which stringbuilder solves by converting the h into hi without adding or deleting anything from the memory. 
         */

        
        //StringBuilder declaration
        StringBuilder sb = new StringBuilder("aa");
        System.out.println(sb);

        //length of the stringbuilder
        System.out.println(sb.length());

        //char at index
        System.out.println(sb.charAt(1));

        //set char at index
        sb.setCharAt(1, 'k');//here "a" wont work, only single quotations!!!
        System.out.println(sb);

        //insert characters at index
        sb.insert(2, "a"); // at index 2, insert a and shift all the rest of the string to one place right. 
        sb.insert(3, "s");
        sb.insert(4, "h");
        System.out.println(sb);

        //append oprations: insert chars at the end of the string
        StringBuilder na = new StringBuilder("a");
        System.out.println(na);
        na.append("k");
        System.out.println(na);
        na.append("a");
        System.out.println(na);
        na.append("s");
        System.out.println(na);
        na.append("h");
        System.out.println(na);

        //delete operation
        StringBuilder sa = new StringBuilder("I am practicing Strings!!! :)");
        sa.delete(8, 16); //(start index, end index) to be deleted.
        System.out.println(sa);

        //string function: 
        String temp = "1234";
        String temp2 = "2";
        System.out.println("sum of two strings is: "+ (Integer.parseInt(temp)+Integer.parseInt(temp2))); //output: 1236
    


        
    }
}
