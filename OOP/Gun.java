/**
 * Weapon �Ծ࿡ ���� ���� �ϴ�  Ŭ����
*/
public class Gun implements Weapon {

	public void attack(){
		System.out.println("�εε� �����Ѵ�");
	}

	public static void main(String[] a){
		Weapon weapon = new Gun();
		weapon.attack();
	}
}
