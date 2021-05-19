package org.semillita.jphoenix.core;

import static org.lwjgl.glfw.GLFW.*;

import org.semillita.jphoenix.graphics.Graphics;
import org.semillita.jphoenix.window.Window;
import org.semillita.jphoenix.window.WindowConfig;
import org.semillita.jphoenix.window.WindowListener;

final class WindowImpl implements Window {

	private WindowListener listener;
	private long handle;
	
	Graphics graphics;
	
	WindowImpl(WindowListener listener, WindowConfig config) {
		this.listener = listener;
		
		createGLFWWindow(config);
		
		graphics = new VulkanGraphics();
		//glfwSetFramebufferSizeCallback(handle, graphics::framebufferResizeCallback);
	}
	
	private void createGLFWWindow(WindowConfig config) {
		glfwWindowHint(GLFW_RESIZABLE, intOf(config.resizable));
		
		glfwWindowHint(GLFW_VISIBLE, intOf(config.visible));
		
		glfwWindowHint(GLFW_DECORATED, intOf(config.decorated));
		
		glfwWindowHint(GLFW_FOCUSED, intOf(config.focused));
		
		glfwWindowHint(GLFW_AUTO_ICONIFY, intOf(config.autoIconify));
		
		glfwWindowHint(GLFW_FLOATING, intOf(config.floating));
		
		glfwWindowHint(GLFW_MAXIMIZED, intOf(config.maximized));
		
		glfwWindowHint(GLFW_CENTER_CURSOR, intOf(config.centerCursor));
		
		glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, intOf(config.transparentFrameBuffer));
		
		glfwWindowHint(GLFW_FOCUS_ON_SHOW, intOf(config.focusOnShow));
		
		glfwWindowHint(GLFW_SCALE_TO_MONITOR, intOf(config.scaleToMonitor));
		
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);
		
		long monitor = intOf(config.fullscreen) * glfwGetPrimaryMonitor();
				
		handle = glfwCreateWindow(config.width, config.height, config.title, monitor, 0);
		
		if (handle == 0) {
			System.err.println("Failed to create window");
		}
		
		glfwSetWindowPos(handle, config.x, config.y);
		
		glfwShowWindow(handle);
	}
	
	WindowListener getListener() {
		return listener;
	}
	
	long getHandle() {
		return handle;
	}
	
	private int intOf(boolean b) {
		return b ? 1 : 0;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFullscreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFullscreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAbsolute() {
		// TODO Auto-generated method stub
		
	}
}