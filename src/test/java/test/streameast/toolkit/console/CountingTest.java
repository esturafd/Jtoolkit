package test.streameast.toolkit.console;

import static org.junit.Assert.*;

import org.junit.Test;

import com.streameast.toolkit.console.ConsoleIO;
import com.streameast.toolkit.console.Counting;
import com.streameast.toolkit.console.SystemConsoleIO;

//import static test.streameast.toolkit.help.ConsoleHandler.*;

public class CountingTest {
    
    @Test(timeout = 120000)
    public void testCycleLimit() {
        int i;
        int maxCount = 5;
        boolean valid = true;
        ConsoleIO console = new SystemConsoleIO();
        try {
            Counting valCount = new Counting(console, maxCount);
            for (i = 0; i < (maxCount * 2) && valid; i++) {
                valid = valCount.count();
            }
        } finally {
            console.close();
        }
        if (i != maxCount) {
            fail("Ocurrio un error en el conteo " + i);
        }
    }
    
    /*@Test(timeout = 40000)
    public void testCycleStop() {
        int i;
        int maxCount = 5;
        boolean valid = true;
        Counting valCount = new Counting(maxCount);
        for (i = 0; i < (maxCount + 1) && valid; i++) {
            if (i == (maxCount -1)) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        writeConsole("n\n");
                        //output.println("n");
                    }
                });
                thread.start();
            }
            valid = valCount.count();
        }
        if (i != maxCount) {
            fail("Ocurrio un error en el conteo " + i);
        }
    }*/
}
