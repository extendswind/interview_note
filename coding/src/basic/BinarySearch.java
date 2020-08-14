package basic;

import org.junit.Assert;

public class BinarySearch {

    /**
     * 二分查找
     * 如果没找到返回-1
     * 如果找到返回下标
     */
    public int binarySearch(int[] nums, int num){

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = (right - left)/2 + left;  // 为了避免left+right数字超过int范围
            if(nums[mid] == num)
                return mid;
            if(nums[mid] > num){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] argvs){
        BinarySearch bs = new BinarySearch();
        int[] nums = {1,2,4,5,8,9};
        Assert.assertEquals(bs.binarySearch(nums, 2), 1);
        Assert.assertEquals(bs.binarySearch(nums, 4), 2);
        Assert.assertEquals(bs.binarySearch(nums, 3), -1);
    }
}
