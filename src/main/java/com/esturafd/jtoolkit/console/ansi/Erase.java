package com.esturafd.jtoolkit.console.ansi;

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
	public String getRaw() {
		return ESC + id;
	}

}
