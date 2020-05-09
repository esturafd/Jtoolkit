package com.esturafd.jtoolkit.console;

/**
 * Help class for ANSI console escape sequences
 * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Attribute Attribute}
 * o {@link com.esturafd.jtoolkit.console.ansi.Sequence Sequence}
 * 
 * @author esturafd
 */
@Deprecated
public class Ansi {

    private Ansi() {}
    public static final String ESC = "\033";
    
    // Cursor control
    public static final String CRS_HOME = ESC + "[%d;%dH";
    public static final String CRS_UP = ESC + "[%dA";
    public static final String CRS_DOWN = ESC + "[%dB";
    public static final String CRS_FORWARD = ESC + "[%dC";
    public static final String CRS_BACKWARD = ESC + "[%dD";
    public static final String CRS_FPOSITION = ESC + "[%d;%df";
    
    // Erasing text
    public static final String ERS_ELINE = ESC + "[K";
    public static final String ERS_SLINE = ESC + "[1K";
    public static final String ERS_LINE = ESC + "[2K";
    public static final String ERS_DOWN = ESC + "[J";
    public static final String ERS_UP = ESC + "[1J";
    public static final String ERS_SCREEN = ESC + "[2J";
    
    // Display attributes
    public static final String DISPLAY = ESC + "[%sm";
    public static final String RESET = "0";
    public static final String BRIGHT = "1";
    public static final String DIM = "2";
    public static final String UNDERSCORE = "3";
    public static final String BLINK = "4";
    public static final String REVERSE = "5";
    public static final String HIDDEN = "6";
    
    public static final String BLACK = "30";
    public static final String RED = "31";
    public static final String GREEN = "32";
    public static final String YELLOW = "33";
    public static final String BLUE = "34";
    public static final String MAGENTA = "35";
    public static final String CYAN = "36";
    public static final String WHITE = "37";
    
    public static final String BKG_BLACK = "40";
    public static final String BKG_RED = "41";
    public static final String BKG_GREEN = "42";
    public static final String BKG_YELLOW = "43";
    public static final String BKG_BLUE = "44";
    public static final String BKG_MAGENTA = "45";
    public static final String BKG_CYAN = "46";
    public static final String BKG_WHITE = "47";
    

    /**
     * Formats the attributes to be processed by an ANSI console
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Attribute Attribute}
     * @param attributes 
     * @return the union of the attributes to be sent to the console
     */
    public static String displayAttribute(String... attributes) {
        return String.format(DISPLAY, String.join(";", attributes));
    }
    
    /**
     * Format text to be colored on console
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Text#paint(color, text) paint()}
     * @param text text to be colored
     * @param attributes attributes to take into account for coloring
     * @return the union of the attributes to be sent to the console
     */
    public static String coloredText(String text, String... attributes) {
        return displayAttribute(attributes) + text + displayAttribute(RESET);
    }
    
    /**
     * Move cursor home to {row} and {column}
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#home(int, int) home()}
     * @param row horizontal coordinate for home
     * @param column vertical coordinate for home
     * @return movement attribute to be sent to console
     */
    public static String cursorHome(int row, int column) {
        return String.format(CRS_HOME, row, column);
    }
    
    /**
     * Move cursor to up
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#up(int) up()}
     * @param count Number of lines to move
     * @return movement attribute to be sent to console
     */
    public static String cursorUp(int count) {
        return String.format(CRS_UP, count);
    }
    
    /**
     * Move cursor to dowm
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#down(int) down()}
     * @param count Number of lines to move
     * @return movement attribute to be sent to console
     */
    public static String cursorDown(int count) {
        return String.format(CRS_DOWN, count);
    }
    
    /**
     * Move cursor to right
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#forward(int) forward()}
     * @param count Number of spaces to move
     * @return movement attribute to be sent to console
     */
    public static String cursorForward(int count) {
        return String.format(CRS_FORWARD, count);
    }
    
    /**
     * Move cursor to left
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#backward(int) backward()}
     * @param count Number of spaces to move
     * @return movement attribute to be sent to console
     */
    public static String cursorBackward(int count) {
        return String.format(CRS_BACKWARD, count);
    }
    
    /**
     * Move cursor to position
     * @deprecated Use {@link com.esturafd.jtoolkit.console.ansi.Cursor#home(int, int) home()}
     * @param row Horizontal position
     * @param column Vertical position
     * @return movement attribute to be sent to console
     */
    public static String cursorPosition(int row, int column) {
        return String.format(CRS_FPOSITION, row, column);
    }
}
