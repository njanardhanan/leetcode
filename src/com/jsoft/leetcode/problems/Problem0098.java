package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.TreeNode;
import com.jsoft.leetcode.helper.TreeNodeHelper;

/**
 * BST
 * Validate Binary Search Tree
 */
public class Problem0098 extends BaseProblem {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    @Override
    public void solve() {
        TestHelper.test(isValidBST(TreeNodeHelper.createTreeNode("5,1,4,null,null,3,6")), false);
        TestHelper.test(isValidBST(TreeNodeHelper.createTreeNode("2,1,3")), true);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/validate-binary-search-tree/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0098());
    }
}
