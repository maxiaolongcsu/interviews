package me.maxiaolong.leetcode;

import java.util.HashMap;

/**
 * 最近最少使用：使用哈希双向链表实现
 * get(key), put(key, value)
 * @author maxiaolong
 * created at 2020/7/29
 */
public class LRUCache {
    class Node {
        public int key, value;
        public Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) head = tail = node;
            else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size += 1;
        }

        /**
         * 链表删除O(1)
         *
         * @param node
         */
        public void remove(Node node) {
            if (head == node && tail == node) head = tail = null;
            else if (tail == node) {
                tail = node.prev;
                node.prev.next = null;
            } else if (head == node){
                head = node.next;
                node.next.prev = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        /**
         * 删除并返回Node
         * @return
         */
        public Node removeLast(){
            Node node = tail;
            remove(node);
            return node;
        }

        public int size(){
            return size;
        }
    }

    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int cap){
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        int value = map.get(key).value;
        // 放在最前面
        put(key,value);
        return value;
    }

    public void put(int key, int value){
        Node node = new Node(key, value);

        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        }else{
            // 满了进行删除
            if(cap == cache.size){
                // 获得双向链表中的key
                Node tail = cache.removeLast();
                map.remove(tail.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }
}
