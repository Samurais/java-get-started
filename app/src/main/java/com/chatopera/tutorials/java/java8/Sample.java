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

package com.chatopera.tutorials.java.java8;

import java.util.Optional;
import java.util.function.Function;

public class Sample {
    public static class Name {
        private String name;

        public Name(final String name) {
            this.name = name;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

    }

    public static class Person {
        private Name name;
        private int age;
        private String password;


        public void greetings(Function<String, String> fn) {
            fn.apply("Hello, my name is " + this.getName().get().getName().get());
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public Optional<Integer> getAge() {
            return Optional.ofNullable(age);
        }

        public Optional<String> getPassword() {
            return Optional.ofNullable(password);
        }

        // normal constructors and setters

        Person(final String name, final int age) {
            this.name = new Name(name);
            this.age = age;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // lambdas
        Thread t = new Thread(() -> System.out.println("Hello."));
        t.run();

        // Function
        Person person = new Person("john", 26);
        person.greetings(s -> {
            System.out.println("Apply:" + s);
            return s;
        });

        // Optional
        Optional<Person> personOptional = Optional.ofNullable(person);
        personOptional.ifPresent(p -> System.out.println("personOptional getAge:" + p.getAge().get()));

        // flatMap
        String name = personOptional
                .flatMap(Person::getName)
                .flatMap(Name::getName)
                .orElse("");

        assert name.equals("john") : "name should be equal to john";

    }
}
