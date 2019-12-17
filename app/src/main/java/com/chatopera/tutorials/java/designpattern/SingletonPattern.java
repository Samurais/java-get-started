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

package com.chatopera.tutorials.java.designpattern;

/**
 * 单体模式
 */
public class SingletonPattern {
    private static SingletonPattern SINGLE_INSTANCE = null;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized (SingletonPattern.class) {
                SINGLE_INSTANCE = new SingletonPattern();
            }
        }
        return SINGLE_INSTANCE;
    }
}
