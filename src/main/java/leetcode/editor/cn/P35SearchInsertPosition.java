//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
//Java：搜索插入位置
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        int[] nums = {4};
        System.out.println(solution.searchInsert(nums, 5));
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 暴力遍历法
//        int num = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= target){
//                return i;
//            }else if (nums[i] < target){
//                num = i + 1;
//            }
//        }
//        return num;

        // 二分法
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (target > nums[len - 1]){
            return len;
        }
        int left = 0;
        int right = len;
        // 退出循环时，必定有 left == right
        while (left < right){
            // 无符号右移，即使 left + right > Integer.MAX_VALUE 也不影响
            // 取的是左中位数，所以要保证循环中 left 的值会发生变化，即 left = mid + 1，否则可能会出现死循环
            int mid = (left + right) >>> 1;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}