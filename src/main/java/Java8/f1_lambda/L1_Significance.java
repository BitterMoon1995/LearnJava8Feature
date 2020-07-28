package Java8.f1_lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class L1_Significance {
    private void testTreeSet(Comparator<Integer> comparator) {
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(7);
        treeSet.add(1);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(9);
        treeSet.add(0);
        System.out.println(treeSet);
    }
    //例一：古老艺能之匿名内部类
    @Test
    public void test() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                //核心其实只有这一句
                return Integer.compare(o1,o2);
            }
        };
        testTreeSet(comparator);
    }
    //lambda可以理解为一段可以传递的代码（将代码像数据一样传递）
    @Test
    public void test2() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1,o2);
        testTreeSet(comparator);
    }

    //例二：策略模式+函数式接口+lambda实现匿名内部类整活儿
    public ArrayList<Employee> testEmps() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("a",false,22,2000,Status.FREE));
        list.add(new Employee("b",true,12,12000,Status.FREE));
        list.add(new Employee("c",false,52,20000,Status.FREE));
        list.add(new Employee("d",true,42,5000,Status.FREE));
        list.add(new Employee("e",false,27,9000,Status.FREE));
        return list;
    }

    public List<Employee> filterEmp(List<Employee> empList,EmpMatcher matcher){
        ArrayList<Employee> resultList = new ArrayList<>();
        for (Employee e:empList) {
            if (matcher.match(e)) resultList.add(e);
        }
        return resultList;
    }

    @Test
    public void test3() {
        ArrayList<Employee> list = testEmps();
        List<Employee> result = filterEmp(list, employee -> employee.salary > 10000);
        result.forEach(System.out::println);
    }

    //例三：不需要创建任何额外接口和方法，不需要任何匿名内部类
    @Test
    public void test4() {
        ArrayList<Employee> list = testEmps();
        list.stream()
                .filter(employee -> employee.salary > 2000)
                .limit(2)
                .forEach(System.out::println);
    }

}
