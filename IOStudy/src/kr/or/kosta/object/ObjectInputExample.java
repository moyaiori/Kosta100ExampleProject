package kr.or.kosta.object;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class ObjectInputExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		boolean flag;
		int age;
		double weight;
		String message;
		Calendar today;
		Frame frame;
		
		Account account;
		
		FileInputStream fis = new FileInputStream("ObjectSample.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		flag = (boolean) ois.readObject();
		age = (int) ois.readObject();
		weight = (double) ois.readObject();
		message = (String) ois.readObject();
		today = (Calendar) ois.readObject();
		frame = (Frame) ois.readObject();
		account = (Account) ois.readObject();
		List<Account> list = (List<Account>) ois.readObject();
		
		
		ois.close();
		System.out.println(flag);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		System.out.println(today);
		
		frame.setVisible(true);
		
		for (Account a : list) {
			System.out.println(a);
		}
		
		System.out.println(account);

	}

}
