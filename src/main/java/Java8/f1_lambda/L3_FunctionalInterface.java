package Java8.f1_lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class L3_FunctionalInterface {
    /**
     * 四大内置函数式接口：~.jpg
     */

    //消费型接口
    @Test
    public void test1() {
        consume(10000,money -> System.out.println("消费8000，余额："+(money-8000)));
    }
    public void consume(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2() {
        Random random = new Random();
        Integer[] a = new Integer[10];
        List<Integer> list = supply(a, () -> (int) (Math.random()*10));
        System.out.println(list);
    }
    public List<Integer> supply(Integer[] array, Supplier<Integer> supplier){
        for (int i = 0; i < array.length; i++) {
            array[i] = supplier.get();
        }
        return Arrays.asList(array);
    }

    @Test
    public void test3() {
        String res = function("习近平", s -> s+"登基称帝！！！！！！");
        System.out.println(res);
    }

    public String function(String s, Function<String,String> function){
        return function.apply(s);
    }

    @Test
    public void test4() {
        Boolean isPrincess = predict("周薇儿公主宝贝", s -> s.contains("周薇儿"));
        System.out.println(isPrincess);
    }

    public Boolean predict(String girl, Predicate<String> predicate){
        return predicate.test(girl);
    }
}
