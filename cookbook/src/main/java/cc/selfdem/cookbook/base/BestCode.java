package cc.selfdem.cookbook.base;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 有些摘自网上，只是整理，方便自己查看
 */
public class BestCode {

    /**
     * 对列表/数组中的每个元素都乘以2
     */
    @Test
    public void arrayChange() {
        // Range是半开区间
        int[] ia = IntStream.range(1, 10).map(i -> i * 2).toArray();
        System.out.println(Arrays.toString(ia));
        List<Integer> result = IntStream.range(1, 10).map(i -> i * 2).boxed().collect(Collectors.toList());
        System.out.println(result);
    }


    /**
     * 计算集合/数组中的数字之和
     */
    @Test
    public void sumOfArray() {
        IntStream.range(1, 1000).sum();
        IntStream.range(1, 1000).reduce(0, Integer::sum);
        Stream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
        IntStream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
    }

    /**
     * 验证字符串是否包含集合中的某一字符串
     */
    @Test
    public void containStr() {
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

        keywords.stream().anyMatch(tweet::contains);
        keywords.stream().reduce(false, (b, keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
    }

    /**
     * 读取文件内容
     */
    @Test
    public void readfile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String fileText = reader.lines().reduce("", String::concat);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            List<String> fileLines = reader.lines().collect(Collectors.toCollection(LinkedList<String>::new));
        }

        try (Stream<String> lines = Files.lines(new File("data.txt").toPath(), Charset.defaultCharset()))
        {
            List<String> fileLines = lines.collect(Collectors.toCollection(LinkedList<String>::new));
        }
    }

    /**
     * 判断并输出
     */
    @Test
    public void chooseSample() {
        IntStream.range(1, 5).boxed().map(i -> { System.out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(System.out::println);
    }


}
