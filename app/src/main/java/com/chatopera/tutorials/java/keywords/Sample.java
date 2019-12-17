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

package com.chatopera.tutorials.java.keywords;

import java.util.ArrayList;
import java.util.Date;

public class Sample {
    public final static String name = "foo";
    public static String name2 = "foo";

    public Sample() {

    }

    public void append(ArrayList<String> x) {
        x.add((new Date()).toString());
        x = new ArrayList<>();
        x.add("ff");
        x.add("a");
    }

    public void upper(String x) {
        x = x.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("static final name: " + Sample.name);
        Sample s = new Sample();
        System.out.println("variable(s) static final name: " + s.name);
        s.name2 = "bar";
        System.out.println("variable(s) static final name2: " + s.name2);

        String a = new String("foo2");
        s.upper(a);
        System.out.println("Post uppger a:" + a);

        final ArrayList<String> b = new ArrayList<>();
        s.append(b);
        System.out.println("Final arraylist size:" + b.size());
    }

}
