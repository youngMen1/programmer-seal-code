package com.seal.code.order;

import com.sun.deploy.nativesandbox.comm.Response;
import org.junit.internal.requests.FilterRequest;

/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:44
 * 过滤器的抽象类
 **/
public abstract class AbstractFilter {

    private AbstractFilter nextFilter;

    /**
     * 责任链的下一个元素
     */
    public void setNextFilter(AbstractFilter nextFilter) {
        this.nextFilter = nextFilter;
    }


    public AbstractFilter getLastFilter() {
        if (this.nextFilter != null) {
            return this.nextFilter.getLastFilter();
        } else {
            return this;
        }
    }

    public void filter(FilterRequest filterRequest, Response response) {
        doFilter(filterRequest, response);
//        if (response.isFilterNext() && nextFilter != null) {
//            nextFilter.filter(filterRequest, response);
//        }
    }

    /**
     * 具体拦截逻辑
     */
    public abstract void doFilter(FilterRequest filterRequest, Response response);

    /**
     * 根据拦截结果做处理
     */
    public void exec(FilterRequest filterRequest, Response response) {
    }
}
