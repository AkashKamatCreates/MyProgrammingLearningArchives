# Important Codes

## Recursive code for printing all subsequence of a String: 
```Java
public class Recursion6 {
    public static void main(String[] args) {
        String s="abcd";
        char[] c=s.toCharArray();
        print_string_subseq(new ArrayList<>(),0,c,s.length());
    }


    public static void print_string_subseq(ArrayList<Character> al,int ind,char[] c,int n)
    {
        if(ind>=n)
        {
            if(al.size()==0)
                System.out.print("{}");

            for(char t:al)
            {
                System.out.print(t);
            }
            System.out.println();
            return;

        }
        print_string_subseq(al,ind+1,c,n);
        al.add(c[ind]);
        print_string_subseq(al,ind+1,c,n);
        al.remove(al.size()-1);
    }
}

```

## sum of subsequence using recursion: 
```
package org.example;

import java.util.ArrayList;

public class recursion7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int n = 3;
        int s = 2;
        ArrayList<Integer> list = new ArrayList<>();


        subsequencesum(0, list, 0, s, arr, n);

    }

    static void subsequencesum(int i, ArrayList<Integer> list, int s, int sum, int[] arr, int n){
        if(i==n){
            if(s==sum){
                for(Integer x:list){
                    System.out.print(x+" ");
                }
                System.out.println();
            }
            return;
        }

        list.add(arr[i]);
        s+=arr[i];
        subsequencesum(i+1, list, s, sum, arr, n);

        list.remove(list.size()-1);
        s-=arr[i];
        subsequencesum(i+1, list, s, sum, arr, n);

    }
}

```

