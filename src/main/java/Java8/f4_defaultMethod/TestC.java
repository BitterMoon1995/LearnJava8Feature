package Java8.f4_defaultMethod;

import org.junit.Test;

public class TestC implements Interface8,Interface8_2{
    /*
    类冲突：类优先原则。如果类X继承父类Y实现接口Z，且Y的某一方法和Z的某一默认方法冲突，则Z的默认方法被忽略
     */
    @Test
    public void test1() {
        Class2 class2 = new Class2();
        System.out.println(class2.echoThoughts());
    }
    /*
    接口冲突：如果类实现两个具有相同默认方法的接口，则必须自己实现这个方法
     */
    @Override
    public String echoThoughts() {
        return null;
    }
    /*
    Java8允许接口有静态方法，可直接调用
     */
    @Test
    public void test3() {
        Interface8.staticF();
    }
}
