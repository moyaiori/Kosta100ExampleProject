/**
 * 기본 데이터타입 배열 선언, 생성, 초기화
 */
public class ArrayExample {
	public static void main(String[] args)	{
		int[] array;
		array = new int[10];
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;

		array[9] = 100;
		
		System.out.println(array[0]);
		System.out.println(array[9]);
		// 배열의 사이즈
		
		System.out.println(array.length);

		for (int i=0; i < array.length ; i++){
			System.out.print(array[i] + "\t");
		}

		// 선언, 생성, 초기화를 한방에
		//int[] array2 = new int[]{0, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9}
		int[] array2 = {0, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9};

		System.out.println();
		for (int i=0; i < array2.length ; i++){
			System.out.print(array2[i] + "\t");
		}

		// 다차원 배열
		int[][] array3;
		array3 = new int[2][3];
		
		array3[0][0] = 10;
		array3[0][1] = 20;
		array3[0][2] = 30;

		array3[1][0] = 40;
		array3[1][1] = 50;
		array3[1][2] = 60;
		System.out.println();

		for (int i = 0; i < array3.length ; i++){
			for (int j = 0; j < array3[i].length ; j++){
				System.out.println(array3[i][j]);
			}
				System.out.println();
		}

		// 한방에
		int[][] array4 = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		for (int i = 0; i < array4.length ; i++){
			for (int j = 0; j < array4[i].length ; j++){
				System.out.println(array4[i][j]);
			}
			System.out.println();
		}

		// 아스키코드 관리
		char[] asciis = new char[128];
		
		for (int i = 0; i < asciis.length ; i++ ){
			asciis[i] = (char)i;
			System.out.print(i + "(" + asciis[i] + "), ");
		}
		
	}
}
