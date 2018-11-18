package com.streameast.toolkit.console;

/**
 * This class contains the codes for the color changes in the fonts of the linux output
 */
public class Color {
    
    // Color of fonts
    public static final String RESET = "\u001B[00m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	// Color of background
	public static final String BK_BLACK = "\u001B[40m";
	public static final String BK_RED = "\u001B[41m";
	public static final String BK_GREEN = "\u001B[42m";
	public static final String BK_YELLOW = "\u001B[43m";
	public static final String BK_BLUE = "\u001B[44m";
	public static final String BK_PURPLE = "\u001B[45m";
	public static final String BK_CYAN = "\u001B[46m";
	public static final String BK_WHITE = "\u001B[47m";
	
	/**
	 * This method returns the text entered colored with the indicated color
	 */
	public static String coloredText(String color, String texto) {
		return color + texto + RESET;
	}
}
