package game;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.methods;

public class fullscreen extends JFrame {
	final static int FULL_LAND_WIDTH = 750;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private class Handlerclass implements MouseListener, MouseMotionListener {
		private int whichLandDidIClick(MouseEvent event) {
			int xCoord = (int) Math.floor(event.getX() / 150);
			int yCoord = (int) Math.floor(event.getY() / 150);
			return yCoord * 5 + xCoord;
		}
		public int dayonwindowdown;
		private String landTypeForClick(MouseEvent event) {
			int landIndex = whichLandDidIClick(event);
			return Sharedvars.land[landIndex];
		}
		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getX() >= 750 && event.getX() <= 1050
					&& event.getY() >= 650 && event.getY() <= FULL_LAND_WIDTH) {
				System.out.println("screen.restore");
				ChickenE.s.restoreScreen(fullscreen.this);
			}
			if (event.getX() < 750 && event.getY() < 750) {
				buttonsa = landTypeForClick(event);
				buttonsb = whichLandDidIClick(event);
			}
			if (buttonsa == null) {
				if (event.getX() >= 750 && event.getX() <= 1050
						&& event.getY() >= 360 && event.getY() <= 385) {
					methods.selleggs();
				}
				if (event.getX() >= 750 && event.getX() <= 1050
						&& event.getY() >= 410 && event.getY() <= 435) {
					methods.buyfood();
				}
			} else {
				if (buttonsa == "land") {
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 275 && event.getY() < 310) {
						if (methods.hasEnoughMoney(Sharedvars.priceofland)) {
							Sharedvars.land[buttonsb] = "bland";
							Sharedvars.money = Sharedvars.money
									- Sharedvars.priceofland;
							buttonsa = "bland";
						}
					}
				} else if (buttonsa == "bland") {
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 275 && event.getY() < 310) {
						Sharedvars.land[buttonsb] = "land";
						Sharedvars.money = Sharedvars.money
								+ Sharedvars.priceofland;
						buttonsa = "land";
					} else if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 310 && event.getY() < 345) {
						if (methods.hasEnoughMoney(Sharedvars.priceofhouse)) {
							Sharedvars.land[buttonsb] = "house";
							Sharedvars.money = Sharedvars.money
									- Sharedvars.priceofhouse;
							buttonsa = "house";
						}
					} else if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 345 && event.getY() < 380) {
						if (methods.hasEnoughMoney(Sharedvars.priceoffarm)) {
							Sharedvars.land[buttonsb] = "farm";
							Sharedvars.money = Sharedvars.money
									- Sharedvars.priceoffarm;
							buttonsa = "farm";
						}
					} else if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 380 && event.getY() < 415) {
						if (methods.hasEnoughMoney(Sharedvars.priceofrc)) {
							Sharedvars.land[buttonsb] = "rc";
							Sharedvars.money = Sharedvars.money
									- Sharedvars.priceofrc;
							buttonsa = "rc";
						}
					}
				} else if (buttonsa == "house") {
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 275 && event.getY() < 310) {
						Sharedvars.land[buttonsb] = "bland";
						Sharedvars.money = Sharedvars.money
								+ Sharedvars.priceofhouse;
						buttonsa = "bland";
						Sharedvars.chickens[buttonsb] = 0;
					}
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 310 && event.getY() < 345) {
						if (methods.hasEnoughMoney(Sharedvars.priceofchicken)
								&& Sharedvars.chickens[buttonsb] < Sharedvars.chickenlimit) {
							Sharedvars.chickens[buttonsb] = Sharedvars.chickens[buttonsb] + 1;
							Sharedvars.money = Sharedvars.money
									- Sharedvars.priceofchicken;
						}
					}
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 380 && event.getY() < 415) {
						if (Sharedvars.chickens[buttonsb] - 1 >= 0) {
							Sharedvars.chickens[buttonsb] = Sharedvars.chickens[buttonsb] - 1;
							if (Sharedvars.priceofchicken - 10 < 0) {
							} else {
								Sharedvars.money = Sharedvars.money
										+ (Sharedvars.priceofchicken - 10);
							}
						}
					}
				} else if (buttonsa == "farm") {
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 275 && event.getY() < 310) {
						Sharedvars.land[buttonsb] = "bland";
						Sharedvars.money = Sharedvars.money
								+ Sharedvars.priceoffarm;
						buttonsa = "bland";
					}
				} else if (buttonsa == "rc") {
					if (event.getX() > 750 && event.getX() < 1050
							&& event.getY() > 275 && event.getY() < 310) {
						Sharedvars.land[buttonsb] = "bland";
						Sharedvars.money = Sharedvars.money
								+ Sharedvars.priceofrc;
						buttonsa = "bland";
					}
				}
				if (event.getX() > 1050 || event.getY() > 750
						|| (event.getY() < 270 && event.getX() > 750)) {
					buttonsa = null;
					buttonsb = 0;
				}
			}
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent event) {
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		public void mouseMoved(MouseEvent event) {
			if (!Sharedvars.fullscreen) {
				if (event.getX() > 750 && event.getX() < 1050
						&& event.getY() < 200 && event.getY() > 0) {
					if (!Sharedvars.fullscreen && Screen.window.isUndecorated()) {
						Screen.window.dispose();
						Screen.window.setUndecorated(false);
						Screen.window.setVisible(true);
						dayonwindowdown = Sharedvars.day;
					}
				} else {
					if (dayonwindowdown <= Sharedvars.day - 1
							&& !Screen.window.isUndecorated()) {
						Screen.window.dispose();
						Screen.window.setUndecorated(true);
						Screen.window.setVisible(true);
						dayonwindowdown = 0;
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent event) {
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
	}

	public String buttonsa;
	public int buttonsb;
	public static javax.swing.Timer t;
	public Image background;
	public DisplayMode dm;
	public boolean imagesAreLoaded = false;
	public Image land;
	public Image title;
	public Image bland;
	public Image rc;
	public Image farm;
	public Image house;
	
	public fullscreen() {
		for (int i = 0; i < 25; i++) {
			Sharedvars.chickens[i] = 0;
		}
		t = new javax.swing.Timer((int) (Sharedvars.daylength * 1000),
				new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextday();
			}
		});
		dm = ChickenE.s.getCurrentDisplayMode();
		if (Sharedvars.land[0] == null) {
			for (int i = 0; i < 25; i++) {
				Sharedvars.land[i] = "land";
			}
		}
		loadImages();
		//main panel
		JPanel mousepanel;
		mousepanel = new JPanel(new BorderLayout());
		mousepanel.setBounds(0, 0, 1500, 1000);
		mousepanel.setBackground(Color.RED);
		add(mousepanel);
		Handlerclass handler = new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		setForeground(new Color(60, 200, 60));
		setBackground(Color.BLACK);
		setFont(new Font("Arial", Font.PLAIN, 24));
		Screen.setframe(this);
	}

	public void loadImages() {
		title = new ImageIcon("C:/Users/Chris/Documents/TheChickenEmpire/Game/Data/Images/Title.jpg").getImage();
		background = new ImageIcon("Data/Images/Background.jpg").getImage();
		land = new ImageIcon("Data/Images/Land.jpg").getImage();
		bland = new ImageIcon("Data/Images/Bought_Land.jpg").getImage();
		rc = new ImageIcon("Data/Images/Research_Center.jpg").getImage();
		farm = new ImageIcon("Data/Images/Farm.jpg").getImage();
		house = new ImageIcon("Data/Images/House.jpg").getImage();
		System.out.println("screen.Images loaded");
		imagesAreLoaded = true;
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("repaint");
		if (imagesAreLoaded) {
			int imagex = 0;
			int imagey = 0;
			for (int i = 0; i < 20; i++) {
				imagex = i * 100;
				for (int i1 = 0; i1 < 20; i1++) {
					imagey = i1 * 120;
					if (i <= 9 && i1 <= 5) {
					} else {
						g.drawImage(background, imagex, imagey, null);
					}
				}
			}
			g.drawImage(title, 750, 0, null);
			for (int i = 0; i < 5; i++) {
				int landy = i * 150;
				for (int loop = 0; loop < 5; loop++) {
					int landx = loop * 150;
					String thisPlot = Sharedvars.land[i * 5 + loop];
					if (thisPlot == "land") {
						g.drawImage(land, landx, landy, null);
					} else if (thisPlot == "bland") {
						g.drawImage(bland, landx, landy, null);
					} else if (thisPlot == "rc") {
						g.drawImage(rc, landx, landy, null);
					} else if (thisPlot == "farm") {
						g.drawImage(farm, landx, landy, null);
					} else if (thisPlot == "house") {
						g.drawImage(house, landx, landy, null);
					}
				}
			}
		} else {
			System.out.println("screen.images not loaded");
		}
		Sharedvars.money = Math.round(100 * Sharedvars.money) / ((double) 100);
		g.setColor(Color.CYAN);
		g.fillRect(750, 650, 300, 100);
		g.setColor(Color.blue);
		g.drawString("Menu", 870, 710);
		if (buttonsa != null) {
			{
				int a = buttonsb;
				int b = 0;
				while (a > 4) {
					a = a - 5;
					b++;
				}
				g.setColor(Color.YELLOW);
				g.drawRect(a * 150, b * 150, 150, 150);
			}
			g.setColor(Color.RED);
			if (buttonsa == "land") {
				g.drawString("Buy Land for $" + Sharedvars.priceofland, 750,
						310);
				if (methods.hasEnoughMoney(Sharedvars.priceofland)) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 300, 950, 300);
					g.setColor(Color.RED);
				}
			} else if (buttonsa == "bland") {
				g.drawString("Sell Land for $" + Sharedvars.priceofland, 750,
						310);
				g.drawString("Buy a House for $" + Sharedvars.priceofhouse,
						750, 345);
				if (methods.hasEnoughMoney(Sharedvars.priceofhouse)) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 335, 980, 335);
					g.setColor(Color.RED);
				}
				g.drawString("Buy a Farm for $" + Sharedvars.priceoffarm, 750,
						380);
				if (methods.hasEnoughMoney(Sharedvars.priceoffarm)) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 370, 970, 370);
					g.setColor(Color.RED);
				}
				g.drawString("Buy a RC for $" + Sharedvars.priceofrc, 750, 415);
				if (methods.hasEnoughMoney(Sharedvars.priceofrc)) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 405, 950, 405);
					g.setColor(Color.RED);
				}
			} else if (buttonsa == "rc") {
				g.drawString("Sell RC for $" + Sharedvars.priceofrc, 750, 310);
			} else if (buttonsa == "farm") {
				g.drawString("Sell Farm for $" + Sharedvars.priceoffarm, 750,
						310);
			} else if (buttonsa == "house") {
				g.drawString("Sell House for $" + Sharedvars.priceofhouse, 750,
						310);
				g.drawString("Buy a Chicken for $" + Sharedvars.priceofchicken,
						750, 345);
				g.setColor(Color.BLUE);
				g.drawString("Chickens = " + Sharedvars.chickens[buttonsb],
						750, 380);
				g.setColor(Color.RED);
				if (Sharedvars.priceofchicken - 10 < 0) {
					g.drawString("Sell a Chicken for $0", 750, 415);
				} else {
					g.drawString("Sell a Chicken for $"
							+ (Sharedvars.priceofchicken - 10), 750, 415);
				}
				if (methods.hasEnoughMoney(Sharedvars.priceofchicken)
						&& Sharedvars.chickens[buttonsb] < Sharedvars.chickenlimit) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 337, 1000, 337);
					g.setColor(Color.RED);
				}
				if (Sharedvars.chickens[buttonsb] - 1 >= 0) {
				} else {
					g.setColor(Color.BLACK);
					g.drawLine(750, 407, 1000, 407);
					g.setColor(Color.RED);
				}
			}
		} else {
			// -----------------------------------Main Menu
			g.setColor(Color.BLUE);
			g.drawString(
					"Day = " + Sharedvars.day + " Year = "
							+ (int) Math.floor(Sharedvars.day / 365), 750, 285);
			g.drawString("Money = $" + Sharedvars.money, 750, 310);
			g.drawString("Eggs = " + Sharedvars.eggs + "/" + Sharedvars.eggcap,
					750, 335);
			g.drawString("Price of an egg = $" + Sharedvars.priceofegg, 750,
					360);
			g.setColor(Color.RED);
			g.drawString(
					"Sell "
							+ Sharedvars.eggs
							/ 12
							+ " dozen for $"
							+ Math.round(100 * (Sharedvars.priceofegg * (Sharedvars.eggs / 12)) * 12)
							/ ((double) 100), 750, 385);
			g.setColor(Color.BLUE);
			g.drawString("Food   = " + Sharedvars.food + "/"
					+ Sharedvars.foodcap, 750, 410);
			g.setColor(Color.RED);
			g.drawString("Buy 100 for $" + Sharedvars.priceoffood, 750, 435);
			if (methods.hasEnoughMoney(Sharedvars.priceoffood)) {
			} else {
				g.setColor(Color.BLACK);
				g.drawLine(750, 425, 950, 425);
				g.setColor(Color.RED);
			}
			{// In bracket to separate variables
				int a = 0;
				int b = 0;
				for (int i = 0; i < 25; i++) {
					a = a + Sharedvars.chickens[i];
					if (Sharedvars.land[i] == "house") {
						b = b + Sharedvars.chickenlimit;
					}
				}
				g.setColor(Color.BLUE);
				g.drawString("Chickens = " + a + "/" + b, 750, 460);
				g.setColor(Color.RED);
			}
		}
	}

	public void run() {
		try {
			ChickenE.s.setFullScreen(dm , this);
			ChickenE.m.market();
			System.out.println("screen.fullscreen");
		} finally {
		}
		repaint();
	}

	private void nextday() {
		Sharedvars.day++;
		System.out.println("Next day; " + Sharedvars.day);
		System.out.println("Money =  " + Sharedvars.money);
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < Sharedvars.chickens[i]; j++) {
				if (methods.random(1, 3) != 1) {
					Sharedvars.eggs++;
				}
				Sharedvars.food--;
			}
		}
		for (int i = 0; i < 25; i++) {
			if (Sharedvars.land[i] == "farm") {
				Sharedvars.food = Sharedvars.food + Sharedvars.foodproduction;
			}
		}
		/*
		// /////////////////////////////////////////////////////
		if (Sharedvars.priceofegg == 0.2
				|| Sharedvars.eggs >= Sharedvars.eggcap) {
			methods.selleggs();
		}
		while ((Sharedvars.food < Sharedvars.foodcap - 300 && Sharedvars.priceoffood == 1)
				|| Sharedvars.food < 100) {
			methods.buyfood();
		}
		// /////////////////////////////////////////////////////
		 */
		while (Sharedvars.food < 0) {
			int a = methods.random(0, 24);
			while (Sharedvars.chickens[a] == 0) {
				a = methods.random(0, 24);
			}
			Sharedvars.chickens[a]--;
			Sharedvars.food++;
		}
		if (Sharedvars.eggs > Sharedvars.eggcap) {
			Sharedvars.eggs = Sharedvars.eggcap;
		}
		if (Sharedvars.food > Sharedvars.foodcap) {
			Sharedvars.food = Sharedvars.foodcap;
		}
		ChickenE.m.market();
		repaint();
		if(methods.iswhole(Sharedvars.day/Sharedvars.taxhowoften)){
			ChickenE.s.restoreScreen(this);
			JOptionPane.showMessageDialog(null, "Tax day!\nToday is tax day. You will have to pay " + (Sharedvars.taxrate*100) + "%. Which is $" + methods.roundmoney(Sharedvars.taxrate*Sharedvars.money), "Tax day!", JOptionPane.PLAIN_MESSAGE);
			Sharedvars.money = methods.roundmoney(Sharedvars.money - Sharedvars.taxrate*Sharedvars.money);
			ChickenE.s.setFullScreen(dm, this);
		}
	}
	
}
