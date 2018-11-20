package test.streameast.toolkit.console;

import static org.junit.Assert.*;

import org.junit.Test;

import com.streameast.toolkit.console.Counting;

public class CountingTest {
    
    @Test
    public void testCycleLimit() {
        int i;
        int maxCount = 5;
        boolean valid = true;
        Counting valCount = new Counting(maxCount);
        for (i = 0; i < (maxCount * 2) && valid; i++) {
            valid = valCount.count();
        }
        if (i != maxCount) {
            fail("Ocurrio un error en el conteo " + i);
        }
    }
}
