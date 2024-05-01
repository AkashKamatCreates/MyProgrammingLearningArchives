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
