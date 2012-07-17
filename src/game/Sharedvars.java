package game;

public class Sharedvars {
	public static double daylength = 5;// time in seconds
	public static final String inst = "The Chicken Empire\nThis is the main menu. You can load a previous game session here by chicking load, or you can start a new game by fullscreening.";
	public static int blimit = -100;
	public static String song = "Data/Sound/BeethovenSymphonyNo92.wav";
	public static double taxhowoften = 50.0;
	public static double taxrate = 0.28;
	public static boolean fullscreen = false;
	// --------------------------------------------
	public static double priceofegg = 0;
	public static int priceoffood = 0;
	public static int priceofhouse = 0;
	public static int priceofrc = 0;
	public static int priceoffarm = 0;
	public static int priceofland = 0;
	public static int priceofchicken = 0;
	// -------------------------------------------
	public static String[] land = new String[25];
	public static int[] chickens = new int[25];
	public static double money = 1000;
	public static int eggs = 0;
	public static int food = 0;
	public static int day = 1;
	public static int chickenlimit = 10;
	public static int foodproduction = 10;
	public static int foodcap = 1000;
	public static int eggcap = 500;
	public static boolean mute = false;
}