package ko.or.kosta.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 문자스트림 : 2바이트 단위 입출력
 * @author Lee Gwangyong
 *
 */
public class FileWriterExample {

	public static void main(String[] args) throws IOException{
		String filePath = "temp.txt";
		File file = new File(filePath);
		Writer writer = new FileWriter(file);
		writer.write('이');
		writer.write('광');
		writer.write('용');
		
		char[] chars = {'바','보',};
		writer.write(chars, 0, 2);
		
		writer.write("조금 쉬었다 합시다");
		
		writer.close();

	}

}
