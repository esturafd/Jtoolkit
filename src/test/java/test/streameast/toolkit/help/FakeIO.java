package test.streameast.toolkit.help;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;

import com.streameast.toolkit.console.ConsoleIO;

public class FakeIO implements ConsoleIO {
    
    private PrintStream output;
    private String[] input;
    private int count;
    
    public FakeIO(String... input) {
        this.output = System.out;
        this.input = input;
        this.count = 0;
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
    
    public void println(List<Object> l, boolean updatable) {}
    
    public void returnln() {}
    
    public void returnln(int ln) {}
    
    public void clean() {}
    
    public int read() {
        return -1;
    }
    
    public int read(char[] cbuf, int off, int len) {
        return -1;
    }
    
    public String readLine() {
        String foo = input[count];
        output.println(foo);
        if (++count >= input.length) {
            count = 0;
        }
        return foo;
    }
    
    public void close() {}
}
