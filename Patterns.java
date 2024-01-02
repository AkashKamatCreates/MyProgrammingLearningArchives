public class pattern {
    public static void main(String[] args) {
        p1(5);
        p2(5);
        p3(5);
        p4(5);
        p5(5);
        p6(5);
        p7(5);
        p8(5);
        p9(5);
        p10(5);
        p11(5);
        p12(5);
        p13(5);
        p14(5);
        p15(5);
        p16(5);
        p17(5);
        p18(5);
        p19(5);
        p20(5);
        p21(5);
    }

    public static void p1(int n){
        System.out.println("Pattern 1: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("o ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p2(int n){
        System.out.println("Pattern 2: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("o ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p3(int n){
        System.out.println("Pattern 3: ");
        for(int i=1; i<n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p4(int n){
        System.out.println("Pattern 4: ");
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void p5(int n){
        System.out.println("Pattern 5: ");
        for(int i=0; i<=n; i++){
            for(int j=n; j>=i; j--){
                System.out.print("o ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p6(int n){
        System.out.println("Pattern 6: ");
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }    
    public static void p7(int n){
        System.out.println("Pattern 7: ");
        for(int i=1; i<=n; i++){
            for(int j=n-1; j>=i; j--){
                System.out.print("  ");
            }
            for(int j=1; j<i+1; j++){
                System.out.print("o ");
                // j=j++;
            }
            for(int j=2; j<i+1; j++){
                System.out.print("o ");
                // j=j++;
            }
            System.out.println("");
        }
        System.out.println();
    }
    public static void p8(int n){
        System.out.println("Pattern 8: ");
        for(int i=0; i<n; i++){
            //spaces:
            for(int j=0; j<i; j++){
                System.out.print("  ");
            }
            for(int j=n; j>=i+1; j--){
                System.out.print("o ");
            }
            for(int j=n; j>=i+2; j--){
                System.out.print("o ");
            }
            System.out.println("");
        }
        System.out.println();
    }
    public static void p9(int n){
        System.out.println("Pattern 9: combination of pattern 7 and 8, up and down pyramids");
        p7(n);
        p8(n);
        System.out.println();
    }
    public static void p10(int n){
        System.out.println("Pattern 10: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("o");
            }
            System.out.println("");

        }
        for(int i=0; i<n-1; i++){
            for(int j=n-1; j>i; j--){
                System.out.print("o");
            }
            System.out.println("");
        }
        System.out.println();
    }
    public static void p11(int n){
        System.out.println("Pattern 11: ");
        int start=1;
        for(int i=0; i<n; i++){
            if(i%2==0) start=1;
            else start=0;
            for(int j=0; j<=i; j++){
                System.out.print(start);
                start=1-start;
            }
            System.out.println("");
        }
        System.out.println();
    }
    public static void p12(int n){
        System.out.println("Pattern 12: ");
        int space = 2*(n-1);
        for(int i=1; i<n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            
            for(int j=1; j<space-1; j++){
                System.out.print("s ");
            }

            for(int j=i; j>=1; j--){
                System.out.print(j+" ");
            }
            space-=2;
            System.out.println("");
        }
        System.out.println();
    }
    public static void p13(int n){
        System.out.println("Pattern 13: ");
        int a = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(a+" ");
                a++;
            }
            System.out.println("");
        }
        System.out.println();
    }
    
    public static void p14(int n){
        System.out.println("Pattern 14: ");
        for(int i=0; i<n; i++){
            for(char ch='A'; ch<='A'+i; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p15(int n){
        System.out.println("Pattern 15: ");
        for(int i=n; i>=0; i--){
            
            for(char ch='A'; ch<='A'+i; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void p16(int n){
        System.out.println("Pattern 16: ");
        char ch = 'A';
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(ch);
            }
            ch++;
            System.out.println();
        }
        System.out.println();
    }
    public static void p17(int n){
        System.out.println("Pattern 17: ");
        for(int i=0; i<n; i++){
            char ch = 'A';
            int breakpoint = (2*i+1)/2;
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=2*i+1; j++){
                System.out.print(ch+" ");
                if(j<=breakpoint) ch++;
                else ch--;
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p18(int n){
        System.out.println("Pattern 18: ");
        
        // for(int i=0; i<n; i++){
        //     char ch = (char)('e'-i);
        //     for(ch = (char)('e'-i); ch>='e'; ch--){
        //         System.out.print(ch);
        //     }
        //     System.out.println();
        // }
        // for (int i = n; i >= 1; i--) {
        //     // Inner loop for printing characters
        //     char currentChar = (char) ('A' + i - 1);
        //     for (int j = n; j >= i; j--) {
        //         System.out.print(currentChar + " ");
        //         currentChar++;
        //     }

        //     // Move to the next line after each row
        //     System.out.println();
        // }


        for(int i=0; i<n; i++){
            // char ch = (char)('a'+i-1);
            for(char ch=(char)('e'-i); ch<='e'; ch++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void p19(int n){
        System.out.println("Pattern 19: ");
        //first half
        for(int i=0; i<n; i++){

            for(int j=i; j<n; j++){
                System.out.print("o ");
            }
            for(int j=0; j<(2*i); j++){
                System.out.print("  ");
            }
            for(int j=i; j<n; j++){
                System.out.print("o ");
            }

            System.out.println();
        }

        //second half
        int sp=8;
        for(int i=0; i<n; i++){
            
            for(int j=0; j<=i; j++){
                System.out.print("o ");
            }
            for(int j=0; j<sp; j++){
                System.out.print("  ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("o ");
            }

            sp-=2;
            System.out.println();
        }
        System.out.println();
    }
    public static void p20(int n){
        System.out.println("Pattern 20: ");
        int sp=8;
        for(int i=0; i<n; i++){
            
            for(int j=0; j<=i; j++){
                System.out.print("o ");
            }
            for(int j=0; j<sp; j++){
                System.out.print("  ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("o ");
            }

            sp-=2;
            System.out.println();
        }

        for(int i=1; i<n; i++){

            for(int j=i; j<n; j++){
                System.out.print("o ");
            }
            for(int j=0; j<(2*i); j++){
                System.out.print("  ");
            }
            for(int j=i; j<n; j++){
                System.out.print("o ");
            }

            System.out.println();
        }
        System.out.println();
    }
    public static void p21(int n){
        System.out.println("Pattern 21: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==(n-1) || j==(n-1)){
                    System.out.print("o ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    } 
}

/*
OUTPUT: 

Pattern 1: 
o o o o o 
o o o o o 
o o o o o 
o o o o o 
o o o o o 

Pattern 2: 
o 
o o 
o o o 
o o o o 
o o o o o 

Pattern 3: 
1
12
123
1234

Pattern 4: 
1
22
333
4444
55555

Pattern 5: 
o o o o o o 
o o o o o 
o o o o 
o o o 
o o 
o 

Pattern 6: 
12345
1234
123
12
1

Pattern 7: 
        o 
      o o o 
    o o o o o 
  o o o o o o o 
o o o o o o o o o 

Pattern 8: 
o o o o o o o o o 
  o o o o o o o 
    o o o o o 
      o o o 
        o 

Pattern 9: combination of pattern 7 and 8, up and down pyramids
Pattern 7: 
        o 
      o o o 
    o o o o o 
  o o o o o o o 
o o o o o o o o o 

Pattern 8: 
o o o o o o o o o 
  o o o o o o o 
    o o o o o 
      o o o 
        o 


Pattern 10: 
o
oo
ooo
oooo
ooooo
oooo
ooo
oo
o

Pattern 11: 
1
01
101
0101
10101

Pattern 12: 
1 s s s s s s 1 
1 2 s s s s 2 1 
1 2 3 s s 3 2 1 
1 2 3 4 4 3 2 1 

Pattern 13: 
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 

Pattern 14: 
A 
A B 
A B C 
A B C D 
A B C D E 

Pattern 15: 
A B C D E F 
A B C D E 
A B C D 
A B C 
A B 
A 

Pattern 16: 
A
BB
CCC
DDDD
EEEEE

Pattern 17: 
        A 
      A B A 
    A B C B A 
  A B C D C B A 
A B C D E D C B A 

Pattern 18: 
e
d
ce
bd
ace

Pattern 19: 
o o o o o o o o o o 
o o o o     o o o o 
o o o         o o o 
o o             o o 
o                 o 
o                 o 
o o             o o 
o o o         o o o 
o o o o     o o o o 
o o o o o o o o o o 

Pattern 20: 
o                 o 
o o             o o 
o o o         o o o 
o o o o     o o o o 
o o o o o o o o o o 
o o o o     o o o o 
o o o         o o o 
o o             o o 
o                 o 

Pattern 21: 
o o o o o 
o       o 
o       o 
o       o 
o o o o o 
 */


