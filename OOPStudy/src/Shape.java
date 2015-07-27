/**
 * ��� ������ ���� �Ӽ��� ����� ������ �߻�Ŭ����
 * �ڽ� Ŭ���� ���� �ݵ�� �����ؾ��� �޼ҵ忡 ���� �Ծ�
 */
public abstract class Shape {
	protected double x, y;

	// �߻� �޼ҵ�(������ �Ծ�)
	public abstract void draw();
	public abstract double getLength();
	public abstract double getArea();

	public String toString(){
		return "x : " + x + "\t y : " + y;
	}

}
