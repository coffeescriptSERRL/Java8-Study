package me.lob.java8to11.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foos {

    public static void main(String[] args) {
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);


        //<타입> 의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);


        // 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        // 하나의 입력값을 받아 동일한 타입을 넘겨주는 함수 인터페이스
        UnaryOperator<Integer> plus10 = (i) -> i + 10;

    }
}
