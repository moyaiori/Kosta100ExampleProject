public class ShapeApp {
	public static void main(String[] args)	{
		System.out.println("----------도형정보 출력----------");
		System.out.println();
		//System.out.println("----------기본그리기 출력--------");
		/*
		Shape shape = new Shape(10, 10);
		System.out.println(shape);
		shape.draw();
		//System.out.println("shape.getLength : " + shape.getLength());
		//System.out.println("shape.getLength : " + shape.getArea());
		System.out.println("기본 그리기 둘레 : " + shape.getLength());
		System.out.println("기본 그리기 면적 : " + shape.getArea());
		*/
		System.out.println("---------원그리기 출력---------");
		Shape shape = new Circle(9.0, 9.0, 3.0);
		shape.draw();
		System.out.println("원 그리기 둘레 : " + shape.getLength());
		System.out.println("원 그리기 면적 : " + shape.getArea());
		System.out.println();

		System.out.println("--------사각형그리기 출력------");
		shape = new Lectangle(8.0, 8.0, 5.0, 5.0);
		shape.draw();
		System.out.println("사각형 그리기 둘레 : " + shape.getLength());
		System.out.println("사각형 그리기 면적 : " + shape.getArea());
	}
}
