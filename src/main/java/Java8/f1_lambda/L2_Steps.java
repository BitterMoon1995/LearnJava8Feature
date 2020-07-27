package Java8.f1_lambda;

import org.junit.Test;

public class L2_Steps {
    /**
     * lambda使用步骤：
     * 1.创建函数式接口
     * 2.创建调用接口方法的主方法
     * 3.调用主方法，lambda传入接口实现
     */

    public Integer mainFunc(int a,int b,Calculation cal){
        return cal.calculate(a,b);
    };

    @Test
    public void test() {
        Integer res = mainFunc(1, 2, ((a, b) -> a + b + 10));
        System.out.println(res);
    }
    //好处：丝滑、灵活的函数式编程体验：没有类型、泛型、返回值的束缚；灵活修改算法
}
