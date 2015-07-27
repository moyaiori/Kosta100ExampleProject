public class SCV extends Unit {

	public SCV(){
		this(10, null);
	}
	public SCV(int energy, Weapon weapon){
		this.energy = energy;
		this.weapon = weapon;
	}

	public void attack(){
		//System.out.println("드릴로 공격");
		weapon.attack();
	}
	
	public void decrease(){
		energy--;
		if(energy <= 0){
			System.out.println("SCV 사망");
		}
		System.out.println("SCV의 현재 에너지 : " + energy);
	}

	public void work(){
		System.out.println("미네랄을 캡니다.");
	}
}
