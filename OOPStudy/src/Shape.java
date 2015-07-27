/**
 * 모든 도형의 공통 속성과 기능을 정의한 추상클래스
 * 자식 클래스 들이 반드시 구현해야할 메소드에 대한 규약
 */
public abstract class Shape {
	protected double x, y;

	// 추상 메소드(수직적 규약)
	public abstract void draw();
	public abstract double getLength();
	public abstract double getArea();

	public String toString(){
		return "x : " + x + "\t y : " + y;
	}

}
