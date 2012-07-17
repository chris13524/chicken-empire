package game;

public class Market {
	public void market() {
		Sharedvars.priceofegg = methods.random(10,20)/100.0;
		System.out.println("price of egg = " + Sharedvars.priceofegg);
		Sharedvars.priceofhouse = methods.random(120, 150);
		System.out.println("price of house = " + Sharedvars.priceofhouse);
		Sharedvars.priceoffarm = methods.random(420,450);
		System.out.println("price of farm = " + Sharedvars.priceoffarm);
		Sharedvars.priceofrc = methods.random(620, 650);
		System.out.println("price of reser = " + Sharedvars.priceofrc);
		Sharedvars.priceofland = methods.random(420, 450);
		System.out.println("price of land = " + Sharedvars.priceofland);
		Sharedvars.priceoffood = methods.random(1, 10);
		System.out.println("price of food = " + Sharedvars.priceoffood);
		Sharedvars.priceofchicken = methods.random(10, 20);
		System.out.println("price of chicken = " + Sharedvars.priceofchicken);
	}
}
