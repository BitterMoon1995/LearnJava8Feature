package Java8.f2_stream.o3_end;

import Java8.f1_lambda.ListUtil;
import Java8.f1_lambda.Employee;
import Java8.f1_lambda.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//流的终止操作之查找与匹配
public class L5_Search_Match {
    static List<Employee> empList;

    static {
        empList = ListUtil.getEmps();
    }

    @Test
    //allMatch判断是否所有元素都满足某一条件
    public void test1() {
        ArrayList<Employee> emps = ListUtil.getEmps();
        boolean allMatch = emps.stream()
                .allMatch(employee -> employee.getStatus().equals(Status.BUSY));
        boolean allMatch2 = emps.stream().allMatch(employee -> employee.getAge() > 1);
        System.out.println(allMatch);
        System.out.println(allMatch2);
    }
    @Test
    //anyMatch判断是否存在（至少一个）元素满足某一条件
    public void test2() {
        boolean anyMatch = empList.stream()
                .anyMatch(employee -> employee.getStatus() == Status.VOCATION);
        System.out.println(anyMatch);
    }
    @Test
    //noneMatch判断是否所有元素都不满足某一条件
    public void test3() {
        boolean noneMatch = empList.stream()
                .noneMatch(employee -> employee.getSalary() > 50000);
        System.out.println(noneMatch);
    }
    @Test
    //findFirst返回第一个，findAny返回随机一个
    //注意返回类型是Optional
    public void test4() {
        Optional<Employee> first = empList.stream()
                .sorted((e1,e2)->
                    e1.getAge()-e2.getAge()
                )
                .findFirst();
        Employee employee = first.orElse(new Employee());
        System.out.println(first);

        Optional<Employee> any = empList.parallelStream()
                .filter(employee1 -> employee1.getStatus()==Status.FREE)
                .findAny();
        System.out.println(any);
    }
    @Test
    public void test5() {
        Optional<Employee> max = empList.stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary());

        Optional<Integer> min = empList.stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo);

        long count = empList.stream()
                .filter(employee -> employee.getStatus()==Status.VOCATION)
                .count();

        System.out.println(max);
        System.out.println(min);
        System.out.println(count);
    }
}
