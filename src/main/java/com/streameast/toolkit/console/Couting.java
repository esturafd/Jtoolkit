package com.streameast.toolkit.console;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * This class is a tool for the limitation of time of a cycle in console
 * 
 * @autor streameast
 */
public class Couting {
    
    private int pointer;
    private int maxNumber;
    private String messageTimeOut = "";
    private String messageExit = "";
    
    public Couting(int maxNumber) {
        this.pointer = 0;
        this.maxNumber = maxNumber;
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
        Scanner console = new Scanner(System.in);
        try {
            do {
                System.out.println(messageTimeOut);
                answer = getAnswer(console);
                if (answer != null) {
                    yes = answer.equals("Y") || answer.equals("y");
                    no = answer.equals("N") || answer.equals("n");
                }
            } while (answer != null && !(yes || no));
        } finally {
            console.close();
        }
        return false;
    }
    
    /**
     * This method takes the user's response
     * 
     * @return String answer
     */
    private String getAnswer(Scanner console) {
        String foo = null;
        try {
            FutureTask<String> fTask = new FutureTask<String>(new Callable<String>() {
                public String call() {
                    return console.nextLine();
                }
            });
            foo = fTask.get(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println("\n" + messageExit);
        }
        return foo;
    }
}
