package cc.selfdem.cookbook.switchs;

import org.junit.Test;

public class SwitchSample {

    @Test
    public void switchTest() {
        String name = "java";
        switch (name) {
            case "java":
                System.out.println("java matched");
                break;
            case "python":
                System.out.println("python matched");
                break;
            default:
                System.out.println("not found.");

        }
    }
}
