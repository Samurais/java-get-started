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

package com.chatopera.tutorials.java.oo;

import junit.framework.TestCase;

public class FishTest extends TestCase {

    private Fish myFish;

    public void setUp() throws Exception {
        myFish = new Fish();
    }

    public void tearDown() throws Exception {
    }

    public void testFish() {
        System.out.println("fish has " + myFish.getNumberOfLegs() + " legs.");
        myFish.label();
        myFish.move();
        myFish.eat();
        myFish.requisite();
    }
}
