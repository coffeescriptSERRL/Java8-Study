package me.lob.java8to11.java8interface;


public interface FooInf {

    // 인터페이스를 구현한 모든 클래스들은 추상메서드를 무조건 구현해야 한다.
    // 새로운 기능 (추상 메서드)를 추가하게 되면 기존에 구현한 모든 클래스가 오류를 발생시킨다.
    void printName();

    // 이러한 일이 벌어지지 않고 기능을 제공하려고 만든 것이 default Method이다.\
    // 자바가 제공하는 컬렉션에서도 default 기능으로 추가된 추상 메서드들이 있다. ex) removeIf(Predicate<? super E> filter)
    // object에서 제공하는 (equals, hasCode, toString 등) 메서드들은 default method로 제공, 재정의할 수 없다.
    // 기본 구현체는 object가 제공하기에 추상 메서드로 toString 등 선언하더라도 추상 메서드로 치지는 않는다.
    // 기본 구현체에 포함된 메서드들은 그 인터페이스가 가지고 있는 특별한 제약 사항이 있을 때나 따로 선언해서 제공하는 것이다.
    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

}
