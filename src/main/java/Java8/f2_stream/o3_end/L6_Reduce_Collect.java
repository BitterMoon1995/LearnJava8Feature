package Java8.f2_stream.o3_end;

import Java8.f1_lambda.ListUtil;
import Java8.f1_lambda.Employee;
import Java8.f1_lambda.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//流的终止操作之规约与收集
public class L6_Reduce_Collect {
    static List<Employee> empList;

    static {
        empList = ListUtil.getEmps();
    }

    //reduce,根据指定的计算模型将Stream中的值计算得到一个最终结果
    @Test
    public void test1() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = intList.stream()
                .reduce(6324, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void test2() {
        //由于工资可能为空，所以返回值是Optional
        //map-reduce模式
        Optional<Integer> sum = empList.stream()
                .map(Employee::getSalary)
                .reduce(Integer::sum);
        System.out.println(sum);
    }

    //collect,搜集流中元素，按一定方式组合到一定的结果集
    //↓↓↓以下全是collect-api
    @Test
    //指定结果集 toList等、toCollection
    public void test3() {
        List<String> collect = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());//指定结果集为List
        System.out.println(collect);

        HashSet<String> hashSet = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));//指定结果集为HashSet
        System.out.println(hashSet);
    }

    @Test
    //小统计   counting、summing、max、averaging
    public void test4() {
        Long count = empList.stream()
                //获取总数
                .collect(Collectors.counting());
        System.out.println(count);

        Double average = empList.stream()
                //获取薪资平均值
                .collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(average);

        Integer sum = empList.stream()
                //求总工资
                .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(sum);

        Optional<Integer> maxSalary = empList.stream()
                //先得到工资流，再从工资流中搜集最大的工资
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxSalary);
    }

    @Test
    //分组 groupingBy
    public void test5() {
        Map<Status, List<Employee>> groupedMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(groupedMap);
    }

    @Test
    //多级分组★
    public void test6() {
        Map<Status, Map<String, List<Employee>>> multi_stage = empList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.groupingBy(
                                e -> {
                                    if (e.getAge() < 25) return "青年";
                                    else if (e.getAge() < 50) return "中年";
                                    else return "老年";
                                }
                        )));
        System.out.println(multi_stage);
    }
    @Test
    //分区    partitioningBy，分区的条件只能是Predicate
    public void test7() {
        Map<Boolean, List<Employee>> partition = empList.stream()
                .collect(Collectors.partitioningBy(Employee::getGender));
        System.out.println(partition);
    }

    @Test
    //统计汇总（信息集） summarizing
    public void test8() {
        IntSummaryStatistics summary = empList.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println("最大值："+summary.getMax()+"平均值："+summary.getAverage()+
                "人数："+summary.getCount() +"总量："+summary.getSum());
    }

    @Test
    //连接 joining
    public void test9() {
        String join = empList.stream()
                .map(Employee::getName)
                //可指定分隔符、首字符、尾字符
                .collect(Collectors.joining(",","☀","☹"));
        System.out.println(join);
    }
}
