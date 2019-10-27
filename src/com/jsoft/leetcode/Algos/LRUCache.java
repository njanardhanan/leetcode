package com.jsoft.leetcode.Algos;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
    }

    ListNode head, tail;
    Map<Integer, ListNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    //Always add after head
    private void addNode(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    //Remove the given node.
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //Move the given node to head.
    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    //Remove the node before tail.
    private ListNode popTail() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.get(key).value = value;
            moveToHead(cache.get(key));
        } else {
            ListNode node = new ListNode();
            node.key = key;
            node.value = value;
            addNode(node);

            cache.put(key, node);

            if(cache.size() > capacity) {
                ListNode n = popTail();
                cache.remove(n.key);
            }
        }
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
}