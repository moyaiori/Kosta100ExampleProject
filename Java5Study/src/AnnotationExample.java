
public class AnnotationExample {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Deprecated
	public void oldMethod() {
		// 사용하지않는 메소드
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationExample exam = new AnnotationExample();
		exam.oldMethod();

	}

}
