package test.streameast.toolkit.help;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ConsoleHandler {
    
    public static void writeConsole(String text) {
        try {
            InputStream input = new ByteArrayInputStream(text.getBytes());
            InputStream oldInput = System.in;
            try {
                Thread.sleep(15000);
                System.setIn(input);
                System.out.println(text);
                Thread.sleep(10000);
            } finally {
                System.setIn(oldInput);
                input.close();
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static String readConsole() {
        String foo = null;
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            try {
                PrintStream print = new PrintStream(output);
                PrintStream oldOutput = new PrintStream(System.out);
                try {
                    System.setOut(print);
                    foo = output.toString();
                    Thread.sleep(10000);
                    System.setOut(oldOutput);
                } finally {
                    print.close();
                }
            } finally {
                output.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return foo;
    }
}
