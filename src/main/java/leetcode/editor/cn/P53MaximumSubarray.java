//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package leetcode.editor.cn;
//Java：最大子序和
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        System.out.println((Integer.MAX_VALUE));
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0){
                // sum > 0 时，sum + num 必然 > num，所以最大值是 sum + num
                sum += num;
            }else {
                // sum <= 0 时，sum + num 必然 <= num，所以最大值是 num
                sum = num;
            }
            // 用新的 sum 和上一轮 sum、num 的最大值做比较，找出新的最大值
            temp = Math.max(temp, sum);
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}