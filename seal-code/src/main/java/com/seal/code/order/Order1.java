package com.seal.code.order;

import lombok.Data;

/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:04
 * 我们先看一个普通的下单拦截接口。
 *   基本逻辑，参数安全拦截，次数拦截，规则拦截，都通过，返回允许下单，任意一个失败，返回对应的失败原因。
 * 我们希望达到的目的
 * 代码没有这么多if else嵌套，可读性高
 * 如果新增新的拦截逻辑简单方便，不影响原本的逻辑，扩展性好
 * 可以很方便地调换拦截逻辑顺序，低耦合
 *
 **/
public class Order1 {
    public Message interrupt1() {
        return null;
    }

    public Message interrupt2() {
        return null;
    }

    public Message interrupt3() {
        return null;
    }

    public Message interrupt4() {
        return null;
    }

    public Message interrupt5() {
        return null;
    }

    public static void main(String[] args) {
        Order1 order = new Order1();
        if (order.interrupt1().getResult() == 1) {
            if (order.interrupt2().getResult() == 1) {
                if (order.interrupt3().getResult() == 1) {
                    if (order.interrupt4().getResult() == 1) {
                        if (order.interrupt5().getResult() == 1) {
                            System.out.println("success");
                        }
                    }
                }
            }
        }
    }

    @Data
    class Message {
        private int result;
        private String msg;
    }
}
