class IfExample {
	public static void main(String[] args)	{

		int num = 56;
		

		if ((num % 2) == 0) {
			System.out.println(num + "�� ¦��");

		} else {
			System.out.println(num + "�� Ȧ��");
		}

		int score = 89;
		String grade;

		if(score >= 90){
			grade= "��";
		}else if(score >= 80){
			grade= "��";
		}else if(score >= 70){
			grade= "��";
		}else if(score >= 60){
			grade= "��";
		}else{
			grade= "��";
		}

		System.out.println("\"" + grade + "\" �Դϴ�.");
	}
}
