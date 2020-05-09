package com.esturafd.jtoolkit.console.ansi;

/**
 * public enum <b>Text</b>
 * <p>List of colors supported by text on an ANSI console</p>
 * @author esturafd
 */
public enum Text implements Sequence, Attribute {
	
	BLACK("30"),
	RED("31"),
	GREEN("32"),
	YELLOW("33"),
	BLUE("34"),
	MAGENTA("35"),
	CYAN("36"),
	WHITE("37"),
	RESET("0");
	
	private String id;
	
	Text(String id) {
		this.id = id;
	}

	/**
	 * Paint the text in ANSI console
	 * @param color text color
	 * @param text text to be colored
	 * @return text to be sent to the console
	 */
	public static String paint(Text color, String text) {
		return String.format("%s%s%s", color, text, Text.RESET);
	}

	@Override
	public String getCode() {
		return id;
	}
	
	public String toString() {
		return ESC + String.format(FORMAT, id);
	}
}
