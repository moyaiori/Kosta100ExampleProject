public class FamilyExample {
	public static void main(String[] args)	{
		Family father;
		father = new Family("�ƺ�","�̱���",45);
		Family mother = new Family("����","�豤��",40);

		String etc = Family.telephone + "\t" + Family.address;

		System.out.println(father.toString() + "\t" + etc);
		System.out.println(mother.toString() + "\t" + etc);

		Family.openDoor();
	}
}
