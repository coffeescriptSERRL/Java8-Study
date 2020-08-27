package me.lob.java8to11.lambda;

import java.util.function.Function;

public class FooPlus10 {

    public static void main(String[] args) {

        //기존존
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus10t = (i) -> i+10;
        System.out.println(plus10t.apply(1));

        Function<Integer, Integer> multiple2 = (i) -> i * 2;

        //compose 메서드는 인수로 받은 메서드 혹은 값을 먼저 실행한 후 compose를 호출한 인스턴스에 넘김
        Function<Integer, Integer> mutliple2AndPlus10 = plus10.compose(multiple2);

        System.out.println(mutliple2AndPlus10.apply(2));
        System.out.println(plus10.andThen(multiple2).apply(2));

    }
}
