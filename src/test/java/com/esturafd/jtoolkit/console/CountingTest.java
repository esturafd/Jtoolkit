package com.esturafd.jtoolkit.console;

import static org.junit.Assert.fail;

import com.esturafd.jtoolkit.help.FakeIO;

import org.junit.Test;

//import static test.streameast.toolkit.help.ConsoleHandler.*;

public class CountingTest {
    
    @Test(timeout = 120000)
    public void testCycleLimit() {
        System.out.println("Prueba 1");
        int i;
        int maxCount = 5;
        boolean valid = true;
        ConsoleIO console = new DefaultConsole();
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
        ConsoleIO console = new FakeIO("n");
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
