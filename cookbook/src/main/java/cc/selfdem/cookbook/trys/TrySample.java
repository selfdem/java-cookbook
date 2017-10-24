package cc.selfdem.cookbook.trys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TrySample {

    /**
     * 在JAVA7以前
     */
    @Test
    public void oldTry() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("pom.xml"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * 在JAVA7以后
     */
    @Test
    public void newTry() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("pom.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
