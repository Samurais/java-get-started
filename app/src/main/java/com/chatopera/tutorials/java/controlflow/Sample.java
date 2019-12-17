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

package com.chatopera.tutorials.java.controlflow;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample {

    // 枚举类型
    public enum FOO {
        FOO1, FOO2;
    }

    public static void main(String[] args) {

        // about if and equal
        String a = "";
        String b = new String("");

        if (a == b) {
            System.out.println("if: equal");
        } else {
            System.out.println("if: not equal");
        }

        FOO c = FOO.FOO1;
        switch (c) {
            case FOO1:
                System.out.println("switch: FOO1");
                break;
            case FOO2:
                System.out.println("switch: FOO2");
                break;
            default:
                System.out.println("switch: Error");
        }

        int loop = 5;
        while (loop-- > 0) {
            System.out.println("while: loop" + loop);

            if (loop < 3) {
                break;
            }
        }

        ArrayList<String> d = new ArrayList<>(Arrays.asList("a", "b", "c"));
        for (final String e : d) {
            System.out.println("for: " + e);
            // continue
            // break
        }

    }

}
