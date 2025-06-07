class dp{
  fibonacci code recursive: 

public int fib(int x){
    if(x==0) return 0; 
    if(x==1) return 1;

    return fib(x-1)+fib(x-2);
}

fibonacci code top down: 

public int fib(int x, int dp[]){
    if(x==0) return 0; 
    if(x==1) return 1;
    
    if(dp[x]!=-1) return dp[x];
    dp[x] =  fib(x-1, dp)+fib(x-2, dp);
    return dp[x];
}

fibonacci code bottom up: 

public int fib(int x){
    int first = 0;
    int second = 1;

    int ans = 0;
    for(int i=2; i<=x; i++){
        ans = first+second;
        first = second;
        second = ans;
    }
    return ans;
}

//climbing stairs:
//recursive
given n last step, how many ways can i climb if 1 or 2 steps at a time
public int climbStairs(int n) {
    if(n<0) return 0;
    if(n==0) return 1;
    
    int one = climbStairs(n-1);
    int two = climbStairs(n-2);

    return one+two;
}

// top down 
public int climbStairs(int n, int[] dp){
    if(n<0) return 0;
    if(n==0) return 1;

    if(dp[n]!=-1) return dp[n];

    dp[n] = climbStairs(n-1, dp)+climbStairs(n-2, dp);
    return dp[n];
}

//bottom up
public int climbStairs(int n, int[] dp){
    
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2; i<=n; i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
    // for more space optimized approach, remove the dp array, use first, 
    //second and ans variable just like fibonacci. this problem solution 
    // is fibonacci. 
}
notes: 
top down has recursion and so it should have base case
bottom up doesnt have recursion so skip the base case. 

//recursive code:
public int frogJump(int n, int[] heights) {
    int n = heights.length; //if not in method signature
    
    //base case:
    if(n==0) return 0;
    if(n<0) return 0;

    int jumpOne = frogJump(n-1, heights) + Math.abs(heights[n]-heights[n-1]);
    int jumpTwo = Integer.MAX_VALUE;
    if(n>1){
        jumptwo = frogJump(n-2, heights) + Math.abs(heights[n]-heights[n-2]);    
    }
    
    return Math.min(jumpOne, jumpTwo);
}

//top down
public int frogJump(int n, int[] heights, int[] dp){
    if(n==0) return 0;

    if(dp[n]!=-1){
        return dp[n];    
    }

    int jumpOne = frogJump(n-1, heights, dp) + Math.abs(heights[n]-heights[n-1]);
    int jumpTwo = Integer.MAX_VALUE;
    if(n>1){
        jumpTwo = frogJump(n-2, heights, dp) + Math.abs(heights[n]-heights[n-2]);
    }

    dp[n] = Math.min(jumpOne, jumpTwo);
    return dp[n];
}

//bottom up: -------------------------------------------------------------------------
public int frogJump(int n, int[] heights, int[] dp){
    int dp[0] = heights[0];
    int second= dp[1];
    int ans = Integer.MAX_VALUE;

    for(int i=0; i<=n; i++){
        ans =dp[n]+ Math.min(first, second);
        first = second;
        second = ans;
    }

    return second;
    
}

}
