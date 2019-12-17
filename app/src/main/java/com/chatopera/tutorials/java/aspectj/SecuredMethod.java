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

package com.chatopera.tutorials.java.aspectj;

/**
 * 封装两个方法：通过切面控制是否执行
 */
public class SecuredMethod {

    /**
     * 不允许调用
     */
    @Secured(isLocked = true)
    public void lockedMethod() {
        System.out.println("I am locked method, actually I was never called.");
    }

    /**
     * 允许调用
     */
    @Secured(isLocked = false)
    public void unlockedMethod() {
        System.out.println("I am unlocked method, call me whenever you want.");
    }
}

