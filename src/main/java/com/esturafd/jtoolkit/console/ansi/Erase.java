package com.esturafd.jtoolkit.console.ansi;

/**
 * <p>List of erase commands supported by ANSI console</p>
 * @author esturafd
 */
public enum Erase implements Sequence {
	
	END_LINE("[K"),
	START_LINE("[1K"),
	LINE("[2K"),
	DOWN("[J"),
	UP("[1J"),
	SCREEN("[2J");
	
	private String id;
	
	Erase(String id) {
		this.id = id;
	}

	@Override
	public String getCode() {
		return id;
	}

	@Override
	public String toString() {
		return ESC + id;
	}
}
