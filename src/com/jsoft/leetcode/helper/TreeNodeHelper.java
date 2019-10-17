package com.jsoft.leetcode.helper;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeHelper {
    public static TreeNode createTreeNode(int... nums) {
        TreeNode root = null;
        return createTreeLevelOrder(nums, root, 0);
    }

    public static TreeNode createTreeNode(String data) {
        if(data == "") return null;
        String[] vals = data.split(",");
        if(vals.length == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        q.add(root);
        TreeNode p = null;
        String val;
        for(int i = 1; i < vals.length; ) {
            p = q.poll();
            val = vals[i++];
            if(val.equals("null")) {
                p.left = null;
            } else {
                p.left = new TreeNode(Integer.valueOf(val));
                q.add(p.left);
            }
            if(i < vals.length) {
                val = vals[i++];
                if(val.equals("null")) {
                    p.right = null;
                } else {
                    p.right = new TreeNode(Integer.valueOf(val));
                    q.add(p.right);
                }
            }
        }
        return root;
    }

    private static TreeNode createTreeLevelOrder(int[] arr, TreeNode root, int level) {
        if(level < arr.length) {
            root = new TreeNode(arr[level]);
            root.left = createTreeLevelOrder(arr, root.left, 2*level + 1);
            root.right = createTreeLevelOrder(arr, root.right, 2*level + 2);
        }
        return root;
    }

    public static String toString(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        // use tree level order traversal to serialize the tree
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n == null) {
                sb.append("# ");
            } else{
                sb.append(n.val + " ");
                q.add(n.left);
                q.add(n.right);
            }
        }
        return sb.toString().trim();
    }
}
