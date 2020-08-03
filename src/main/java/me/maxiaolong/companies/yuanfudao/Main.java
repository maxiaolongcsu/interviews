package me.maxiaolong.companies.yuanfudao;

import java.util.*;

/**
 * @author maxiaolong
 * created at 2020/8/1
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Node> map = new TreeMap<>();
        map.put(0, new Node(0, new ArrayList<Node>()));
        int number = sc.nextInt();
        for (int i = 2; i < 2 + number; i++) {
            int value = sc.nextInt();
            int index = sc.nextInt();
            Node tmp = new Node(value, new ArrayList<>());
            map.get(index).next.add(tmp);
            map.put(index, tmp);
        }
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry e: map.entrySet()) {
            Node temp = (Node)e.getValue();

        }
    }
}

class Node{
    public int value;
    public ArrayList<Node> next;

    public Node(int value, ArrayList<Node> next){
        this.value = value;
        this.next = next;
    }
}

