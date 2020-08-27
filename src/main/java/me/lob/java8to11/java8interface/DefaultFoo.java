package me.lob.java8to11.java8interface;


// Diamond Problem (다중 상속) 발생 시키기
// 동일한 Default method를 제공하는 interface를 다중 상속
// 이 문제를 해결하려면, 직접 해당 Default method를 Override 해야한다.
public class DefaultFoo implements FooInf, Bar{

    String name;

    public DefaultFoo(String name){
        this.name = name;
    }

    // default method도 재정의가 가능하다.
    // 다중 상속이 해당 방법으로 재정의를 진행해야 한다.
    @Override
    public void printNameUpperCase() {
       System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        FooInf foo = new DefaultFoo("lob");
        foo.printName();
        foo.printNameUpperCase(); // default method
    }

}
