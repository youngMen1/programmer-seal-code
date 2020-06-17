package com.seal.concurrent.test;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 顺便介绍个查看对象的属性位置分布的一个小工具：jol
 * @author fengzhiqiang
 * @date-time 2020/6/16 16:30
 **/
public class OffsetTest {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(Throwable.class).toPrintable());
    }
}
