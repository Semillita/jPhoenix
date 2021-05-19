package org.semillita.jphoenix.window;

public interface WindowListener {

	public void onCreate(Window window);
	
	public void onRender();
	
	public boolean onClose();
	
}
