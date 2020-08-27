package me.lob.java8to11.methodref;

public class MethodClassRef {

    private String name;

    public MethodClassRef() {

    }

    public MethodClassRef(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "Hello " + name;
    }

    public static String hi(String name) {
        return "h1 " + name;
    }


}
