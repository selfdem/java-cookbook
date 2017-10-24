package cc.selfdem.cookbook.finals;

import org.junit.Test;

import java.util.*;

public class FinalSample {

    /**
     * 这是错误写法
     * 网上有传言可以这样，我差点就信了，然而...
     */
    @Test
    public void errorTest() {
//        final List<String> list = ["item"];
//
//        final Set<String> set = {"item"};
//
//        final Map<String, Integer> map = {"key" : 1};
    }

    /**
     * 正确的写法
     */
    @Test
    public void method() {
        final List<String> list = Arrays.asList("item");

        final Set<String> set = new HashSet<String>(){
            {
                add("item");
            }
        };

        final Map<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("item", 1);
            }
        };
    }
}
