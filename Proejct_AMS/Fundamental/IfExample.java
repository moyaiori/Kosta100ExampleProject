class IfExample {
	public static void main(String[] args)	{

		int num = 56;
		

		if ((num % 2) == 0) {
			System.out.println(num + "은 짝수");

		} else {
			System.out.println(num + "은 홀수");
		}

		int score = 89;
		String grade;

		if(score >= 90){
			grade= "수";
		}else if(score >= 80){
			grade= "우";
		}else if(score >= 70){
			grade= "미";
		}else if(score >= 60){
			grade= "양";
		}else{
			grade= "가";
		}

		System.out.println("\"" + grade + "\" 입니다.");
	}
}
