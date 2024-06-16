package com.bishe.api.pojo;

public class Test {
    public static void main(String[] args) {
        User u = new User(20);
        add(u);
        System.out.println("main-->" + u.age);
    }
    public static void add(User u){
        u.age++;
        System.out.println("add-->" + u.age);
    }
static class User{
        int age;

    public User(int age) {
        this.age = age;
    }
}
}
