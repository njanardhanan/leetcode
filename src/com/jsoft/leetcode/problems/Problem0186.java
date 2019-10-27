package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.Arrays;
import java.util.Collections;

/**
 * String
 * reverse
 * words
 */
public class Problem0186 extends BaseProblem {

    public void reverseWords(char[] s) {
        reverseString(s, 0, s.length-1);
        int left = 0;
        for(int right=0; right<s.length; right++) {
            if(s[right] == ' ') {
                reverseString(s, left, right-1);
                left = right + 1;
            }
        }
        reverseString(s, left, s.length-1);
    }

    public void reverseWords1(char[] s) {
        reverseString(s, 0, s.length-1);
        int left = 0;
        int right = 0;
        while(right < s.length) {
            //Move right to space, i.e, find the word.
            while(right < s.length && s[right] != ' ') right++;

            //reverse the last word and break
            if(right >= s.length) {
                reverseString(s, left, s.length-1);
                break;
            }

            //revere the word
            reverseString(s, left, right-1);

            right++;
            left = right;
        }
        System.out.println(Arrays.toString(s));
    }

    private void reverseString(char[] s, int left, int right) {
        while(left < right) {
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }

    @Override
    public void solve() {
        char[] w1 = "the sky is blue".toCharArray();
        reverseWords(w1);
        System.out.println(Arrays.toString(w1));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-words-in-a-string-ii/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0186());
    }
}
