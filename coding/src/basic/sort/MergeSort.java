package basic.sort;

public class MergeSort extends SortBase {

    public void sort(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tmp);
    }

    // 基本按《算法导论》思路
    // merge过程先将左右两个数组复制到新的数组，然后根据新的数组比大小赋值到原数组
    // 下面的判断条件略不优雅....
    private void mergeSort(int[] nums, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid, tmp);
            mergeSort(nums, mid + 1, end, tmp);

            // merge
            System.arraycopy(nums, start, tmp, start, mid - start + 1);
            System.arraycopy(nums, mid + 1, tmp, mid + 1, end - mid);
            int left = start;
            int right = mid + 1;
            for (int i = start; i <= end; i++) {
                // 这个判断条件略坑....
                // 最明了的解决方案还是上面的左右两个数组后都加入一个标记数字
                // 但加标记数的方式需要数组额外1的空间稍多几步数组之间的下标处理
                if ((right > end) || ((left <= mid) && (tmp[left] <= tmp[right]))) {
                    nums[i] = tmp[left];
                    left++;
                }
                else {
                    nums[i] = tmp[right];
                    right++;
                }
            }
        }
    }

    // -------------------------------------------------
    // 基本按《算法导论》思路
    // merge过程先将左右两个数组复制到两个新的数组，然后根据新的数组比大小赋值到原数组
    // 和上面的方法比，由于每个数组多申请了1个元素，可以作为最后的标记，因此避免了麻烦的判断条件
    public void sort2(int[] nums) {
        int[] tmp = new int[nums.length/2 + 2];
        int[] tmp2 = new int[nums.length/2 + 1];
        mergeSort(nums, 0, nums.length - 1, tmp, tmp2);
    }
   private void mergeSort(int[] nums, int start, int end, int[] tmp, int[] tmp2) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid, tmp, tmp2);
            mergeSort(nums, mid + 1, end, tmp, tmp2);

            // merge
            System.arraycopy(nums, start, tmp, 0, mid - start + 1);
            System.arraycopy(nums, mid + 1, tmp2, 0, end - mid);
            tmp[mid-start + 1] = Integer.MAX_VALUE;
            tmp2[end-mid] = Integer.MAX_VALUE;

            int left = 0;
            int right = 0;
            for (int i = start; i <= end; i++) {
                // 这个判断条件略坑....
                // 最明了的解决方案还是上面的左右两个数组后都加入一个标记数字
                // 但加标记数的方式需要数组额外1的空间稍多几步数组之间的下标处理
                if (tmp[left] <= tmp2[right]) {
                    nums[i] = tmp[left];
                    left++;
                }
                else {
                    nums[i] = tmp2[right];
                    right++;
                }
            }
        }
    }

    public static void main(String[] argvs) {
        int[] nums = {2, 3, 9, 4, 3, 2, 1, 4, 5, 6, 11, 22, 13};
        MergeSort s = new MergeSort();
        s.sort2(nums);
        s.printNums(nums);
    }
}
