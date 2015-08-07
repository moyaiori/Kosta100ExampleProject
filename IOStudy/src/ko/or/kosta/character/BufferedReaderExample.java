package ko.or.kosta.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.management.BadBinaryOpValueExpException;

/**
 * 문자스트림 : 2바이트 단위 입출력 문자디코딩 처리된 문자스트림
 * 
 * @author Lee Gwangyong
 *
 */
public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		String filePath = "src/BufferedInputStreamExample.java";
		File file = new File(filePath);

		if (!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}

		Reader reader = new FileReader(file);
		
		BufferedReader br = new BufferedReader(reader);
		
//		String txt = br.readLine();
//		System.out.println(txt);
		
		String txt = null;
		int lineNumber = 0 ;
		while((txt = br.readLine()) != null){
			lineNumber++;
			System.out.println(lineNumber + " : " + txt);
		}
		br.close();
	}

}
