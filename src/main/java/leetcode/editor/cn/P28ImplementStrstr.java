//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

package leetcode.editor.cn;
//Java：实现 strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        System.out.println(solution.strStr("a", "a"));
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        // ==========强行遍历==========
//        if (needle == null || "".equals(needle)){
//            return 0;
//        }
//        int m = haystack.length();
//        int n = needle.length();
//        if (m < n){
//            return -1;
//        }
//        for (int i = 0; i <= m - n; i++) {
//            int j = 0;
//            for (j = 0; j < n; j++) {
//                if (needle.charAt(j) != haystack.charAt(i + j)){
//                    break;
//                }
//            }
//            if (j == n){
//                return i;
//            }
//        }
//        return -1;

        // 使用 KMP 算法
        if (needle == null || "".equals(needle)){
            return 0;
        }
        Kmp kmp = new Kmp(needle);
        return kmp.search(haystack);

        // 直接返回 haystack.indexOf(needle)
    }

    class Kmp{
        private int[][] dp;
        private String pat;

        public Kmp(String pat){
            this.pat = pat;
            int m = pat.length();
            // dp[状态][字符] = 下个状态
            dp = new int[m][256];
            // 初始化
            dp[0][pat.charAt(0)] = 1;
            // 影子状态，初始为 0
            int x = 0;
            for (int j = 1; j < m; j++) {
                for (int c = 0; c < 256; c++) {
                    dp[j][c] = dp[x][c];
                }
                dp[j][pat.charAt(j)] = j + 1;
                // 更新影子状态
                x = dp[x][pat.charAt(j)];
            }
        }

        public int search(String txt){
            int m = pat.length();
            int n = txt.length();
            int j = 0;
            for (int i = 0; i < n; i++) {
                j = dp[j][txt.charAt(i)];
                if (j == m) {
                    return i - m + 1;
                }
            }
            return -1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}