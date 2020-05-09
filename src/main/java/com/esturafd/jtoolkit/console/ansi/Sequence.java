package com.esturafd.jtoolkit.console.ansi;

/**
 * <p>Execution sequence compatible with ANSI console 
 * (Linux, Cygwin, WSL), when printed in console they 
 * modify the behavior of the console, being able to move 
 * the cursor, delete already written text, color the 
 * text to be written, etc.</p>
 * 
 * @see com.esturafd.jtoolkit.console.ansi.Erase Erase
 * @see com.esturafd.jtoolkit.console.ansi.Cursor Cursor
 * @see com.esturafd.jtoolkit.console.ansi.Text Text
 * @see com.esturafd.jtoolkit.console.ansi.Background Background
 * @see com.esturafd.jtoolkit.console.ansi.Display Display
 * @author esturafd
 */
public interface Sequence {

	/**
	 * ASCII "escape" character
	 */
	public static final String ESC = "\033";
	
	/**
	 * @return the raw attribute code
	 */
	public String getCode();
}
