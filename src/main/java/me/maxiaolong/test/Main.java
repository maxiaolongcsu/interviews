package me.maxiaolong.test;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(15));
    }

    // HashMap：找到最近的2^n的数字
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    public void printZBinaryTree(Node node){
        if(node==null) return;
        Queue<Node> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.add(node);
        List<Node> tempList = new ArrayList<>();
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            tempList.add(temp);
            if(queue.isEmpty()){
                if(leftToRight){
                    for (int i = 0; i < tempList.size(); i++) {
                        if(tempList.get(i).left!=null)   queue.add(tempList.get(i).left);
                        if(tempList.get(i).right!=null)   queue.add(tempList.get(i).right);
                        System.out.printf("%n ", tempList.get(i).value);
                    }
                }else{
                    for (int i = tempList.size() - 1; i >= 0; i--) {
                        if(tempList.get(i).left!=null)   queue.add(tempList.get(i).left);
                        if(tempList.get(i).right!=null)   queue.add(tempList.get(i).right);
                        System.out.printf("%n ", tempList.get(i).value);
                    }
                }
                leftToRight = !leftToRight;
            }
        }
    }

    @AllArgsConstructor
    class Node{
        public int value;
        public Node left,right;
        public Node(int value){
            this.value = value;
            left=right=null;
        }
    }
}
