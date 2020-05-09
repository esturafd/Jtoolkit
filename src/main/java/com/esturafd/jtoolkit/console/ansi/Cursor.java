package com.esturafd.jtoolkit.console.ansi;

/**
 * public class <b>Cursor</b>
 * 
 * <p>Help class in handling the cursor in an ANSI console, if the 
 * output corresponds to an ANSI compatible console (Linux), to 
 * move the course it can be done in this way:</p>
 * 
 * <code>
 * System.out.prinln(Cursor.up(2));
 * </code>
 * 
 */
public class Cursor {
	
	Cursor() {}
	private static final String HOME = "[%d;%dH";
	private static final String UP = "[%dA";
	private static final String DOWN = "[%dB";
	private static final String FORWARD = "[%dC";
	private static final String BACKWARD = "[%dD";
	
	private static Sequence sequence(final String func) {
		return new Sequence() {
			
			@Override
			public String getCode() {
				return func;
			}
			
			@Override
			public String toString() {
				return ESC + func;
			}
		};
	}

	/**
	 * Move the cursor home to the coordinates {row}, {column}
	 * @param row 
	 * @param column
	 * @return Action sequence to be interpreted by the console
	 */
	public static Sequence home(int row, int column) {
		return sequence(String.format(HOME, row, column));
	}
	
	/**
	 * Move cursor up {count} lines
	 * @param count Number of lines to move up
	 * @return Action sequence to be interpreted by the console
	 */
	public static Sequence up(int count) {
		return sequence(String.format(UP, count));
	}
	
	/**
	 * Move cursor down {count} lines
	 * @param count Number of lines to move down
	 * @return Action sequence to be interpreted by the console
	 */
	public static Sequence down(int count) {
		return sequence(String.format(DOWN, count));
	}
	
	/**
	 * Move the cursor {count} lines to right
	 * @param count Number of spaces to move to right
	 * @return Action sequence to be interpreted by the console
	 */
	public static Sequence forward(int count) {
		return sequence(String.format(FORWARD, count));
	}
	
	/**
	 * Move the cursor {count} lines to left 
	 * @param count Number of spaces to move to left
	 * @return Action sequence to be interpreted by the console
	 */
	public static Sequence backward(int count) {
		return sequence(String.format(BACKWARD, count));
	}
}
