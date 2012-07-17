package game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menu extends JFrame {
	private class Handlerclass implements ActionListener, ItemListener {
		@Override
		public void actionPerformed(final ActionEvent event) {
			if (event.getActionCommand() == "Exit") {
				System.out.println("system.exit");
				System.exit(0);
			}
			if (event.getActionCommand() == "Play") {
				if (Sharedvars.day == 1) {
					JOptionPane.showMessageDialog(null, Sharedvars.inst,
							"Instructions", JOptionPane.PLAIN_MESSAGE);
				}
				Menu.fs.run();
			}
			if (event.getActionCommand() == "Instructions") {
				JOptionPane.showMessageDialog(null, Sharedvars.inst,
						"Instructions", JOptionPane.PLAIN_MESSAGE);
			}
		}

		@Override
		public void itemStateChanged(ItemEvent event) {
			if (mute.isSelected()) {
				mute(true);
			} else {
				mute(false);
			}
			if (fullscreen.isSelected()) {
				Sharedvars.fullscreen = true;
			} else {
				Sharedvars.fullscreen = false;
			}
		}
	}

	static game.fullscreen fs;
	private static final long serialVersionUID = 1L;
	ImageIcon chicken = new ImageIcon("Data/chicken.png");
	private final JButton exit;
	private final JButton inst;
	private final JButton play;
	public static JCheckBox mute;
	public static JCheckBox fullscreen;

	public Menu() {
		this.setTitle("The Chicken Empire");
		ImageIcon chicken = new ImageIcon("Data/Images/Chicken.png");
		this.setIconImage(chicken.getImage());
		setLayout(new FlowLayout());
		final Handlerclass handler = new Handlerclass();
		play = new JButton("Play");
		add(play);
		play.addActionListener(handler);
		exit = new JButton("Exit");
		add(exit);
		exit.addActionListener(handler);
		inst = new JButton("Instructions");
		add(inst);
		inst.addActionListener(handler);
		mute = new JCheckBox("Mute");
		add(mute);
		if(Sharedvars.mute){
			mute(Sharedvars.mute);
		}else{
			mute(Sharedvars.mute);
		}
		mute.addItemListener(handler);
		fullscreen = new JCheckBox("Fullscreen");
		add(fullscreen);
		fullscreen.addItemListener(handler);
		System.out.println("Menu created");
		Menu.fs = new fullscreen();
		if(!fs.imagesAreLoaded){
			JOptionPane.showMessageDialog(null, "Some of the requred images where not found.\nPlease try reinstalling the program to fix this probem.", "ERROR", JOptionPane.PLAIN_MESSAGE);
		}
	}
	public static void mute(boolean ismute){
		if(ismute){
			methods.clip.stop();
			Sharedvars.mute = true;
			mute.setSelected (true);
		}else{
			methods.clip.start();//loop(Clip.LOOP_CONTINUOUSLY);
			Sharedvars.mute = false;
			mute.setSelected (false);
		}
	}
}
