package com.seal.code.order;

import org.junit.internal.requests.FilterRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.sun.deploy.nativesandbox.comm.Response;

/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:45
 **/
@Component
@Order(10)
public class CheckParamFilter2 extends AbstractFilter {

    @Override
    public void doFilter(FilterRequest filterRequest, Response response) {

    }
}
