package Java8.f2_stream;

import Java8.f1_lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//排序
public class L4_Sort {
    //自然排序（compareTo）
    @Test
    public void t1() {
        List<String> list = Arrays.asList("zzz", "aaa", "eee", "bbb", "www");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    //定制排序 （Comparator）
    @Test
    public void t2() {
        ArrayList<Employee> employees = getEmp();
        //要实现先按年龄排，年龄一样按姓名排
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge()))
                        return e1.getName().compareTo(e2.getName());
                    else return e1.getAge().compareTo(e2.getAge());
                })
                .forEach(System.out::println);
    }


    public ArrayList<Employee> getEmp() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("a", false, 33, 8000));
        list.add(new Employee("b", true, 22, 12000));
        list.add(new Employee("c", false, 52, 20000));
        list.add(new Employee("d", true, 52, 2500));
        list.add(new Employee("e", false, 40, 5000));
        return list;
    }
}
