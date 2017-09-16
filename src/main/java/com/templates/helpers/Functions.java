package com.templates.helpers;

import java.util.concurrent.Callable;

public class Functions {

    private Functions() {
    }

    public static Functions exec() {
        return new Functions();
    }

    public void sleeps(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * Wait for condirion is happened
     *
     * @param preCondition       condition what we waiting for
     * @param action             action between check first condition
     * @param iterCycles         how many iterations should be
     * @param waitCycleInSeconds timeout between check iterations
     * @return conditions finally happened
     */
    public Boolean waitFor(Callable<Boolean> preCondition, Runnable action, Integer iterCycles,
                           Integer waitCycleInSeconds) {

        try {
            Integer iter = 0;
            while (iter < iterCycles && !preCondition.call()) {
                iter++;
                action.run();
                sleeps(waitCycleInSeconds);
            }
            return iter < iterCycles;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("При выполнении условия выпала ошибка: " + e.getMessage());
        }
    }

    public Boolean waitFor(Callable<Boolean> condition, Integer iterCycles, Integer waitCycleInSeconds) {
        return waitFor(condition, this::toString, iterCycles, waitCycleInSeconds);
    }
}
