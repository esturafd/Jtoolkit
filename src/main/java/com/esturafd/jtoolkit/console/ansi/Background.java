package com.esturafd.jtoolkit.console.ansi;

/**
 * <p>List of colors supported by the text background on an ANSI console</p>
 * @author eramos
 */
public enum Background implements Sequence, Attribute {

	BLACK("40"),
	RED("41"),
	GREEN("42"),
	YELLOW("43"),
	BLUE("44"),
	MAGENTA("45"),
	CYAN("46"),
	WHITE("47"),
	RESET("0");
	
	private String id;
	
	Background(String id) {
		this.id = id;
	}

	/**
	 * Paint the text background in ANSI console
	 * @param color background color
	 * @param text text to be colored
	 * @return text to be sent to the console
	 */
	public static String paint(Background color, String text) {
		return String.format("%s%s%s", color, text, Background.RESET);
	}
	
	@Override
	public String getCode() {
		return id;
	}
	
	@Override
	public String toString() {
		return ESC + String.format(FORMAT, id);
	}
}
