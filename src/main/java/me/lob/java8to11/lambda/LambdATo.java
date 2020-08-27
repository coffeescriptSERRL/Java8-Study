package me.lob.java8to11.lambda;

import me.lob.java8to11.lambda.Foo;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class LambdATo {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;

        // 동일한 타입을 받아 리턴해야 할 경우 여러개의 Integer를 선언하는 것이 아니라 BinaryOperator를 사용한다.
        BinaryOperator<Integer> sum = (a,b) -> a+b;

        Foo foo = new Foo();
        foo.run();

    }
}
