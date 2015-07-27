public class SCV extends Unit {

	public SCV(){
		this(10, null);
	}
	public SCV(int energy, Weapon weapon){
		this.energy = energy;
		this.weapon = weapon;
	}

	public void attack(){
		//System.out.println("�帱�� ����");
		weapon.attack();
	}
	
	public void decrease(){
		energy--;
		if(energy <= 0){
			System.out.println("SCV ���");
		}
		System.out.println("SCV�� ���� ������ : " + energy);
	}

	public void work(){
		System.out.println("�̳׶��� ĸ�ϴ�.");
	}
}
