import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Vacter interface 수너가 있고, 중복을 허용하는 Collection
 * 
 * @author Lee Gwangyong
 *
 */
public class VectorExample {

	public static void main(String[] args) {
		// 동기화 처리된 리스트 Vacter
		// 주로 목록데이터 데이터 관리시 사용
		Vector<String> vector = new Vector(10, 2);
		
		vector.addElement("이광용");// 동기화 처리 되어있음
		vector.addElement("박래빈");// 메소드명에 엘리먼츠가 들어가있음녀 동기화 되어있는 경우가 많다
		vector.insertElementAt("박광용",0);
		vector.removeElementAt(vector.size() - 1);
		
		//전체리스트(동기화처리)
		Enumeration e = vector.elements();
		while(e.hasMoreElements()){
			Object obj = e.nextElement();
//			System.out.println("next"+e.nextElement());
			System.out.println("obj"+obj);
		}
		
		Vector<Integer> vector2 = new Vector<Integer>();
	}

}


















