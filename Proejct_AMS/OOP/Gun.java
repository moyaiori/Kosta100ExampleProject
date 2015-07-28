/**
 * Weapon 규약에 따라 구현 하는  클래스
*/
public class Gun implements Weapon {

	public void attack(){
		System.out.println("두두두 공격한다");
	}

	public static void main(String[] a){
		Weapon weapon = new Gun();
		weapon.attack();
	}
}
