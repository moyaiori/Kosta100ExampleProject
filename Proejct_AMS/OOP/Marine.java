public class Marine extends Unit {

	public Marine(){
		this(15, null);
	}
	public Marine(int energy, Weapon weapon){
		this.energy = energy;
		this.weapon = weapon;
	}
	
	public void attack(){
		weapon.attack();
	}

	public void decrease(){
		energy -= 2;
		if(energy <= 0){
			System.out.println("마린 사망");
		}
		System.out.println("마린의 현재 에너지 : " + energy);
	}
}
