package basic.sort;

public abstract class SortBase {

    abstract public void sort(int[] nums);

    // 辅助函数
    protected void swap(int[] nums, int s1, int s2){
        int tmp = nums[s1];
        nums[s1] = nums[s2];
        nums[s2] = tmp;
    }

    // 结果输出函数
    public void printNums(int[] nums){
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }





}
