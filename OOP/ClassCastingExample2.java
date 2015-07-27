public class ClassCastingExample2 {
	public static void main(String[] args)	{

		Shape shape = new Circle(10,10,5);
		shape.draw();

		shape = new Lectangle(10, 10, 5, 5);
		shape.draw();

		shape = new Circle(12,12,3);
		shape.draw();



		System.out.println();
	}
}
