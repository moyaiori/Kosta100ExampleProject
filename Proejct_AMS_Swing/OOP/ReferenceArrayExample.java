/**
 * 래퍼런스 타입 배열 선언, 생성, 초기화
 */
public class ReferenceArrayExample {


	public static void main(String[] args)	{
		//학생 이름 목록 관리
		String[] names;
		names = new String[26];

		names[0] = "이광용";
		names[1] = "박래빈";
		names[2] = "가승훈";
		names[3] = "조현빈";
		names[4] = "김준기";
		names[25] = "송지현";

		for (int i = 0; i < names.length ; i++ ){
			System.out.println(i + ":" + names[i] + "\t");
		}
	}
}
