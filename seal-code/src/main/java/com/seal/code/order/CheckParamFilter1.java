package com.seal.code.order;

import com.sun.deploy.nativesandbox.comm.Response;
import org.junit.internal.requests.FilterRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * @author fengzhiqiang
 * @date-time 2020/4/14-14:44
 **/
@Component
@Order(5)
public class CheckParamFilter1 extends AbstractFilter  {
    @Override
    public void doFilter(FilterRequest filterRequest, Response response) {

    }

}


