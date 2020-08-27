package me.lob.java8to11.java8interface;

public interface Bar {

//    bar 인터페이스가 FooInf를 상속받을 경우 해당 인터페이스에서 제공하는 기본(default method) 구현체를 제공하기 싫다면,
//    그럴 경우 그 기본 메서드를 추상 메서드로 다시 선언해야 한다.
//    void printNameUpperCase();

    // 다중 상속 문제 (Diamond Problem)
    default void printNameUpperCase() {
        System.out.println("bar");
    }

}
