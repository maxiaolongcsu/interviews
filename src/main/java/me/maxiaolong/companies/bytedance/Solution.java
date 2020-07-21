package me.maxiaolong.companies.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maxiaolong
 * created at 2020/7/8
 */
public class Solution {

    public static void main(String[] args) {
        Node node4 = new Node(null, null, 4);
        Node node3 = new Node(null, null, 3);
        Node node2 = new Node(null, node4, 2);
        Node node1 = new Node(node3, null, 1);
        Node node0 = new Node(node1, node2, 0);
        orderRightestNode(node0);
    }

    public static void orderRightestNode(Node root){
        if(root==null) {
            return;
        }else{
            Queue<Object> queue = new LinkedList();
            int layer = 0;
            queue.add(root);
            queue.add(layer);
            // 上个节点的信息
            int lastLayer = 0;
            Node lastNode = root;
            while(!queue.isEmpty()){
                Node tmpNode = (Node)queue.poll();
                int tmpLayer = (int)queue.poll();
                if(tmpLayer!=lastLayer){
                    System.out.printf("%d ", lastNode.getValue());
                }
                if(tmpNode.getLeftNode()!=null){
                    queue.add(tmpNode.getLeftNode());
                    queue.add(tmpLayer+1);
                }
                if(tmpNode.getRightNode()!=null){
                    queue.add(tmpNode.getRightNode());
                    queue.add(tmpLayer+1);
                }
                lastLayer = tmpLayer;
                lastNode = tmpNode;
            }
            System.out.printf("%d ", lastNode.getValue());
        }
    }
}

class Node{
    private Node leftNode;
    private Node rightNode;
    private int value;

    Node(Node leftNode, Node rightNode, int value){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    Node(int value){
        this.leftNode = null;
        this.rightNode = null;
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
