package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem0022 extends BaseProblem {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", result, 0, 0);
        return result;
    }

    private void generateParenthesis(int n, String s, List<String> list, int openCount, int closeCount) {
        if(n == openCount && n == closeCount) {
            list.add(s);
            return;
        }
        if(openCount < n) {
            generateParenthesis(n, s + "(", list, openCount+1, closeCount);
        }
        if(closeCount < openCount) {
            generateParenthesis(n, s + ")", list, openCount, closeCount+1);
        }
    }


    @Override
    public void solve() {
        List<String> ans = generateParenthesis(3);
        TestHelper.test(Arrays.toString(ans.toArray(new String[0])), "[((())), (()()), (())(), ()(()), ()()()]");

        List<String> ans1 = generateParenthesis(4);
        TestHelper.test(Arrays.toString(ans1.toArray(new String[0])),
                "[(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]");
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/generate-parentheses/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0022());
    }
}
