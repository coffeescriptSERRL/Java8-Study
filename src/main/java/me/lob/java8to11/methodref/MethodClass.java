package me.lob.java8to11.methodref;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodClass {

    public static void main(String[] args) {
        //구현을 하는 것이 아니라 기존에 이 작업을 진행하는 메서드가 있다면, 그 메서드 자체를 직접 참조하여 이 메서드의 인터페이스로 사용한다.
        Function<Integer, String> intToString = (i) -> "number";


        //입력 값과 반환 값의 타입이 같다면 줄여서 사용할 수 있다.
        //UnaryOperator<String> h1 = (s) -> "h1 " + s;

        // :: = 스태틱 메서드 레퍼런스 사용(ex) Class::Static Method(h1))
        UnaryOperator<String> h1 = MethodClassRef::hi;

        // 인스턴스 메서드를 참조하는 방법 ( 해당 클래스를 참조하는 UnaryOperator를 만들어서 인스턴스 메서드를 사용 )
        MethodClassRef methodClassRef = new MethodClassRef();
        UnaryOperator<String> hello = methodClassRef::hello;
        // apply를 사용하여 해당 메서드를 쓸 수 있다.
        System.out.println(hello.apply("Lob"));

        // 메서드를 레퍼런스로 만드는 방법은 class::new;이다 하지만 이것은 해당 클래스를 인스턴스화 하는 것이 아니다.
        // 해당 클래스를 인스턴스화 하려면 class.get();를 해야 만들어진다.


        // 생성자를 참조하는 방법  생성자는 해당 객체를 타입으로 넘겨준다.
        // 입력값이 없는 생성자는 입력값은 없고 결과값은 있는 메서드 인터페이스를 사용하면 된다. Supplier<Class>
        Supplier<MethodClassRef> newMethodClassRef = MethodClassRef::new;

        // 입력값이 있는 생성자 사용하기
        // 메소드 레퍼런스만 보아서는 위와 아래가 구분이 안가지만 사용되는 메서드 인터페이스를 보고 알 수 있다. 오버로딩은 알잖아요..?
        Function<String, MethodClassRef> LobMethodClassRef = MethodClassRef::new;

        //임의 객체의 메서드를 참조하는 방법 타입::인스턴스 메서드
        //특정 타입의 불특성 다수 인스턴스의 메서드를 참조하는 방법
        String[] names = {"lob","cat","dog"};
        // Comparator를 이용해서 어떻게 정렬할지, 어떤 값을 리턴할지 정한다.
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        // Comparator는 자바 8부터 함수형 인터페이스로 변경되었고 구현해야하는 추상 메서드는 하나이지만
        // 여러 개의 default와 static 메서드를 가지고 있다.
        // 함수형 인터페이스가 사용 가능한 자리는 람다형과 메서드 레퍼런스를 쓸 수 있다는 것
        // 즉 Comparator 부분을 여러 메서드로 대처할 수 있다.

        // 내부 배열을 순회하면서 n과 n+1의 자리를 비교하여 int 값을 리턴한다.
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}
