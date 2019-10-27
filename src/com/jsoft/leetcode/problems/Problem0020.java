package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 */
public class Problem0020 extends BaseProblem {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(map.keySet().contains(c)) {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return false;
            } else {
                char z = stack.pop();
                if(map.get(z) != c) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    @Override
    public void solve() {
        TestHelper.test(isValid("()"), true);
        TestHelper.test(isValid("()[]{}"), true);
        TestHelper.test(isValid("(]"), false);
        TestHelper.test(isValid("([)]"), false);
        TestHelper.test(isValid("{[]}"), true);
        TestHelper.test(isValid("}}"), false);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/valid-parentheses/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0020());
    }
}
