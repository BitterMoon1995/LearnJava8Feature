package Java8.f4_defaultMethod;

public interface Interface8 {
    default String echoThoughts(){
        return "我认为低智、偏执、思想贫乏是最大的邪恶";
    }
    public static void staticF(){
        System.out.println("接口静态方法");
    }
}
