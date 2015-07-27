/**
 * 배열 관련 공통 기능
 */
public class ArrayUtil {
	/**
	 * 오름차순 정렬
	 */
	 public static void sort(int[] array){

		 int temp1, temp2;
		 for (int i = 0; i < array.length; i++ ){
			for (int j = 0; j < array.length - 1 ; j++ ){
				temp1 = array[j];
				temp2 = array[j+1];
				if (temp2 < temp1){
					array[j] = temp2;
					array[j+1] = temp1;
				}
			}
		}
	 }

	public static void main(String[] args)	{
		
		int[] nums = {5, 7, 1, 9, 6, 3, 2, 8, 4};
		ArrayUtil.sort(nums);

		for (int i = 0; i < nums.length ; i++){
			System.out.print(nums[i] + "\t");
		}
	}
}
