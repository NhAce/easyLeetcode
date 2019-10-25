//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：最长公共前缀
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String aa[] = {"a", "b", "c"};
//        System.out.println(solution.longestCommonPrefix(aa));
        System.out.println(aa[0].substring(0, 0));

        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
//        if (strs != null && strs.length > 0) {
            String str1 = strs[0];
            for (int i = str1.length(); i >= 0; i--) {
                boolean flag = true;
                String p = str1.substring(0, i);
                if (strs.length > 0) {
                    for (int j = 1; j < strs.length; j++) {
                        if (!strs[j].startsWith(p)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return p;
                    }
                } else {
                    return str1;
                }
            }
//        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}