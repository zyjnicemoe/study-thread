package com.zyjblogs.sync;

public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(1000,"结婚基金");

        Drawing you = new Drawing(account,50,"you");
        Drawing girlFriend = new Drawing(account,100,"girlFriend");
        you.start();
        girlFriend.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行:模拟取钱
class Drawing extends Thread {
    //账户
    Account account;
    //现在手里有多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    //synchronized  默认锁this
    @Override
    public  void run() {
        //锁的对象就是需要改变的量，需要增删改的对象
        synchronized (account) {
            //判断是否有千
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额 - 你手里的钱
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为:" + account.money);
//        Thread.currentThread().getName() = this.getName()
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
    }
}