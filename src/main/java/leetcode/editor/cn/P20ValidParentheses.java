//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[{()}]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：有效的括号
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid(""));
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if ("".equals(s)){
            return true;
        }
        if ( s != null || (s.length() % 2 != 0)){
            return false;
        }
        int index = 0;
        //用数组模拟栈，检测到闭括号时，去匹配栈顶的元素
        //匹配失败，直接返回 false
        //匹配成功，把栈顶指针往前移一位
        char[] stack = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack[index++] = c;continue;
                case ')':
                    if (index == 0 || stack[--index] != '('){
                        return false;
                    }
                    continue;
                case '}':
                    if (index == 0 || stack[--index] != '{'){
                        return false;
                    }
                    continue;
                case ']':
                    if (index == 0 || stack[--index] != '['){
                        return false;
                    }
                    continue;
            }
        }
        return index == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}