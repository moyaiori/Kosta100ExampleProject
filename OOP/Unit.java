public abstract class Unit {

	protected int energy;
	protected Weapon weapon;

	public void move(){
		System.out.println("������ �����Դϴ�.");
	}

	public abstract void attack();
	public abstract void decrease();
}
