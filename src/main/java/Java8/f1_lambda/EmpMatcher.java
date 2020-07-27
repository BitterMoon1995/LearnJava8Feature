package Java8.f1_lambda;
//如果一个接口只要一个（抽象）方法，则这个接口叫做函数式接口
//可以用@FunctionalInterface来进行检查
//lambda表达式必须要函数式接口的支持
@FunctionalInterface
public interface EmpMatcher {
    Boolean match(Employee employee);

//    void secondMethod();
}
