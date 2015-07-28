public abstract class Unit {

	protected int energy;
	protected Weapon weapon;

	public void move(){
		System.out.println("유닛을 움직입니다.");
	}

	public abstract void attack();
	public abstract void decrease();
}
