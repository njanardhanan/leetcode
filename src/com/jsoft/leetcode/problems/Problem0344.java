package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;

public class Problem0344 extends BaseProblem {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] s, int left, int right) {
        char c = s[left];
        s[left] = s[right];
        s[right] = c;
    }

    @Override
    public void solve() {
        String s = "hello";
        char[] c = s.toCharArray();
        reverseString(c);
        System.out.println(c);

        String s1 = "Hannah";
        char[] c1 = s1.toCharArray();
        reverseString(c1);
        System.out.println(c1);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-string/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0344());
    }
}
