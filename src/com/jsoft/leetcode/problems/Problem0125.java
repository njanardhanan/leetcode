package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

/**
 * Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Problem0125 extends BaseProblem {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        int i = 0;
        int j = len-1;
        while(i<=j) {
            if(!Character.isAlphabetic(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isAlphabetic(s.charAt(j))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Override
    public void solve() {
        TestHelper.test(isPalindrome("A man, a plan, a canal: Panama"), true);
        TestHelper.test(isPalindrome("race a car"), false);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/valid-palindrome/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0125());
    }
}
