package Java8.practice;

import Java8.f1_lambda.Employee;
import Java8.f1_lambda.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static java.lang.StrictMath.pow;

public class Practice {
    @Test
    //给定数字列表，返回由每一个数字的平方组成的新列表
    public void test1() {
        ArrayList<Integer> intList = ListUtil.getIntList();
        intList.stream()
                .map(integer -> pow(integer,2))
                .forEach(System.out::println);
    }
    @Test
    //用map-reduce计数一共有多少个employee
    public void test2() {
        ArrayList<Employee> emps = ListUtil.getEmps();
        Optional<Integer> map_reduce = emps.stream()
                .map(employee -> 1)
                .reduce(Integer::sum);
        System.out.println(map_reduce);
    }
}
