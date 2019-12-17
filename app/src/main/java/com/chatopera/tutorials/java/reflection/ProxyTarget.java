/*
 * Copyright (C) 2019. Chatopera Inc, <https://www.chatopera.com>. All rights reserved.
 *  This software and related documentation are provided under a license agreement containing
 *  restrictions on use and disclosure and are protected by intellectual property laws.
 *  Except as expressly permitted in your license agreement or allowed by law, you may not use,
 *  copy, reproduce, translate, broadcast, modify, license, transmit, distribute, exhibit, perform,
 *  publish, or display any part, in any form, or by any means. Reverse engineering, disassembly,
 *  or decompilation of this software, unless required by law for interoperability, is prohibited.
 *
 *
 */

package com.chatopera.tutorials.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射
 */
public class ProxyTarget implements InvocationHandler {
    public static Object createProxy(Object obj) {
        //creat the proxy class according the instance of the target class
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new ProxyTarget(obj));
    }

    private Object target;

    private ProxyTarget(Object target) {
        this.target = target;
    }

    //Implements the method of InvocationHandler interface
    //This method will catch all the calls to the target class
    //and redispatch them
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        try {
            //add function before redispatching
            System.out.println("Before " + method.getName());
            //redispatch the call
            result = method.invoke(target, args);
            //add function after redispatching
            System.out.println("After " + method.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}