package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;
import java.util.Map;

public class Problem0003 extends BaseProblem {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && left <= map.get(c)) {
                //if the current char already available then move the left pointer by one step
                left = map.get(c) + 1;
            } else {
                //else calculate the max len from left to current index
                maxLen = Math.max(maxLen, i - left + 1);
            }
            map.put(c, i);
        }
        return maxLen;
    }

    @Override
    public void solve() {
        TestHelper.test(lengthOfLongestSubstring("abcabcbb"), 3);
        TestHelper.test(lengthOfLongestSubstring("bbbbb"), 1);
        TestHelper.test(lengthOfLongestSubstring("pwwkew"), 3);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/longest-substring-without-repeating-characters/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0003());
    }
}
