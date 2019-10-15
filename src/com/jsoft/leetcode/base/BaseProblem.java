package com.jsoft.leetcode.base;

public abstract class BaseProblem implements ILeetCodeSolver {

    @Override
    public void solve(Logger log) {
        System.out.println(getProblemURL());
        log.start();
        solve();
        log.stop();
    }

    public static void baseMain(BaseProblem p) {
        p.solve(new Logger());
    }

    public abstract void solve();

    public abstract String getProblemURL();
}
