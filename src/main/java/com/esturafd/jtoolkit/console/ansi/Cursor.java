package com.esturafd.jtoolkit.console.ansi;

public class Cursor {
	
	private static final String HOME = "[%d;%dH";
	private static final String UP = "[%dA";
	private static final String DOWN = "[%dB";
	private static final String FORWARD = "[%dC";
	private static final String BACKWARD = "[%dD";
	
	private static Sequence sequence(final String func) {
		return new Sequence() {
			
			@Override
			public String getRaw() {
				return ESC + func;
			}
			
			public String toString() {
				return getRaw();
			}
		};
	}

	public static Sequence home(int row, int column) {
		return sequence(String.format(HOME, row, column));
	}
	
	public static Sequence up(int count) {
		return sequence(String.format(UP, count));
	}
	
	public static Sequence down(int count) {
		return sequence(String.format(DOWN, count));
	}
	
	public static Sequence forward(int count) {
		return sequence(String.format(FORWARD, count));
	}
	
	public static Sequence backward(int count) {
		return sequence(String.format(BACKWARD, count));
	}
}
