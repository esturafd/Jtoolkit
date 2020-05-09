package com.esturafd.jtoolkit.console;

import com.esturafd.jtoolkit.help.FakeIO;

import org.junit.Test;

public class ConsoleTest {
    
    @Test
    public void testMenu() {
        ConsoleIO console = new FakeIO("1","0");
        Menu menu = Menu.getConfigMenu("menu.yml");
        menu.up(console);
    }
    
    @Test
    public void testSubMenu() {
        ConsoleIO console = new FakeIO("2","1","0","0","0","0");
        Menu menu = Menu.getConfigMenu("menu.yml");
        menu.up(console);
    }
}
