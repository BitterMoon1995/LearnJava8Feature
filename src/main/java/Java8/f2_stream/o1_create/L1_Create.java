package Java8.f2_stream.o1_create;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

//四个创建方法
public class L1_Create {
    @Test
    public void t1(){
        //通过Collection接口提供的stream()或parallelStream()
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
    }
    @Test
    public void t2(){
        Integer[] arr = new Integer[10];
        Stream<Integer> stream = Arrays.stream(arr);
    }
    @Test
    public void t3(){
        Stream<String> stream = Stream.of("aa", "b", "ccc");
        Integer[] arr = new Integer[10];
        Stream<Integer> stream2 = Stream.of(arr);
    }
    @Test
    //无限流
    public void t4(){
        Stream<Integer> stream = Stream.iterate(2, x -> x * 2);
        //迭代流
        stream
                .limit(20)
                .forEach(System.out::println);
    }
    @Test
    public void t4_1(){
        //生成流
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
    }
}
