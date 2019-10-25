//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.List;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        P21MergeTwoSortedLists p21 = new P21MergeTwoSortedLists();
        Solution solution = p21.new Solution();
        ListNode l1 = p21.new ListNode(1);
//        l1.next = p21.new ListNode(2);
//        l1.next.next = p21.new ListNode(4);

        ListNode l2 = p21.new ListNode(1);
        l2.next = p21.new ListNode(3);
        l2.next.next = p21.new ListNode(4);

        System.out.println(solution.mergeTwoLists(l1, l2).toString());

        String a = "111";         String b = "111";             String c = b + "";       String d = "111" + "";
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**提交时要注释掉 ListNode，否则会运行失败。
     *
     */
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            if (l1 == null){
                temp = l2;
                l2 = null;
            }else if (l2 == null){
                temp = l1;
                l1 = null;
            }else if (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    temp = l2;
                    l2 = temp.next;
                } else {
                    temp = l1;
                    l1 = temp.next;
                }
            }
            tempResult.next = temp;
            tempResult = tempResult.next;
        }
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}