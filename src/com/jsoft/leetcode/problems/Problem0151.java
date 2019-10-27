package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * String
 * reverse
 * words
 */
public class Problem0151 extends BaseProblem {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            sb.append(words[i].trim());
            if(i != 0) sb.append(' ');
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    @Override
    public void solve() {
        TestHelper.test(reverseWords("a good   example"), "example good a");
        TestHelper.test(reverseWords("  hello world!  "), "world! hello");
        TestHelper.test(reverseWords("the sky is blue"), "blue is sky the");

        TestHelper.test(reverseWords1("a good   example"), "example good a");
        TestHelper.test(reverseWords1("  hello world!  "), "world! hello");
        TestHelper.test(reverseWords1("the sky is blue"), "blue is sky the");
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-words-in-a-string/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0151());
    }
}
