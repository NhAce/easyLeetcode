//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。 
//
// 注意：整数顺序将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：报数
public class P38CountAndSay{
    public static void main(String[] args) {
        Solution solution = new P38CountAndSay().new Solution();
        System.out.println(solution.countAndSay(3));
        StringBuilder sb = new StringBuilder();
        sb.delete(0,1);
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        //速度慢 13ms
//        String str = "1";
//        if (n == 1){
//            return str;
//        }
//        for (int i = 1; i < n; i++) {
//            Character temp = str.charAt(0);
//            int count = 0;
//            String nextNum = "";
//            for (int j = 0; j < str.length(); j++) {
//                char cur = str.charAt(j);
//                if (temp == cur){
//                    count++;
//                }else {
//                    nextNum += count + temp.toString();
//                    temp = cur;
//                    count = 1;
//                }
//            }
//            nextNum += count + temp.toString();
//            str = nextNum;
//        }
//        return str;

        //速度快 1-2ms
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0,ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if(c == currentChar){
                    num++;
                }
                else{
                    ans.append((char)('0'+num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char)('0'+num));
            ans.append(currentChar);

        }

        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}