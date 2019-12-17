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

package com.chatopera.tutorials.java.exceptionhandling;

public class Sample {


    public Sample() {

    }

    void throwException(final String msg) throws SampleException {
        throw new SampleException(msg);
    }


    // nestted class

    class SampleException extends Exception {
        public SampleException(final String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {

        // 自定义Exception
        Sample s = new Sample();
        try {
            s.throwException("some error message.");
        } catch (SampleException e) {
            e.printStackTrace();
        }

        // 使用assert
        try {
            String a = new String("a");
            String b = new String("b");
            // java -ea -classpath "`pwd`" $javaClassCompiled
            assert a.equals(b) : "a should equal to b.";
        } catch (java.lang.AssertionError e) {
            e.printStackTrace();
        }

        // 使用系统的Exception
        if (args.length == 0) {
            throw new IllegalArgumentException("no args?");
        }

        // TODO
        // 1. 区分runtime exception and exception
        // 2. 什么时候使用 assert
    }

}
