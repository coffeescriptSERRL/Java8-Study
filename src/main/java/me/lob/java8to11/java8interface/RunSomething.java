package me.lob.java8to11.java8interface;


@FunctionalInterface
public interface RunSomething {

    //추상 메서드가 하나만 있다면 이 것은 함수형 인터페이스를 말한다.
    // SAM (Single Abstract Method) Interface, @FunctionalInterface 가지고 있는 인터페이스 (규약을 강제해줌)
    //다른 메서드 형태 (static, defalut 등) 이 있더라도 상관이 없다.
    void doIt(); // abstract 가 생략되어 있다.

    // void doAgain(); 다른 추상 메서드가 생성될 경우 함수형 인터페이스의 규약을 어김
    static void printName() { // 자바 8부터 스태틱 메서드에 public 키워드를 생략할 수 있다.
        System.out.println("keesun");
    }

    default void printAge() { // 자바 8부터 디폴트 메서드를 선언할 수 있다.
        System.out.println("40");
    }

}
