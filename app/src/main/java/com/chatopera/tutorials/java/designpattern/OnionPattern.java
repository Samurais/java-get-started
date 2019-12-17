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

import com.chatopera.compose4j.AbstractContext;
import com.chatopera.compose4j.Composer;
import com.chatopera.compose4j.Functional;
import com.chatopera.compose4j.Middleware;
import com.chatopera.compose4j.exception.Compose4jRuntimeException;

import java.util.HashMap;

public class OnionPattern {

    private static final String VAL1 = "what's up";

    protected static void print(final HashMap<String, String> map) {
        if (map != null) {
            System.out.println("   [print] object items size " + map.size());

            for (final String key : map.keySet()) {
                System.out.println("   [print] key " + key + " , value " + map.get(key));
            }
        } else {
            System.out.println("   [print] object is null.");
        }
    }

    public static class SampleContext extends AbstractContext {
        private HashMap<String, String> data = new HashMap<>();

        public HashMap<String, String> getData() {
            return data;
        }

        public void setData(HashMap<String, String> data) {
            this.data = data;
        }
    }

    static class Mw1 implements Middleware<SampleContext> {
        @Override
        public void apply(final SampleContext ctx, final Functional next) {
            System.out.println("[Mw1] apply 1");

            ctx.getData().put("foo", "bar");
            ctx.getData().put("foo2", "bar2");
            print(ctx.getData());
            next.apply();
            System.out.println("[Mw1] apply 2");

            print(ctx.getData());
        }
    }


    static class Mw2 implements Middleware<SampleContext> {

        @Override
        public void apply(final SampleContext ctx, final Functional next) {
            System.out.println("[Mw2] apply 1");
            ctx.getData().put("foo", VAL1);
            ctx.getData().put("foo3", "another item");
            print(ctx.getData());
            next.apply();
            System.out.println("[Mw2] apply 2");
            print(ctx.getData());
        }
    }

    public static void main(String[] args) throws Compose4jRuntimeException {
        Composer composer = new Composer<SampleContext>();
        composer.use(new Mw1());
        composer.use(new Mw2());

        SampleContext context = new SampleContext();
        composer.handle(context);

        System.out.println("[testCompose] result");
        print(context.getData());
    }

}
