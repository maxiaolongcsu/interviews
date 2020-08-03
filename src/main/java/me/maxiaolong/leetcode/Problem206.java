package me.maxiaolong.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maxiaolong
 * created at 2020/7/28
 */
public class Problem206 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(4, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(0, node2);
        ListNode result = doubleReverseListV1(node1);
        while(result!=null){
            System.out.printf("%d ", result.getVal());
            result = result.getNext();
        }
    }

    public static ListNode reverseList(ListNode node){
        if(node == null) return null;
        ListNode p1, p2;
        p1 = null;
        p2 = node;
        while(p2!=null){
            ListNode temp = p2.getNext();
            p2.setNext(p1);
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }

    /**
     * a-b-c-d-e -> b-a-d-c-e
     * @param node
     * @return
     */
    private static ListNode doubleReverseList(ListNode node){
        if(node==null||node.getNext()==null) return node;
        ListNode previous = null;
        ListNode p1 = node;
        ListNode p2 = node.getNext();
        ListNode head = p2;
        while(p1!=null&&p2!=null){
            // 处理
            if(previous!=null)previous.setNext(p2);
            ListNode next = p2.getNext();
            p2.setNext(p1);
            p1.setNext(next);
            // 指针迁移
            previous = p1;
            p1 = p1.getNext();
            p2 = p1==null?null:p1.getNext();
        }
        return head;
    }

    private static ListNode doubleReverseListV1(ListNode node){
        if(node==null||node.getNext()==null) return node;
        ListNode head = node.getNext();
        doubleReverseListV1_(null, node);
        return head;
    }

    private static void doubleReverseListV1_(ListNode previous, ListNode now){
        // 递归终止条件
        if(now==null||now.getNext()==null) return;
        if(previous!=null) previous.setNext(now.getNext());
        ListNode nextNow = now.getNext().getNext();
        now.getNext().setNext(now);
        now.setNext(nextNow);
        doubleReverseListV1_(now, now.getNext());
    }

    private static ListNode reverseListV1(ListNode node1, ListNode node2){
        if(node2 == null) return node1;
        ListNode temp = node2.getNext();
        node2.setNext(node1);
        return reverseListV1(node2, temp);
    }

}

@Data
@AllArgsConstructor
class ListNode{
    private int val;
    private ListNode next;
}