package com.esturafd.jtoolkit.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Locale;

import com.esturafd.jtoolkit.console.ansi.Cursor;
import com.esturafd.jtoolkit.console.ansi.Erase;
import com.esturafd.jtoolkit.exception.ConsoleIOException;

import org.apache.commons.lang.StringUtils;

/**
 * Console write and read controller
 * 
 * @author esturafd
 */
public class DefaultConsole implements ConsoleIO {
    
    private BufferedReader reader;
    private InputStreamReader input;
    private PrintStream output;
    private int lastln;

    private static final String READING_ERROR = "Error when reading console";
    private static final String CLOSING_ERROR = "Error when closing console";
    
    public DefaultConsole() {
        output = System.out;
        lastln = 0;
    }
    
    public void print(boolean b) {
        output.print(b);
    }
    
    public void print(char c) {
        output.print(c);
    }
    
    public void print(char[] s) {
        output.print(s);
    }
    
    public void print(double d) {
        output.print(d);
    }
    
    public void print(float f) {
        output.print(f);    
    }
    
    public void print(int i) {
        output.print(i);
    }
    
    public void print(long l) {
        output.print(l);
    }
    
    public void print(Object obj) {
        output.print(obj);
    }
    
    public void print(String s) {
        output.print(s);
    }
    
    public PrintStream printf(Locale l, String format, Object... args) {
        return output.printf(l, format, args);
    }
    
    public PrintStream printf(String format, Object... args) {
        return  output.printf(format, args);
    }
    
    public void println() {
        output.println();
    }
    
    public void println(boolean b) {
        output.println(b);
    }
    
    public void println(char c) {
        output.println(c);
    }
    
    public void println(char[] s) {
        output.println(s);
    }
    
    public void println(double d) {
        output.println(d);
    }
    
    public void println(float f) {
        output.println(f);    
    }
    
    public void println(int i) {
        output.println(i);
    }
    
    public void println(long l) {
        output.println(l);
    }
    
    public void println(Object obj) {
        output.println(obj);
    }
    
    public void println(String s) {
        output.println(s);
    }
    
    public void println(List<? extends Object> l, boolean updatable) {
        if (!l.isEmpty()) {
            if (updatable) {
                returnln();
            }
            lastln = l.size();
            output.println(StringUtils.join(l, "\n"));
        }
    }
    
    public void returnln() {
        returnln(lastln);
    }
    
    public void returnln(int ln) {
        if (ln > 0) {
            output.println(Cursor.up(ln));
            output.println(Erase.DOWN);
        }
    }
    
    public void clean() {
        output.println(Erase.SCREEN);
    }
    
    public int read() {
        int foo = -1;
        initInput();
        try {
            foo = reader.read();
        } catch(IOException e) {
            throw new ConsoleIOException(READING_ERROR, e);
        }
        return foo;
    }
    
    public int read(char[] cbuf, int off, int len) {
        int foo = -1;
        initInput();
        try {
            foo = reader.read(cbuf, off, len);
        } catch(IOException e) {
            throw new ConsoleIOException(READING_ERROR, e);
        }
        return foo;
    }
    
    public String readLine() {
        String foo = null;
        initInput();
        try {
            foo = reader.readLine();
        } catch(IOException e) {
            throw new ConsoleIOException(READING_ERROR, e);
        }
        return foo;
    }
    
    public void close() {
        if (reader != null) {
            try {
                reader.close();
                input.close();
            } catch(IOException e) {
                throw new ConsoleIOException(CLOSING_ERROR, e);
            }
        }
    }
    
    private void initInput() {
        if (reader == null) {
            input = new InputStreamReader(System.in);
            reader = new BufferedReader(input);
        }
    }
}
