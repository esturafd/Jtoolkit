package com.esturafd.jtoolkit.console.ansi;

/**
 * General or basic display attributes
 * @author esturafd
 */
public enum Display implements Sequence, Attribute {
	
	RESET("0"),
	BRIGHT("1"),
	DIM("2"),
	UNDERSCORE("4"),
	BLINK("5"),
	REVERSE("7"),
	HIDDEN("8");

	private String id;
	
	Display(String id) {
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
