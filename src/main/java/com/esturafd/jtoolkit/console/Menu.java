package com.esturafd.jtoolkit.console;

import static com.esturafd.jtoolkit.yml.PropertyMap.findProperties;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.esturafd.jtoolkit.console.ansi.Erase;
import com.esturafd.jtoolkit.console.ansi.Text;
import com.esturafd.jtoolkit.exception.ConsoleIOException;
import com.esturafd.jtoolkit.exception.MenuException;

/**
 * <p>Implementation of menu through configuration in YAML 
 * file for the execution of simple projects, the 
 * simplest implementation would be:</p>
 * 
 * <pre><code>
 * public class Main {
 *     public static void main(String... args) {
 *         Menu menu = Menu.getMenu("config.yml");
 *         menu.run();
 *     }
 * }
 * </code></pre>
 * @author esturafd
 */
public class Menu {
    
    private String title;
    private String text;
    private String option;
    private String exec;
    private List<Menu> subMenus;

    private static final String ENTRY_ERROR = "Error when reading entry";
    private static final String EXEC_ERROR = "Invalid exec class configuration";
    private static final String INST_ERROR = "Error instantiating exec class";
    private static final String INVALID_ERROR = "Invalid menu object";
    
    private Menu() {}
    
    public static Menu getMenu(String confpath) {
    	return (Menu) findProperties(confpath);
    }
    
    /**
     * Run the menu or sub-menu
     * @param console object where the menu is run
     */
    protected void run(ConsoleIO console) {
        if (subMenus != null) {
            initialize(console);
        } else if (exec != null) {
            runOption();
        } else {
            throw new MenuException(INVALID_ERROR);
        }
    }
    
    /**
     * Run the menu or sub-menu
     */
    public void run() {
        ConsoleIO console = new DefaultConsole();
        try {
            run(console);
        } finally {
            console.close();
        }
    }
    
    /**
     * initializes the printing and request of data from the menu
     * @param console object where the menu is run
     */
    private void initialize(ConsoleIO console) {
        int index = 0;
        do {
            try {
                printMenu(console);
                index = Integer.parseInt(console.readLine()) - 1;
                if (index < subMenus.size() && index > 0) {
                    subMenus.get(index).run(console);
                }
            } catch(ConsoleIOException e) {
                throw new MenuException(ENTRY_ERROR, e);
            } catch(NumberFormatException e) {
                // The menu is reprinted
            }
        } while (index >= 0);
    }
    
    /**
     * One of the menu options is executed, the class to 
     * execute has to implement MenuExecutable interface
     */
    private void runOption() {
        try {
            Class<?> execClass = Class.forName(exec);
            Constructor<?> constructor = execClass.getConstructor();
            MenuExecutable program = (MenuExecutable) constructor.newInstance();
            program.run();
        } catch (ClassNotFoundException e) {
            throw new MenuException(EXEC_ERROR, e);
        } catch (NoSuchMethodException e) {
            throw new MenuException(EXEC_ERROR, e);
        } catch (InvocationTargetException e) {
            throw new MenuException(INST_ERROR, e);
        } catch (IllegalAccessException e) {
            throw new MenuException(INST_ERROR, e);
        } catch (InstantiationException e) {
            throw new MenuException(INST_ERROR, e);
        }
    }
    
    /**
     * print the listed menu options, put 0 to exit
     * @param console object where the menu is run
     */
    private void printMenu(ConsoleIO console) {
        console.println(Erase.SCREEN);
        console.println(Text.paint(Text.GREEN, String.format("# %s%n", title)));
        if (text != null) console.printf("%s%n%n", text);
        for (int i = 0; i < subMenus.size(); i++) {
            console.printf("%d. %s%n", i+1, subMenus.get(i).getOption());
        }
        console.print("\n0. Salir\n\nEscriba la opcion que desee: ");
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setOption(String option) {
        this.option = option;
    }
    public String getOption() {
        return option;
    }
    public void setExec(String exec) {
        this.exec = exec;
    }
    public String getExec() {
        return exec;
    }
    public void setOptions(List<Menu> subMenus) {
        if (this.subMenus == null) {
            this.subMenus = subMenus;
        } else {
            this.subMenus.addAll(subMenus);
        }
    }
    public void setOptions(Menu subMenu) {
        if (this.subMenus == null) {
            this.subMenus = new ArrayList<Menu>();
        }
        this.subMenus.add(subMenu);
    }
    public List<Menu> getOptions() {
        return subMenus;
    }
}
