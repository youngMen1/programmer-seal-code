package com.seal.code.order;

/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:08
 * 阿里代码规范 ：
 * 【强制】异常不要用来做流程控制，条件控制。
 * 说明：异常设计的初衷是解决程序运行中的各种意外情况，且异常的处理效率比条件判断方式要低很多。
 **/
public class Order2 {
    public void interrupt1(){

    }
    public void interrupt2(){

    }
    public void interrupt3(){
        //失败
        throw new RuntimeException();
    }
    public void interrupt4(){
        //失败
        throw new RuntimeException();
    }
    public void interrupt5(){
        //失败
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Order2 order2= new Order2();
        try{
            order2.interrupt1();
            order2.interrupt2();
            order2.interrupt3();
            order2.interrupt4();
            order2.interrupt5();
            System.out.println("success");
        }catch (RuntimeException e){
            System.out.println("fail");
        }

    }
}
