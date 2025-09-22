package Labuladong.TwoPointer;

import java.util.Objects;

class ListNode {
      int val;
      ListNode next;


  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }

  ListNode() {
      }
      ListNode(int val) {
        this.val = val;
      }
      ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
      }

  public static ListNode of(int... values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
          current.next = new ListNode(values[i]); current = current.next;
        }
        return head;
      }
}

public class Leetcode21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    ListNode p1 = list1, p2 = list2;

    while (p1 != null && p2 != null){
      if(p1.val < p2.val){
        p.next = p1;
        p1 = p1.next;
      }else{
        p.next = p2;
        p2 = p2.next;
      }
      //我漏写了这一步
      //因为判断下一个p的节点之后需要移动到下一个位置进行后续的遍历
      p = p.next;
    }

    //三元运算符
    //如果p1不等于null的话，则代表它后续还有节点需要被连接
    p.next = (p1 != null) ? p1 : p2;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode p1 = ListNode.of(1,3,8,9);
    ListNode p2 = ListNode.of(2,4);
    System.out.println(new Leetcode21().mergeTwoLists(p1, p2));
    
  }
}
