package com.esturafd.jtoolkit.console;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.esturafd.jtoolkit.yml.MapProperties;

/**
 * This class is a tool for the limitation of time of a cycle in console
 * 
 * @author esturafd
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
            console.print(timeoutMessage);
            answer = getAnswer();
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
    private String getAnswer() {
        String foo = null;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> fTask = executor.submit(new Callable<String>() {
            public String call() throws Exception {
                return console.readLine();
            }
        });
        try {
            foo = fTask.get(1, TimeUnit.MINUTES);
        } catch (TimeoutException e) {
            exit();
        } catch (InterruptedException e) {
            exit();
        } catch (ExecutionException e) {
            exit();
        }
        return foo;
    }
    
    /**
     * This method ends the waiting for a response
     */
    private void exit() {
        console.println(exitMessage);
        System.exit(0);
    }
}
