package com.streameast.toolkit.console;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.streameast.toolkit.exception.ConsoleIOException;
import com.streameast.toolkit.exception.MenuException;

import static com.streameast.toolkit.yml.MapProperties.*;
import static com.streameast.toolkit.console.Ansi.*;

/**
 * Class of command line menu management
 * 
 * @author streameast
 */
public class Menu {
    
    private String title;
    private String text;
    private String option;
    private String exec;
    private List<Menu> subMenus;
    private ConsoleIO console;
    
    public Menu(String config) {
        if (config != null) {
            Menu foo = (Menu) getObjectProperties(config);
            title = foo.getTitle();
            text = foo.getText();
            option = foo.getOption();
            exec = foo.getExec();
            subMenus = foo.getOptions();
        }
    }
    
    public Menu() {
        this(null);
    }
    
    /**
     * This method up the menu
     */
    public void up(ConsoleIO console) {
        this.console = console == null? new SystemConsoleIO(): console;
        if (subMenus != null) {
            doMenu();
        } else if (exec != null) {
            doExec();
        } else {
            throw new MenuException("Invalid menu object");
        }
    }
    
    /**
     * This method up the menu
     */
    public void up() {
        up(null);
    }
    
    /**
     * Execute the menu
     */
    private void doMenu() {
        int index = 0;
        do {
            try {
                printMenu();
                index = Integer.parseInt(console.readLine()) - 1;
                if (index < subMenus.size() && index > 0) {
                    subMenus.get(index).up(console);
                }
            } catch(ConsoleIOException e) {
                throw new MenuException("Error when reading entry", e);
            } catch(NumberFormatException e) {
                // The menu is reprinted
            }
        } while (index >= 0);
    }
    
    /**
     * Execute the selected sub-menu
     */
    private void doExec() {
        try {
            Class<?> execClass = Class.forName(exec);
            Constructor<?> constructor = execClass.getConstructor();
            MenuExecutable program = (MenuExecutable) constructor.newInstance();
            program.toDo();
        } catch (ClassNotFoundException e) {
            throw new MenuException("Invalid exec class configuration", e);
        } catch (NoSuchMethodException e) {
            throw new MenuException("Invalid exec class configuration", e);
        } catch (InvocationTargetException e) {
            throw new MenuException("Error instantiating exec class", e);
        } catch (IllegalAccessException e) {
            throw new MenuException("Error instantiating exec class", e);
        } catch (InstantiationException e) {
            throw new MenuException("Error instantiating exec class", e);
        }
    }
    
    /**
     * Print the menu
     */
    private void printMenu() {
        System.out.println(ERS_SCREEN);
        System.out.println(coloredText("# " + title + "\n", GREEN));
        if (text != null) {
            System.out.println(text + "\n");
        }
        for (int i = 0; i < subMenus.size(); i++) {
            System.out.println((i+1) + ". " + subMenus.get(i).getOption());   
        }
        System.out.print("\n0. Salir\n\nEscriba la opcion que desee: ");
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
