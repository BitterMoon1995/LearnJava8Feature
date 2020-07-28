package Java8.f1_lambda;

import java.util.ArrayList;

public class ListUtil {
    public static ArrayList<Employee> getEmps() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("a",false,22,2000,Status.BUSY));
        list.add(new Employee("a",false,25,3000,Status.BUSY));
        list.add(new Employee("b",false,35,3500,Status.BUSY));
        list.add(new Employee("c",false,28,2800,Status.FREE));
        list.add(new Employee("d",false,40,8000,Status.ABROAD));
        list.add(new Employee("e",false,55,2000,Status.VOCATION));
        list.add(new Employee("f",false,60,8000,Status.VOCATION));
        list.add(new Employee("g",true,12,12000,Status.FREE));
        list.add(new Employee("h",false,52,30000,Status.ABROAD));
        list.add(new Employee("i",true,42,5000,Status.FREE));
        list.add(new Employee("j",false,27,29000,Status.ABROAD));
        list.add(new Employee("k",false,27,19000,Status.VOCATION));
        return list;
    }
    public static ArrayList<Integer> getIntList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);list.add(1);list.add(7);list.add(0);list.add(4);list.add(9);list.add(2);
        return list;
    }
}
