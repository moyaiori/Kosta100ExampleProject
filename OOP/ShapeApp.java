public class ShapeApp {
	public static void main(String[] args)	{
		System.out.println("----------�������� ���----------");
		System.out.println();
		//System.out.println("----------�⺻�׸��� ���--------");
		/*
		Shape shape = new Shape(10, 10);
		System.out.println(shape);
		shape.draw();
		//System.out.println("shape.getLength : " + shape.getLength());
		//System.out.println("shape.getLength : " + shape.getArea());
		System.out.println("�⺻ �׸��� �ѷ� : " + shape.getLength());
		System.out.println("�⺻ �׸��� ���� : " + shape.getArea());
		*/
		System.out.println("---------���׸��� ���---------");
		Shape shape = new Circle(9.0, 9.0, 3.0);
		shape.draw();
		System.out.println("�� �׸��� �ѷ� : " + shape.getLength());
		System.out.println("�� �׸��� ���� : " + shape.getArea());
		System.out.println();

		System.out.println("--------�簢���׸��� ���------");
		shape = new Lectangle(8.0, 8.0, 5.0, 5.0);
		shape.draw();
		System.out.println("�簢�� �׸��� �ѷ� : " + shape.getLength());
		System.out.println("�簢�� �׸��� ���� : " + shape.getArea());
	}
}
