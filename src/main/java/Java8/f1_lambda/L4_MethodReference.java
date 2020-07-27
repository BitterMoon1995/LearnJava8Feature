package Java8.f1_lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class L4_MethodReference {
/**
 * 在lambda表达式的方法体中，如果存在已经实现的方法，则用该形式代替原lambda表达式
 * lambda表达式的另一种表现形式
 *
 * 三种格式：
 * 1.对象::实例方法名
 * 2.类::静态方法名
 * 3.类::实例方法名 ★
 *
 * 要点：
 * 1.lambda表达式所实现的函数式接口的抽象方法的参数列表和返回类型，和引用的方法一致
 * 2.类::实例方法名使用条件：lambda表达式的第一个参数是该实例方法的调用者，第二个参数是该实例方法的参数
 *
 * 优势：参数都不用写；
 */
    @Test
    public void test() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("变装美薇儿");
    }
    @Test
    public void test2() {
        Comparator<Integer> comparator = Integer::compareTo;
        System.out.println(comparator.compare(1,2));
    }

    @Test
    public void test3() {
        BiPredicate<String,String> biPredicate = String::equals;
        System.out.println(biPredicate.test("薇儿公主","薇儿女王"));
    }

/**
 * 构造器引用   ClassName::new
 *
 * 要点：  调用哪一个构造器，取决于引用构造方法时所传递的参数
 */
    @Test
    public void test4() {
        Supplier<Employee> supplier = Employee::new;
        Employee employee = supplier.get();
        employee.setName("薇儿公主");
        employee.setAge(18);
        System.out.println(employee);
    }
    @Test
    public void test5() {
        Function<String,Employee> function = Employee::new;
        Employee employee = function.apply("薇儿大仙女");
        System.out.println(employee);
    }
    @Test
    public void test6() {
        BiFunction<String,Integer,Employee> biFunction = Employee::new;
        Employee employee = biFunction.apply("薇仙子", 18);
        System.out.println(employee);
    }
/**
 * 数组引用
 */
    @Test
    public void test7() {
        Function<Integer, String[]> function= String[]::new;
        String[] strings = function.apply(8);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
