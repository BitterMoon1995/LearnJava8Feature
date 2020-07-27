package Java8.f2_stream;

import Java8.f1_lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

//流的中间操作之筛选与切片
public class L2_Filter_Slice {


    @Test   //filter   过滤。返回过滤后的流（其他操作同理）
    public void t1() {
        ArrayList<Employee> employees = testEmp();
        Stream<Employee> stream = employees.stream();
        stream
                .filter(employee -> employee.getSalary() < 10000)
//                如果没有终止操作，任何中间操作都不会执行。
//                没有中间操作，终止操作照样可以执行
//                只有执行了终止操作，中间操作才会一次性全部执行，这个过程称为“惰性求职”
                .forEach(System.out::println);//内部迭代
    }

    @Test  //limit   截断
    public void t2() {
        ArrayList<Employee> employees = testEmp();
        employees.stream().limit(3).forEach(System.out::println);
    }

    @Test  //小细节：短路迭代
    public void t2_2() {
        ArrayList<Employee> employees = testEmp();
        employees.stream()
                .filter(employee -> {
                    System.out.println("短路了吗？");
                    return employee.getSalary() > 0;
                })
                .limit(3)
                //条件一满足就会停止迭代，不会再迭代所有元素
                .forEach(System.out::println);
    }

    @Test   //skip    跳过
    public void t3(){
        ArrayList<Employee> employees = testEmp();
        employees.stream()
                .skip(2)
                .forEach(System.out::println);
    }

    @Test   //distinct    去重
    //去重根据hashcode和equals，注意引用类型
    public void t4(){
        int[] a = {1,2,3,3,3,4,6};
        Arrays.stream(a)
                .distinct()
                .forEach(System.out::println);
    }

    public ArrayList<Employee> testEmp() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("a", false, 33, 8000));
        list.add(new Employee("b", true, 22, 12000));
        list.add(new Employee("c", false, 52, 20000));
        list.add(new Employee("d", true, 52, 2500));
        list.add(new Employee("e", false, 40, 5000));
        return list;
    }
}
