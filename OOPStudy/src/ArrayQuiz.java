public class ArrayQuiz {
	public static void main(String[] args)	{
		int[] nums = {5, 7, 1, 9, 6, 3, 2, 8, 4};

		// 정렬 출력
		System.out.println();//1, 2, ...... 10

		int temp1, temp2, temp3 = 0;

		for (int i = 0; i < nums.length; i++ ){
			for (int j = 0; j < nums.length - 1 ; j++ ){
				temp1 = nums[j];
				temp2 = nums[j+1];
				if (temp2 < temp1){
					nums[j] = temp2;
					nums[j+1] = temp1;
					temp3++;
				}
			}
		}

		for (int i =0 ; i < nums.length ; i++ )
		{
			System.out.println(nums[i]);
		}
		System.out.println(temp3);
	}
}
