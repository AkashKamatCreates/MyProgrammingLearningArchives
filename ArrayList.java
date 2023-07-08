import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //syntax to declare and add elements to arraylist:
        ArrayList<Integer> akash = new ArrayList<Integer>();
        akash.add(13);
        akash.add(24);
        akash.add(36);

        System.out.println(akash);

      

        //using arraylist as normal array: specify the size of the arraylist in the brackets...

        ArrayList<Integer> akash = new ArrayList<Integer>(10); //this will act as a normal array  with 10 size
        ArrayList<Integer> akash = new ArrayList<Integer>(n);  //this will act as normal array with size n

        // watch for more:         https://www.youtube.com/watch?v=liFyhzZl9uw

    }
}
