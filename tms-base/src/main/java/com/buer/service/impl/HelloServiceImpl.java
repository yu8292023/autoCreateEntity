package com.buer.service.impl;

import com.buer.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello world!";
    }
}
