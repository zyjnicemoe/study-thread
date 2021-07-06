package com.zyjblogs.thead;

/**
 * 守护线程
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        //设置守护线程
        thread.setDaemon(true);
        //守护线程启动
        thread.start();
        //you启动
        new Thread(you).start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保护你");
        }
    }
}
class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心生活每一天");
        }
        System.out.println("=====GoodBye World======");
    }
}
