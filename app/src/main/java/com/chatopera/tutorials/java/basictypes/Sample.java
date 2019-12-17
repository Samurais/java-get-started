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

package com.chatopera.tutorials.java.basictypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * 基本数据类型
 */
public class Sample {

    public static void main(String[] args) {

        // number
        double a = 0.01;
        int b = 1;
        int c = -1;
        long d = 10000;

        // string
        String e = new String("foo");

        // boolean
        boolean f = true;
        Boolean g = true;
        System.out.println("g == f: " + (g == f));
        System.out.println("g.equals(f): " + (g.equals(f)));
        System.out.println("g.booleanValue == f: " + (g.booleanValue() == f));

        /**
         * Collections
         */

        // Map
        HashMap<String, String> h = new HashMap<>();
        Hashtable<String, String> k = new Hashtable<>();

        // Set
        HashSet<String> j = new HashSet<>();

        // List
        ArrayList<String> i = new ArrayList<>();
    }
}
