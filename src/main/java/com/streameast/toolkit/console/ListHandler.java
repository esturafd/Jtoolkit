package com.streameast.toolkit.console;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * This class handles the printing of a list in a console
 * 
 * @autor streameast
 */
public class ListHandler {
    
    private int lastSize;
    private final String CURSORUP = "\033[%dA";
    private final String ERASELINE = "\033[2K";
    private final String ERASESCREEN = "\033[2J";
    
    public ListHandler() {
        lastSize = 0;
    }
    
    /**
     * This method prints a list of objects
     */
    public void print(List<? extends Object> list) {
        if (list.size() > 0) {
            lastSize = list.size();
            System.out.println(StringUtils.join(list, "\n"));
        }
    }
    
    /**
     * This method prints a list of objects, which can be updated
     */
    public void updatingPrint(List<? extends Object> list) {
        if (list.size() > 0) {
            returnLines();
            print(list);
        }
    }
    
    /**
     * Returns lines in console, preparing the reprinting
     */
    public void returnLines(int numLines) {
        if (numLines > 0) {
            System.out.println(String.format(CURSORUP, numLines));
            System.out.println(ERASELINE);
        }
    }

    /**
     * Retorna lineas de la anterior lista en consola, preparando la reimpresion
     */
    public void returnLines() {
        returnLines(lastSize);
    }
    
    /**
     * Clean the console
     */
    public void clean() {
        System.out.println(ERASESCREEN);
    }
}
