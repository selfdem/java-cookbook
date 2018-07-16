package cc.selfdem.cookbook.oom;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 会导致OOM的代码
 */
public class OOMSample {

    @Test
    public void testOOM() {
        boolean caught = false;
        try {
            List<String> strings = new LinkedList<>();
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                strings.add(new String("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + i));
                i++;
            }
            System.out.println(strings.size());
        } catch (OutOfMemoryError error) {
            caught = true;
        }
        assert caught;
    }
}
