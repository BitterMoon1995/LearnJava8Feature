package Java8.f3_optional;

import Java8.f1_lambda.Employee;
import Java8.f1_lambda.Status;
import org.junit.Test;

import java.util.Optional;

public class L1_Methods {
    @Test
    //Optional是用来存储一个可能为空的值的容器类
    public void test1() {
        Optional<Employee> optional = Optional.of(new Employee());
        Employee employee = optional.get();
        System.out.println(employee);
    }

    @Test
    //可以在Optional.of()中及早定位空指针
    public void test2() {
        Optional<Employee> optional = Optional.of(null);
        Employee employee = optional.get();
        System.out.println(employee);
    }

    @Test
    //empty()  创建空的optional实例
    public void test3() {
        Optional<Object> optional = Optional.empty();
        Object o = optional.get();
        System.out.println(o);
    }

    @Test
    //ofNullable()  若为null，创建optional空实例
    public void test4() {
        Optional<Object> optional = Optional.ofNullable(null);
        //isPresent()判断有没有值
        if (optional.isPresent()) {
            Object o = optional.get();
            System.out.println(o);
        }
    }

    @Test
    //orElse()  为调用的optional对象设置缺省值，若该对象包含的值为空，则返回该值
    public void test5() {
        Optional<Employee> optional = Optional.ofNullable(null);
        Employee orElse = optional.orElse(new Employee("雨薇", false, 22, 2000, Status.VOCATION));
        System.out.println(orElse);
    }

    @Test
    //orElseGet()   同上，但参数为Supplier<T>，可进行更细致的处理
    public void test6() {
        Optional<Employee> optional = Optional.ofNullable(null);
        Employee employee = optional.orElseGet(Employee::new);
        System.out.println(employee);
    }

    @Test
    //map()   如果有值，则其进行处理(Function)，否则返回空option实例
    public void test7() {
        Optional<Employee> optional = Optional.of(new Employee());
        Optional<Employee> mapped = optional.map(employee -> {
            employee.setName("最美薇儿");
            return employee;
        });
        System.out.println(mapped.get());
    }
    @Test
    //flatMap()   同上，但要求返回值必须包装为Optional
    public void test8() {
        Optional<Employee> optional = Optional.of(new Employee());
        Optional<Employee> flatMapped = optional.flatMap(
                employee -> Optional.of(new Employee("近平大帝")));
        System.out.println(flatMapped.get());
    }
}
