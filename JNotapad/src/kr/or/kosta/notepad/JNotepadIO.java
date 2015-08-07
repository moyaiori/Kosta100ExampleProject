package kr.or.kosta.notepad;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JNotepadIO {

	File stringFile;		 /** 문자열을 받아서 저장할 파일객체*/
	DataOutputStream dout;	 /** 출력 객체 */
	BufferedReader br;		 /** 리더 객체*/
	
	/**
	 * 문자열을 받아서 파일객체로 반환
	 */
	public void stringToFile(String text, File file){
		try {
			dout = new DataOutputStream(new FileOutputStream(file));
			dout.writeUTF(text);
//			writer = new FileWriter(file);
//			writer.write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 파일을 읽어서 문자열로 출력
	 * @param file
	 * @return
	 */
	public String fileToString(File file){
		StringBuffer resultBuffer = new StringBuffer();
		String result = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while((result = br.readLine()) != null){
				System.out.println(result);
				resultBuffer.append(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result = resultBuffer.toString();
		return result;
	}
}
