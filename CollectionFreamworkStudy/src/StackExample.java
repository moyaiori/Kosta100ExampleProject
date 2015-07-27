import java.util.Calendar;
import java.util.Random;
import java.util.Stack;

/**
 * LIFO STACK
 * @author Lee Gwangyong
 *
 */
public class StackExample {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("이광용");
		stack.push(new Integer(100));
		stack.push(Calendar.getInstance());
		stack.push(new Random());
		
		Object obj = stack.pop();
		System.out.println(obj);
		obj = stack.pop();
		System.out.println(obj);
		int i = stack.search("이광용");
		System.out.println(i);
		
		Stack<Double> stack2 = new Stack<Double>();
		
	
	}

}
