public class Lectangle extends Shape {
	private double width, height;

	public Lectangle(){
		this(0.0,0.0,0.0,0.0);
	}
	public Lectangle(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(){
		System.out.println("x : " + x + "\t y : " + y + "\t width : " + width + "\t height : " + height);
	}

	public double getLength(){
		return (width * 2) + (height * 2);
	}

	public double getArea(){
		return width * height;
	}
}
