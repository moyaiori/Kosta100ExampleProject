public class StarCraft {
	public static void main(String[] args)	{
		Weapon weapon = new Drill();
		Unit unit = new SCV(10, weapon);
		unit.move();
		unit.attack();
		unit.decrease();

		weapon = new Gun();
		unit = new Marine(15, weapon);
		unit.move();
		unit.attack();

		SCV scv = new SCV();
		scv.work();

	}
}
