package ko.or.kosta.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class BufferedWriterExample {

	public static void main(String[] args) throws IOException {
		String filePath = "temp.txt";
		File file = new File(filePath);
		Writer writer = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(writer);
		
		bw.write('이');
		bw.newLine();
		bw.write('광');
		bw.newLine();
		bw.write('용');
		
		char[] chars = {'바','보',};
		bw.write(chars, 0, 2);
		
		bw.write("조금 쉬었다 합시다");
		
		bw.close();

	}

}
