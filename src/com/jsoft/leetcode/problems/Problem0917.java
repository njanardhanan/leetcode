package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

/**
 *
 */
public class Problem0917 extends BaseProblem {

    public String reverseOnlyLetters(String S) {
        if (S == null) return null;
        char[] c = S.toCharArray();
        int i=0;
        int j=c.length-1;

        while(i<j) {
            if (Character.isAlphabetic(c[i]) && Character.isAlphabetic(c[j])) {
                char t = c[i];
                c[i++] = c[j];
                c[j--] = t;
            }

            if (!Character.isAlphabetic(c[i])) {
                i++;
            }

            if (!Character.isAlphabetic(c[j])) {
                j--;
            }
        }

        return new String(c);
    }

    @Override
    public void solve() {
        TestHelper.test(reverseOnlyLetters("ab-cd"), "dc-ba");
        TestHelper.test(reverseOnlyLetters("a-bC-dEf-ghIj"), "j-Ih-gfE-dCba");
        TestHelper.test(reverseOnlyLetters("Test1ng-Leet=code-Q!"), "Qedo1ct-eeLg=ntse-T!");
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-only-letters/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0917());
    }
}
