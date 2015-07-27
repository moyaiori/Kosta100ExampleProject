//import java.util.EmptyStackException;
//
///**
// * 실기면접에서 출제되었던 문제
// * LIFO 구조의 스택(Stack)을 Java 언어로 구현하세요. 
// */
//public class Stack {
//	
//	private Object[] elements;
//	private int top;
//	
//	/** 디폴트 생성자 */
//	public Stack(){
//		this(10);
//	}
//	public Stack(int capacity){
//		elements = new Object[capacity];
//		top = -1;
//	}
//	
//	public int size(){
//		return top + 1;
//	}
//	
//	public boolean isEmpty(){
//		return top == -1;
//	}
//	
//	public void push(Object object){
//		// 용량이 꽉 찾을 경우.. 배열 복사
//		if(size() == elements.length){
//			Object[] array = new Object[elements.length * 2];
//			for(int i=0; i<elements.length; i++){
//				array[i] = elements[i];				
//			}
//			elements = array;
//		}
//		//top++;
//		elements[++top] = object;
//	}
//	
//	public Object pop(){
//		Object ret = null;
//		if(isEmpty()){//stack이 비어있을 경우..
//			//return ret;
//			throw new EmptyStackException();
//		}
//		ret = elements[top];
//		elements[top] = null;
//		top--;
//		return ret;
//	}
//	
//	// 테스트용 메인
//	public static void main(String[] args) {
//		Stack stack = new Stack(5);
//		System.out.println(stack.isEmpty());
//		System.out.println(stack.size());
//		
//		stack.push("AAAA");		
//		stack.push("BBBB");		
//		stack.push("CCCC");	
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		System.out.println(stack.pop());
//	}
//}
//
