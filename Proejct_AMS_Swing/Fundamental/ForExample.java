class ForExample {
	public static void main(String[] args)	{

		for (int i = 0; i <= 100 ; i++)
		{
			//System.out.println("반복문입니다 : " + i);
		}
		System.out.println();

		int sum = 0;
		for (int i = 0; i<= 100 ; i++)
		{
			sum += i;
		}
		System.out.println(sum);

		for (int i = 0, j = 10; i < 10 ;i++, j += 2 )
		{
			System.out.println("i = " + i + " j = " + j);
		}
	}
}
