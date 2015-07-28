class SwitchExample {
	public static void main(String[] args)	{

		int score = 72;
		String grade;

		switch (score / 10){
			case 10:
			case 9: grade = "A"; break;
			case 8: grade = "B"; break;
			case 7: grade = "C"; break;
			case 6: grade = "D"; break;
			default: grade = "F";
		}

		System.out.println("\"" + grade + "\" 학점 입니다.");

		System.out.println();
	}
}
