package com.chatopera.tutorials.java;

import junit.framework.TestCase;

import java.util.Optional;

public class OptionalTestcase extends TestCase {

    public class Name {
        private String name;

        public Name(final String name) {
            this.name = name;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

    }


    public class Person {
        private Name name;
        private int age;
        private String password;

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


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testIfPresent() {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(System.out::println);
    }


    public void testFlatMap() {
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        String name = personOptional
                .flatMap(Person::getName)
                .flatMap(Name::getName)
                .orElse("");
        assertEquals("john", name);

    }

}
