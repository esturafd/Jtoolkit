package com.esturafd.jtoolkit.console.ansi;

/**
 * Text Color Attributes
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
	WHITE("37");
	
	private String id;
	
	Text(String id) {
		this.id = id;
	}

	@Override
	public String getRaw() {
		return ESC + String.format(FORMAT, id);
	}
	
	public String toString() {
		return id;
	}
}
