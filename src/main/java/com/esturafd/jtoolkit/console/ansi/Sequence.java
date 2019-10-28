package com.esturafd.jtoolkit.console.ansi;

/**
 * ANSI terminal control escape sequences
 * 
 * @author esturafd
 */
public interface Sequence {

	/**
	 * ASCII "escape" character
	 */
	public static final String ESC = "\033";
	
	/**
	 * @return Complete sequence
	 */
	public String getSequence();
	
	/**
	 * @return Sequence code
	 */
	public String toString();
}
