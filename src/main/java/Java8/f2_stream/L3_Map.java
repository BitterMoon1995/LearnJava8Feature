package Java8.f2_stream;

import Java8.f1_lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//流的中间操作之map
/*  map
接收一个函数作为参数，该函数会应用到每一个元素上，
并将其映射为一个新的元素。最终返回一个包含新元素的新流
 */
public class L3_Map {
    @Test
    public void t1() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void t2() {
        ArrayList<Employee> emps = getEmp();
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
/*  flatmap
接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有流连接成一个流
 */

    //首先设计一个把字符串转换为字符流的函数
    public Stream<Character> getCharacters(String str){
        ArrayList<Character> characters = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (Character c: chars
             ) {
            characters.add(c);
        }
        return characters.stream();
    }
    //这时想迭代一个字符串数组的每一个字符，如果还用map
    @Test
    public void t3_1() {
        String[] strings = {"aaa","bbb","ccc","ddd"};
        //就会得到包含4个Stream<Character>的Stream
        Stream<Stream<Character>> streamStream = Arrays.stream(strings)
                .map(this::getCharacters);
        //遍历也会麻了
        streamStream.forEach(characterStream -> characterStream.forEach(System.out::println));
    }
    //很明显并不可取，我们需要把四个Stream<Character>合并成一个流
    @Test
    public void t3_2(){
        String[] strings = {"aaa","bbb","ccc","ddd"};
        Stream<Character> characterStream = Arrays.stream(strings)
                .flatMap(this::getCharacters);
        characterStream.forEach(System.out::println);
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
