package tacocloud.demo;

import java.util.ArrayList;
import java.util.function.Function;

public class Ftest {

    Function<String, String> quote = s -> "'" + s + "'";

    static Function<Integer,Integer> add1 = x -> x + 1;

    static Function<Integer,Integer> add2 = Ftest::add17;

    static ArrayList<Integer> l = new ArrayList<Integer>();


    public static void main(String[] agrs){
        Ftest ft = new Ftest();

        Integer two = add1.apply(1);

        System.out.println(two);

        System.out.println(ft.act(add1));

        System.out.println(ft.act(add2));

        System.out.println(ft.act(Ftest::add17));

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        l.forEach(ft::printer);
    }

    public Integer act(Function<Integer, Integer> f){
        return f.apply(Integer.valueOf(10));
    }

    public static Integer add17(Integer i){
        return i+1;
    }

    public void printer(Integer i){
        System.out.println(i);
    }
}
