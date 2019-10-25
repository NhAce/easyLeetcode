//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 1: 
//
// 给定 nums = [3,2,2,3], val = 3,
//
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2: 
//
// 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//注意这五个元素可为任意顺序。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;
//Java：移除元素
public class P27RemoveElement{
    public static void main(String[] args) {
        Solution solution = new P27RemoveElement().new Solution();
        int[] nums = {2,2,2,2,2,3};
        int size = solution.removeElement(nums, 2);
        System.out.println("new size is: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
        // TO TEST
    }

    /**
     * 官网解法：当遇到等于 val 的元素时，把当前元素和最后一个元素互换，并释放最后一个元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val){
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        //使用双指针: i, j
        //j 进行快循环，定位到不同于 val 的元素的地址
        //i 进行慢累加，从第一个元素开始给数组重新赋值，新值就是不同于 val 的元素
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
               nums[i] = nums[j];
               i++;
            }
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}