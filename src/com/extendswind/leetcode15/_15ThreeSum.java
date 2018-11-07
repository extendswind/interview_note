package com.extendswind.leetcode15;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */


/**  c++ version
class Solution {
    public:

    vector<vector<int>> threeSum(vector<int>&nums) {
        if (nums.size() < 3)
            return vector < vector < int>>{
        }
        ;

        sort(nums.begin(), nums.end());
        set<vector<int>> setResult;
        for (int i = 0; i < nums.size() - 2; i++) {
            int front = i + 1;
            int back = nums.size() - 1;
            //    cout << back <<endl;

            while (front != back) {
                // cout<<i<<" "<<front<<" "<<back<<" "<<endl;
                int sum = nums[front] + nums[back] + nums[i];
                if (sum > 0)
                    back--;
                else if (sum < 0)
                    front++;
                else {
                    vector<int> threeElements =
                            vector < int>{
                        nums[i], nums[front], nums[back]
                    } ;
                    //        sort(threeElements.begin(), threeElements.end());
                    setResult.insert(threeElements);
                    front++;
                }
            }
        }
        vector<vector<int>> result (setResult.begin(), setResult.end());
        return result;


    }
};
 */

public class _15ThreeSum {
}


/*
直接使用穷举会超时，在对两个元素的和进行检查时，先排序然后通过首尾指针的方式能将找到两个数的复杂度降低到O(n)
 */
