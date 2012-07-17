package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class methods {
	static Clip clip;
	public static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
	public static void selleggs(){
		Sharedvars.money = Sharedvars.money
				+ (Sharedvars.eggs / 12) * 12
				* Sharedvars.priceofegg;
		Sharedvars.eggs = Sharedvars.eggs - (Sharedvars.eggs / 12)
				* 12;
	}
	public static void buyfood(){
		if (hasEnoughMoney(Sharedvars.priceoffood)) {
			Sharedvars.money = Sharedvars.money
					- Sharedvars.priceoffood;
			Sharedvars.food = Sharedvars.food + 100;
		}
	}
	public static boolean hasEnoughMoney(int purchaseprice) {
		return Sharedvars.money - purchaseprice >= Sharedvars.blimit;
	}
	public static void playSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(Sharedvars.song)
					.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			System.out.println("Loop music");
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	public static boolean iswhole(double n){
		if(n == Math.floor(n)){
			return true;
		}else{
			return false;
		}
	}
	public static double roundmoney(double a){
		return Math.floor(a*100)/100;
	}
}
