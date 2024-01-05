// class Solution {
//     private class NumWithIndex {
//         int num;
//         int index;
        
//         public NumWithIndex(int num, int index) {
//             this.num = num;
//             this.index = index;
//         }
//     }
    
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         NumWithIndex[] numsWithIndices = new NumWithIndex[n];
        
//         for (int i = 0; i < n; i++) {
//             numsWithIndices[i] = new NumWithIndex(nums[i], i);
//         }
        
//         Arrays.sort(numsWithIndices, (a, b) -> Integer.compare(a.num, b.num));
        
//         int left = 0, right = n - 1;
//         while (left < right) {
//             int sum = numsWithIndices[left].num + numsWithIndices[right].num;
//             if (sum == target) {
//                 return new int[] {numsWithIndices[left].index, numsWithIndices[right].index};
//             } else if (sum < target) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }
        
//         return new int[] {-1, -1}; 
//     }
// }

// class Solution{
//     public int[] twoSum(int[] nums, int target){
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<nums.length; i++){
//             if(map.containsKey(target-nums[i]))return new int[] {i, map.get(target-nums[i])};
//             map.put(nums[i], i);

//         }
//         return new int[] {};
//     }
// }
/* Optimal solution: HashMap o(n*logn) (best for this problem where you output the indices for the answer in a array)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int answer = target - num;
            if(map.containsKey(answer)){
                return new int[] {i, map.get(answer)};
            }
            map.put(nums[i], i);
        }
        return new int[] {}; 
    }
}
*/


/* Bruteforce solution: n^2
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        int[] answer;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i, j};
                }
            }
        }
        
    }
}
*/
//practice: bruteforce
// class Solution{
//     public int[] twoSum(int[] nums, int target){
//         int n = nums.length;
//         int[] ans = new int[2];
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if((nums[i]+nums[j])==target && i!=j){
//                     ans[0]=j;
//                     ans[1]=i;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// class Solution{
//     public int[] twoSum(int[] nums, int target){
//         int n=nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int i=0; i<n; i++){
//             int answer = target-nums[i];
//             if(map.containsKey(answer)){
//                 return new int[] {i, map.get(answer)};
//             }
//             map.put(nums[i], i);

//         }

//         return new int[]{};
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 1; i < nums.length; i++){
            for(int x = i; x < nums.length; x++){
                if (nums[x] + nums[x - i] == target){
                    int[] answer = new int[]{x,x - i};
                    return answer;
                }
            }
        }
        return null;
    }
}
