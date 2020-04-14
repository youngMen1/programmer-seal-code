package com.seal.code.order;

import com.sun.deploy.nativesandbox.comm.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:54
 **/
public class Test {
    /**
     * 利用spring的自动注入机制
     */
    @Autowired
    List<AbstractFilter> abstractFilterList;

    private AbstractFilter firstFilter;

    /**
     * spring注入后自动执行
     */
    @PostConstruct
    public void initializeChainFilter() {
        // 把所有调用的逻辑注入到责任链，按照Order排序，越小优先级越高
        for (int i = 0; i < abstractFilterList.size(); i++) {
            if (i == 0) {
                firstFilter = abstractFilterList.get(i);
            } else {
                firstFilter.getLastFilter().setNextFilter(abstractFilterList.get(i));
            }
        }
    }

    /**
     * 直接使用
     *
     * @return
     */
//    public Response exec() {
//        firstFilter.filter(filterRequest, response);
//        return response;
//    }


}
