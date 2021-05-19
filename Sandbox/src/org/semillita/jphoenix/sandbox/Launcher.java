package org.semillita.jphoenix.sandbox;

import org.semillita.jphoenix.core.JPhoenixApp;
import org.semillita.jphoenix.core.JPhoenixApp.JPhoenixAppListener;
import org.semillita.jphoenix.window.WindowConfig;

public class Launcher {

	public static void main(String[] args) {
		new JPhoenixApp(new JPhoenixAppListener() {

			@Override
			public void onCreate(JPhoenixApp app) {
				WindowConfig config1 = new WindowConfig();
				config1.transparentFrameBuffer = true;
				app.createWindow(new TestWindow(), config1);
				
				WindowConfig config2 = new WindowConfig();
				config2.transparentFrameBuffer = false;
				app.createWindow(new TestWindow(), config2);
			}

			@Override
			public void onUpdate() {
			}

			@Override
			public void onClose() {
				System.out.println("Application closed");
			}
		});
	}
	
}