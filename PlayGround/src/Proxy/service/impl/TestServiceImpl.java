package Proxy.service.impl;

import Proxy.service.TestService;

/**
 * @author zhuqiu
 * @date 2021/1/17
 */
public class TestServiceImpl implements TestService {

    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
