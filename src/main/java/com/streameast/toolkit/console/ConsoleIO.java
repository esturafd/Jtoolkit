package com.streameast.toolkit.console;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;

public interface ConsoleIO {
    
    // Out
    public void print(boolean b);
    public void print(char c);
    public void print(char[] s);
    public void print(double d);
    public void print(float f);
    public void print(int i);
    public void print(long l);
    public void print(Object obj);
    public void print(String s);
    public PrintStream printf(Locale l, String format, Object... args);
    public PrintStream printf(String format, Object... args);
    public void println();
    public void println(boolean b);
    public void println(char c);
    public void println(char[] s);
    public void println(double d);
    public void println(float f);
    public void println(int i);
    public void println(long l);
    public void println(Object obj);
    public void println(String s);
    public void println(List<Object> l, boolean updatable);
    public void returnln();
    public void returnln(int ln);
    public void clean();
    
    // Input
    public int read();
    public int read(char[] cbuf, int off, int len);
    public String readLine();
    public void close();
}
