package com.streameast.toolkit.console;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.streameast.toolkit.yml.MapProperties;

/**
 * This class is a tool for the limitation of time of a cycle in console
 * 
 * @author streameast
 */
public class Counting {
    
    private int pointer;
    private int maxNumber;
    private ConsoleIO console;
    private String timeoutMessage = "A long time passed, you want to continue?(Y/n) ";
    private String exitMessage = "The program is closed.";
    
    public Counting(ConsoleIO console, int maxNumber) {
        this.pointer = 0;
        this.maxNumber = maxNumber;
        this.console = console;
    }
    
    @SuppressWarnings("unchecked")
    public Counting(ConsoleIO console, String config, int maxNumber) {
        this(console, maxNumber);
        Map<String, Object> map = new MapProperties<String, Object>(config);
        if (map.containsKey("stop-messages")) {
            map = (Map<String, Object>) map.get("stop-messages");
        }
        if (map.containsKey("timeout-message") && map.containsKey("exit-message")) {
            timeoutMessage = map.get("timeout-message").toString();
            exitMessage = map.get("exit-message").toString();
        }
    }
    
    /**
     * This method returns a Boolean to control the execution of the cycle
     * 
     * @return boolean
     */
    public boolean count() {
        boolean foo = true;
        if (++pointer >= maxNumber) {
            pointer = 0;
            foo = askToContinue();
        }
        return foo;
    }
    
    /**
     * This is an internal method, which asks for and analyzes the user's response
     * 
     * @return boolean
     */
    private boolean askToContinue() {
        boolean yes = false;
        boolean no = false;
        String answer = null;
        do {
            System.out.print(timeoutMessage);
            answer = getAnswer(console);
            if (answer != null) {
                yes = answer.equals("Y") || answer.equals("y");
                no = answer.equals("N") || answer.equals("n");
            }
        } while (answer != null && !(yes || no));
        return yes;
    }
    
    /**
     * This method takes the user's response
     * 
     * @return String answer
     */
    private String getAnswer(final ConsoleIO console) {
        String foo = null;
        try {
            FutureTask<String> fTask = new FutureTask<String>(new Callable<String>() {
                public String call() {
                    return console.readLine();
                }
            });
            foo = fTask.get(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println("\n" + exitMessage);
        }
        return foo;
    }
}
