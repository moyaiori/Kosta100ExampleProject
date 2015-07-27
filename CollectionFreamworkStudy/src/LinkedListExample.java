import java.util.LinkedList;

/**
 * FIFO 구조
 * @author Lee Gwangyong
 *
 */
public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<String> linkedLisk = new LinkedList<String>();
		linkedLisk.offer("AAAA");
		linkedLisk.offer("BBBB");
		linkedLisk.offer("CCCC");

		System.out.println(linkedLisk.poll());
		System.out.println(linkedLisk.poll());
		System.out.println(linkedLisk.poll());
		System.out.println(linkedLisk.size());
	}
}
