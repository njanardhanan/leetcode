package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

/**
 * String Reverse
 */
public class Problem0557 extends BaseProblem {

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        for(int right = 1; right<chars.length; right++) {
            if(chars[right] == ' ') {
                reverse(chars, left, right-1);
                left = right + 1;
                right++;
            }
        }
        reverse(chars, left, chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] c, int from, int to) {
        while(from<to) {
            char t = c[from];
            c[from++] = c[to];
            c[to--] = t;
        }
    }

    @Override
    public void solve() {
        TestHelper.test(reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc");
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-words-in-a-string-iii/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0557());
    }
}
