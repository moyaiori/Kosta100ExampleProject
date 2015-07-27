public class Circle extends Shape {
	private double radian;

	public Circle(){
		this(0.0, 0.0, 0.0);
	}
	
	public Circle(double x, double y, double radian){
		this.x = x;
		this.y = y;
		this.radian = radian;
	}

	public void draw(){
		System.out.println("x : " + x + "\t y : " + y + "\t radian : " + radian);
	}

	public double getLength(){
		return radian * 2 * Math.PI;
	}

	public double getArea(){
		return Math.pow(radian, 2) * Math.PI;
	}
}
