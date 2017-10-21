package cc.selfdem.cookbook.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaSample {

    /**
     *  作用之一：替换匿名类
     */
    @Test
    public void sample_1() {
        //JAVA8以前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JAVA8以前");
            }
        }).start();

        //JAVA8以后
        new Thread(() -> System.out.println("JAVA8以后")).start();
    }

    /**
     * 作用之二：列表迭代
     */
    @Test
    public void sample_2() {
        List<String> data = Arrays.asList("AAA", "BBB", "CCC");
        //JAVA8以前
        for(String item : data) {
            System.out.println(item);
        }
        //JAVA8之后
        data.forEach((o) -> System.out.println(o));
        //JAVA8使用方法引用，更简单
        data.forEach(System.out::println);
    }
}
