package kr.or.kosta.object;

import java.awt.Frame;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 객체를 파일에 쓰기
 * @author Lee Gwangyong
 *
 */
public class ObjectOutputExample {

	public static void main(String[] args) throws IOException {
		
		boolean flag = true;
		int age = 30;
		double weight = 20.5;
		String message = "요넘이 객체스트림입니다.";
		Calendar today = Calendar.getInstance();
		Frame frame = new Frame("프레임입니다.");
		frame.setSize(500, 500);
		
		Account account = new Account("1111-2222", "이광용", 1234, 1000);
		
		FileOutputStream fos = new FileOutputStream("ObjectSample.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		// 오토박싱! 래퍼클래스 불린으로
		oos.writeObject(flag);
		oos.writeObject(age);
		oos.writeObject(weight);
		oos.writeObject(message);
		oos.writeObject(today);
		oos.writeObject(frame);
		
		if (account instanceof Serializable) {
			oos.writeObject(account);
		}else{
			System.out.println("직렬화가 되지않았습니다.");
		}
		
		//객체 목록 저장
		List<Account> list = new ArrayList<Account>();
		for (int i = 0; i < 30; i++) {
			Account acc = new Account((i+1)+"", "홍길동" + i, 1234, 5000 );
			list.add(acc);
		}
		
		oos.writeObject(list);
		
		oos.flush();
		oos.close();
		System.out.println("객체를 파일 출력 완료!!!");
		

	}

}
