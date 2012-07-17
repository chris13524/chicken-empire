package game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChickenE extends JFrame {
	public static Screen s;
	public static Market m;
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		System.out.println("Start program");
		methods.playSound();
		run();
		/*
		while(true){
			if(!methods.clip.isRunning()){
				Sharedvars.song = "Data/Sound/Chicken_Dance.wav";
				methods.playSound();
				Menu.mute(false);
			}
		}
		*/
	}

	public static void run() {
		m = new Market();
		s = new Screen();
		int windowheight = s.getDefaultHeight();
		int windowwidth = s.getDefaultWidth();
		System.out.println("screen.Height = " + windowheight);
		System.out.println("screen.Width = " + windowwidth);
		if (s.getDefaultHeight() < 750 || s.getDefaultWidth() < 1050) {
			JOptionPane
			.showMessageDialog(
					null,
					"Sorry, but your screen size is smaller\nthen the recommended size. Please\najust your resolution to at least 1050x750.\nYou may continue at your own risk if you want.",
					"Bad Screen Size", JOptionPane.ERROR_MESSAGE);
		}
		Menu menu = new Menu();
		menu.setSize(300, 300);
		menu.setVisible(true);
		menu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

}
