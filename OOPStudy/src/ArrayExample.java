/**
 * �⺻ ������Ÿ�� �迭 ����, ����, �ʱ�ȭ
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
		// �迭�� ������
		
		System.out.println(array.length);

		for (int i=0; i < array.length ; i++){
			System.out.print(array[i] + "\t");
		}

		// ����, ����, �ʱ�ȭ�� �ѹ濡
		//int[] array2 = new int[]{0, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9}
		int[] array2 = {0, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9};

		System.out.println();
		for (int i=0; i < array2.length ; i++){
			System.out.print(array2[i] + "\t");
		}

		// ������ �迭
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

		// �ѹ濡
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

		// �ƽ�Ű�ڵ� ����
		char[] asciis = new char[128];
		
		for (int i = 0; i < asciis.length ; i++ ){
			asciis[i] = (char)i;
			System.out.print(i + "(" + asciis[i] + "), ");
		}
		
	}
}
