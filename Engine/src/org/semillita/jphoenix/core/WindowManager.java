package org.semillita.jphoenix.core;

import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.util.ArrayList;
import java.util.List;

import org.semillita.jphoenix.window.Window;

final class WindowManager {
	private List<WindowImpl> activeWindows;
	private List<WindowImpl> newWindowQueue;
	private List<WindowImpl> closedWindowQueue;
	
	WindowManager() {
		activeWindows = new ArrayList<>();
		newWindowQueue = new ArrayList<>();
		closedWindowQueue = new ArrayList<>();
	}
	
	void addWindow(WindowImpl window) {
		newWindowQueue.add(window);
	}
	
	boolean hasWindows() {
		return !activeWindows.isEmpty();
	}
	
	void update() {
		for(WindowImpl window : activeWindows) {
			window.getListener().onRender();
			
			if(glfwWindowShouldClose(window.getHandle())) {
				if(window.getListener().onClose()) {
					closedWindowQueue.add(window);
				} else {
					glfwSetWindowShouldClose(window.getHandle(), false);
				}
			}
		}
		
		glfwPollEvents();
		updateWindowQueues();
	}
	
	void updateWindowQueues() {
		newWindowQueue.forEach(window -> window.getListener().onCreate((Window) window));
		activeWindows.addAll(newWindowQueue);
		newWindowQueue.clear();
		
		closedWindowQueue.forEach(window -> glfwDestroyWindow(window.getHandle()));
		activeWindows.removeAll(closedWindowQueue);
		closedWindowQueue.clear();
	}
	
}
