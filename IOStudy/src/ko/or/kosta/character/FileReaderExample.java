package ko.or.kosta.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 문자스트림 : 2바이트 단위 입출력
 * @author Lee Gwangyong
 *
 */
public class FileReaderExample {

	public static void main(String[] args) throws IOException{
		String filePath = "src/BufferedInputStreamExample.java";
		File file = new File(filePath);
		
		if(!file.exists()){
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		
		Reader reader = new FileReader(file);
		
//		int c = reader.read();
//		System.out.println(c);
//		System.out.println((char)c);
		/*
		int c = 0;
		while((c = reader.read()) != -1){
			System.out.print((char)c);
		}
		*/
		
		char[] buffer = new char[1024];
		
		
		int count = 0;
		while((count = reader.read(buffer)) != -1){
			String text = new String(buffer, 0, count);
			System.out.print(text);
		}
		
		reader.close();

	}

}
