package game;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Screen {
	private GraphicsDevice gd;
	public static JFrame window;
	public Screen() {
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		gd = env.getDefaultScreenDevice();
	}

	public DisplayMode getCurrentDisplayMode() {
		return gd.getDisplayMode();
	}

	public int getDefaultHeight() {
		return gd.getDisplayMode().getHeight();
	}

	public int getDefaultWidth() {
		return gd.getDisplayMode().getWidth();
	}

	public Window getFullScreenWindow() {
		return gd.getFullScreenWindow();
	}

	public void restoreScreen(JFrame window) {
		Window w = gd.getFullScreenWindow();
		if (w != null) {
			w.dispose();
		}
		fullscreen.t.stop();
		if(Sharedvars.fullscreen){
			gd.setFullScreenWindow(null); // Get out of full-screen mode
		}else{
			window.setVisible(false);
		}
	}

	public void setFullScreen(DisplayMode dm ,JFrame window) {
		fullscreen.t.start();
		if(Sharedvars.fullscreen){
			gd.setFullScreenWindow(window);
		}else{
			window.dispose();
			window.setTitle("The Chicken Empire");
			window.setSize(1050, 750);
			window.setUndecorated(true);
			window.setVisible(true);
			ImageIcon chicken = new ImageIcon("Data/Images/Chicken.png");
			window.setIconImage(chicken.getImage());
		}
		if (dm != null && gd.isDisplayChangeSupported()) {
			try {
				gd.setDisplayMode(dm);
			} catch (Exception ex) {
				// ignore exceptions, perhaps I should do some error detection
				// here
			}
		}
		System.out.println("full scr");
	}
	public static void setframe(JFrame window1) {
		(window) = window1;
	}
}
