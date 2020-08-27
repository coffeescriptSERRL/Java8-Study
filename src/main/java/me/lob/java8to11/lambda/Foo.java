package me.lob.java8to11.lambda;

import me.lob.java8to11.java8interface.RunSomething;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {

        // Java 8 이전에는 익명 내부 클래스 방식 (anonymous inner class)을 사용하였다.
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };


        // Java 8 부터는 익명 내부 클래스를 람다 표현식으로 구현할 수 있다. (화살표 익명 함수)
        // () -> ...; 이 람다 형식(익명 함수)은 사실상 특별한 형태의 오브젝트를 함수처럼 표현한 것이다.
        // 해당 부분을 변수에 할당하거나, 메서드의 파라메터에 적용하거나, 리턴 할 수 있다.
        // 자바에서의 함수형 프로그래밍은 First class object로 사용할 수 있다.a
        RunSomething runSomethingTo8 = () -> System.out.println("한 줄의 로직을 구현할 때");
        runSomethingTo8.doIt();

        // 여러 줄을 사용할 때
        RunSomething runSomethingTo8Else2 = () -> {
            System.out.println("여러 줄의 로직을 구현할 때");
            System.out.println("{ } 스코프로 묶어준다");
            System.out.println("람다는 정말 최고야!");
        };
        runSomethingTo8Else2.doIt();

        // 자바 함수형 프로그래밍의 순수 함수 -> 수학적인 함수에 가깝다.
        // 순수 함수는 외부의 상태 값(final field)에 영향을 받지 않거나 외부의 값을 조작해서는 안된다.
        // 오로지 내부로 넘어온 파라메터와 내부의 필드를 이용해서만 동작해야한다.
//        RunSomething runSomethingTo8AndPure = (number) -> {
//            return number + 10;
//        };

    }

    public void run() {
        int baseNumber = 10;

        //람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);

        //로컬 클래스와 익명 클래스는 쉐도잉이 적용될 수 있다.
        //쉐도잉이란? 이름이 같은 변수 위에서는 baseNumber가 있다면 가려진다..
        //nested class도 가려진다.
        //로컬 클래스, 익명 클래스는 별도의 스코프를 가지고 있다.
        //람다는 자신을 감싸고 있는 클래스와 같은 스코프를 가지고 있다. 내부에 같은 이름을 가진 변수를 선언할 수 없다.
        //람다가 사용할 수 있는 것은 이펙티브 파이널이 된 (더이상 변화가 없는) 것을 사용할 수 있다.

        //로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);// 11
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 익명 클래스를 감싸는 baseNumber를 쓰는 것이 아니라 인자로 넘어온 것을 사용함.
                System.out.println(baseNumber);
            }
        };

        //익명 클래스의 메서드 호출
        printInt.accept(10);

    }
}
