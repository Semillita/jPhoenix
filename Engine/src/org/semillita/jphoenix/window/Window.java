package org.semillita.jphoenix.window;

public interface Window {

	/*Returns the width of the window**/
	public int getWidth();
	
	/*Returns the height of the window**/
	public int getHeight();
	
	/*Returns whether or not the window is in fullscreen mode**/
	public boolean isFullscreen();
	
	/*Sets the window to fullscreen mode**/
	public void setFullscreen();
	
	/*Closes the window if the onClose() method of the window's listener 
	 * returns true**/
	public void close();
	
	/*Closes the window immediately**/
	public void closeAbsolute();
	
	public enum Mode {
		WINDOWED,
		FULLSCREEN,
		ICONIFIED;
	}
	
}
