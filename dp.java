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
public int frogJump(int[] heights){
    int n = heights.length;
    int[] dp = new int[n];
    
    //instantiating height diff for getting to first from first. 
    dp[0]=0;
    
    for(int i=1; i<=n; i++){
    	int jumpOne = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
    	
    	int jumpTwo = Integer.MAX_VALUE;
        if (i > 1) {
            jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
        }
    	dp[i] = Math.min(jumpOne, jumpTwo);
    }
    return dp[n];
}

//top down memoisation:
public int frogJumpk(int[] heights, int[] dp, int n){
	if(n==0) return 0;
	
	if(dp[n]!=-1) return dp[n];
	int result = Integer.MIN_VALUE;
	
	for(int i=1; i<=n; i++){
		int jump = frogJumpk(heights, dp, n-i)+Math.abs(heights[n]-heights[n-i]);
		result = Math.min(result, jump);
	}
	return dp[n] = result;
}

//bottom up solution:
public int frogJumpk(int[] height){
	int n = height.length;
	int[] dp = new int[n];
	
	dp[0] = 0;
	
	int min = Integer.MAX_VALUE;
	
	for (int i = 1; i < n; i++) {
        	int min = Integer.MAX_VALUE;
        
        	// try jumping from all previous stones
        	for (int j = 1; j <= i; j++) {
        		int jumpCost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
            		min = Math.min(min, jumpCost);
        	}

        	dp[i] = min;
    	}
    	
    	return dp[n-1];
	
}

//house robber question
//top down
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Case 1: Rob from house 0 to n-2
        int rob1 = robHelper(nums, 0, n - 2, dp1);
        // Case 2: Rob from house 1 to n-1
        int rob2 = robHelper(nums, 1, n - 1, dp2);

        return Math.max(rob1, rob2);
    }

    private int robHelper(int[] nums, int start, int end, int[] dp) {
        if (start > end) return 0;
        if (dp[start] != -1) return dp[start];

        int robCurrent = nums[start] + robHelper(nums, start + 2, end, dp);
        int skipCurrent = robHelper(nums, start + 1, end, dp);

        dp[start] = Math.max(robCurrent, skipCurrent);
        return dp[start];
    }
}

//bottom up solution:
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: rob houses from 0 to n - 2
        int rob1 = robLinear(nums, 0, n - 2);
        // Case 2: rob houses from 1 to n - 1
        int rob2 = robLinear(nums, 1, n - 1);

        return Math.max(rob1, rob2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i - 2]
        int prev1 = 0; // dp[i - 1]

        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;

            int curr = Math.max(take, skip);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

























