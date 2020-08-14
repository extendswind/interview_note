package codingInterviews;

import java.util.HashSet;

class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == i)
                continue;
            if(nums[i] == nums[nums[i]])
                return nums[i];
            else{
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        return -1;
    }

    public int findRepeatNumber_hash(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i :nums){
            if(hashSet.add(i) == false){
                return i;
            }
        }
        return -1;
    }
}

public class _3FindRepeatNum {
    public static void main(String[] argvs){
        Solution s = new Solution();
        int[] nums = {1,2,3,4,3};
        System.out.println(s.findRepeatNumber(nums));


    }
}
