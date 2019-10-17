package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.TreeNode;
import com.jsoft.leetcode.helper.TreeNodeHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BST
 * Binary Search Tree
 * Level Order Traversal
 */
public class Problem0102 extends BaseProblem {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    @Override
    public void solve() {
        System.out.println(levelOrder(TreeNodeHelper.createTreeNode("3,9,20,null,null,15,7")));
        System.out.println(levelOrder(TreeNodeHelper.createTreeNode("1,2,3")));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/validate-binary-search-tree/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0102());
    }
}
