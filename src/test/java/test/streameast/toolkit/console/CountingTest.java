package test.streameast.toolkit.console;

import static org.junit.Assert.*;

import org.junit.Test;

import test.streameast.toolkit.help.FakeIO;

import com.streameast.toolkit.console.ConsoleIO;
import com.streameast.toolkit.console.Counting;
import com.streameast.toolkit.console.SystemConsoleIO;

//import static test.streameast.toolkit.help.ConsoleHandler.*;

public class CountingTest {
    
    @Test(timeout = 120000)
    public void testCycleLimit() {
        System.out.println("Prueba 1");
        int i;
        int maxCount = 5;
        boolean valid = true;
        ConsoleIO console = new SystemConsoleIO();
        try {
            Counting valCount = new Counting(console, maxCount);
            for (i = 0; i < (maxCount + 2) && valid; i++) {
                valid = valCount.count();
            }
        } finally {
            console.close();
        }
        if (i != maxCount) {
            fail("Ocurrio un error en el conteo " + i);
        }
    }
    
    @Test(timeout = 30000)
    public void testCycleStop() {
        System.out.println("Prueba 2");
        int i;
        int maxCount = 5;
        boolean valid = true;
        ConsoleIO console = new FakeIO();
        try {
            Counting valCount = new Counting(console, maxCount);
            for (i = 0; i < (maxCount + 2) && valid; i++) {
                valid = valCount.count();
            }
        } finally {
            console.close();
        }
    }
}
