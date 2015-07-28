package kr.or.kosta.project.bin;
import kr.or.kosta.project.SomeClass;
//import ko.or.kosta.project.*;
public class MyApp {
	public static void main(String[] args)	{

		SomeClass obj = new SomeClass();

		// 인라인 임포트
		//kr.or.kosta.project.SomeClass obj = new kr.or.kosta.project.SomeClass();
		
		obj.show();

	}
}
