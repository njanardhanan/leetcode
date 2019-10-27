package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * String
 * Anagram
 * Group
 */
public class Problem0049 extends BaseProblem {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newString = new String(c);
            if (!map.containsKey(newString)) {
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(s);
        }

        result.addAll(map.values());
        return result;
    }

    @Override
    public void solve() {
        System.out.println(groupAnagrams(Utils.toArray("eat", "tea", "tan", "ate", "nat", "bat")));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/group-anagrams/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0049());
    }
}
