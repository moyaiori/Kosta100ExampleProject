package ko.or.kosta.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 임의접근이 가능하고, 
 * 자바의 모든 데이터타입별 읽기&쓰기가 가능하고
 * 양방향 입출력이 가능한 입출력 유틸리티 클래스
 * 단, 파일 이불력에만 사용 가능하다.
 * @author Lee Gwangyong
 *
 */
public class RandomAccessFileExample {

	public static void main(String[] args) throws IOException {
		String filePath = "RAF.dat";
		RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
		long filesize = raf.length();
//		System.out.println(filesize);
		
		// 포인터 위치
		long pointer = raf.getFilePointer();
//		System.out.println(pointer);
		
		// 데이터 쓰기
		byte b = 10;
		char c = '용';
		int i = 150;
		double d = 1.12;
		String s = "랜덤엑세스파일 예제";
				
		raf.writeByte(b);
//		System.out.println(raf.getFilePointer());
		raf.writeChar(c);
		raf.writeInt(i);
		raf.writeDouble(d);
		raf.writeChars(s);
//		System.out.println(raf.getFilePointer());
		
		// 읽기 위해 포인터 위치를 처음으로
		raf.seek(0);
		System.out.println(raf.readByte());
		System.out.println(raf.readChar());
		System.out.println(raf.readInt());
		System.out.println(raf.readDouble());
//		System.out.println(raf.readUTF());
		System.out.println(raf.getFilePointer());
		
		// 파일을 쓰면 포인터가 이동한다.
		
		raf.close();

	}

}
