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

abstract public class AbstractAnimal implements IAnimal {

    private int numberOfLegs;

    // abstract methods
    public void move() {
        System.out.println(this.getClass().getName() + " :move UNKNOWN.");
    }

    public void eat() {
        System.out.println(this.getClass().getName() + " :eat UNKNOWN.");
    }

    public void requisite() {
        System.out.println(this.getClass().getName() + " requisite: water, oxygen.");
    }

    // concrete method
    abstract void label();

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
