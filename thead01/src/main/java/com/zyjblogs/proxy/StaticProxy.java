package com.zyjblogs.proxy;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        new Thread(() -> System.out.println("我喜欢你")).start();

        new WeddingCompany(you).HappyMarry();

//        you.HappyMarry();
//        //静态代理
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
    }
}


 interface Marry {

    void HappyMarry();
}
//真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚ing");
    }
}
//代理角色，帮你结婚
class WeddingCompany implements Marry{

    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }
}