package com.zyjblogs.thead;

/**
 * 观察线程状态
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///////");
        });
        //观察状态
        Thread.State state = thread.getState();
        //new
        System.out.println(state);

        //观察启动
        thread.start();
        //观察状态
        state = thread.getState();
        //new
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
