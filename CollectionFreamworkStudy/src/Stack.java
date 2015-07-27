/**
 * 
 * @author Lee Gwangyong
 *
 */
public class Stack {
	private Object[] array;
	public int top;
	
	public Stack(){
		array = new Object[10];
		top = 0;
	}
	
	// 배열 크기
	public int size(){
		int count = 0;
		for (int i = 0; i < array.length; i++) {
//			System.out.println("array[i] : " + array[i] + "\t count : " + count);
			if (array[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	//비었는지 확인
	public boolean isEmpty(){
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				count++;
			}
		}
		if (count <= 0) {
			return true;
		}
		return false;
	}
	
	//값 넣기
	public void push(Object object){
		array[top] = object;
		top++;
	}
	
	//제거하면서 가져오기
	public Object pop(){
		if (top > 0) {
			array[top] = null;
			top--;
			return array[top];
		}
		return null;
	}
	
	public void viewStack(){
		for (Object object : array) {
			if (object != null) {
				System.out.println(object);
			}
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.size();
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
		
//		System.out.println("-1-");
//		stack.viewStack();
//		System.out.println("top : " + stack.top);
		
//		System.out.println("-2-");
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println("-3-");
//		stack.viewStack();
//		stack.viewStack();
//		System.out.println("top : " + stack.top);
//		
//		System.out.println("-3-");
//		stack.viewStack();
//		System.out.println("top : " + stack.top);
//		
//		System.out.println("-4-");
//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
//		System.out.println("top : " + stack.top);
	}

}
