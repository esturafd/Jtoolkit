package test.streameast.toolkit.console;

import org.junit.Test;

import test.streameast.toolkit.help.FakeIO;

import com.streameast.toolkit.console.ConsoleIO;
import com.streameast.toolkit.console.Menu;

public class ConsoleTest {
    
    @Test
    public void testMenu() {
        ConsoleIO console = new FakeIO("1","0");
        Menu menu = new Menu("menu.yml");
        menu.up(console);
    }
    
    @Test
    public void testSubMenu() {
        ConsoleIO console = new FakeIO("2","1","0","0","0","0");
        Menu menu = new Menu("menu.yml");
        menu.up(console);
    }
}
