package org.semillita.jphoenix.core;

import org.lwjgl.glfw.GLFW;
import org.semillita.jphoenix.window.WindowConfig;
import org.semillita.jphoenix.window.WindowListener;

public final class JPhoenixApp {

	private JPhoenixAppListener listener;
	private WindowManager windowManager;
	
	public JPhoenixApp(JPhoenixAppListener listener) {
		this.listener = listener;
		
		windowManager = new WindowManager();
		
		GLFW.glfwInit();
		
		create();
		windowManager.updateWindowQueues();
		mainloop();
		close();
	}
		
	public void createWindow(WindowListener listener, WindowConfig config) {
		windowManager.addWindow(new WindowImpl(listener, config));
	}
	
	private void create() {
		//Initialization
		listener.onCreate(this);		
	}
	
	private void mainloop() {
		//Updating
		while(windowManager.hasWindows()) {
			windowManager.update();
		}
	}
	
	private void close() {
		//Close operations
		listener.onClose();
	}
	
	public static interface JPhoenixAppListener {
		
		public void onCreate(JPhoenixApp app);
		
		public void onUpdate();
		
		public void onClose();
		
	}
	
}
