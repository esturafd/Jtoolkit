package com.esturafd.jtoolkit.console.ansi;

/**
 * Text background color attributes
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
	WHITE("47");
	
	private String id;
	
	Background(String id) {
		this.id = id;
	}
	
	@Override
	public String getSequence() {
		return ESC + String.format(FORMAT, id);
	}
	
	public String toString() {
		return id;
	}
}
