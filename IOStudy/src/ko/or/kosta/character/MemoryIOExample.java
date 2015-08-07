package ko.or.kosta.character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryIOExample {
	public static void main(String[] args) throws IOException {
		String message = "동해물과 백두산이 마르고";
		StringReader sr = new StringReader(message);
		BufferedReader br = new BufferedReader(sr);
		String txt = br.readLine();
		System.out.println(txt);
	}
}
