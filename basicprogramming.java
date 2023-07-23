public class basicprogramming {
    public static void main(String[] args) {

        //Basic Programming: This code contains all basic programming problems like:
        /*
         * 1. fibonacci 
         * 2. prime no
         * 3. reverse
         * 4. armstrong
         * 5. factorial
         * 6. palindrome
         */

        System.out.println(fibonacci(5));
        System.out.println(prime(3));
        System.out.println(reverse(123456));
        System.out.println(armstrong(1634));
        System.out.println(factorial(5));
        System.out.println(palindrome("madam"));

    }

    static int fibonacci(int n){
        if(n<=1) return n;
        return(fibonacci(n-1)+fibonacci(n-2));
    }
    
    static boolean prime(int n){
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
    static int reverse(int n){
        int reverse=0; 
        while(n>0){
            int lastdigit = n%10;
            reverse = reverse*10 + lastdigit;
            n=n/10;
        }
        return reverse;
    }
    
    static boolean armstrong(int n){
        int sum = 0;
        int power = 0;
        while(n>0){
            n=n/10;
            power+=1;
        }
        while(n>0){
            int lastdigit = n%10;
            sum += Math.pow(lastdigit, power);
            n=n/10;
        }
        if(sum==n){
            return true;
        }
        return false;
    }
    
    static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    static boolean palindrome(String n){
        int i=0, j=n.length()-1;
        while(i<j){
            if(n.charAt(i)!=n.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
