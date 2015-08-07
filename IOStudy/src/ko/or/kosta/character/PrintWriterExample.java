package ko.or.kosta.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;

import javax.management.BadBinaryOpValueExpException;

/**
 * 문자스트림 : 2바이트 단위 입출력 문자디코딩 처리된 문자스트림
 * 
 * @author Lee Gwangyong
 *
 */
public class PrintWriterExample {

	public static void main(String[] args) throws IOException {
		String filePath = "temp.txt";
		File file = new File(filePath);
		PrintWriter pw = new PrintWriter(file);
		
		pw.println(true);
		pw.println(10);
		pw.println();
		pw.println(35.6);
		pw.println("이광용");
		pw.printf("%1$tF", Calendar.getInstance());
		
		pw.close();
		
	}

}
