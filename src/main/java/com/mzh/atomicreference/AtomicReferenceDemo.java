package com.mzh.atomicreference;

import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 19);
        User li4 = new User("li4",25);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(z3);

        System.out.println(userAtomicReference.compareAndSet(z3, li4)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(z3, li4)+"\t"+userAtomicReference.get().toString());

    }
}
