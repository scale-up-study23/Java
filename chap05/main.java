import java.util.*;

interface Shape{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- �ٽ� �׸��ϴ�.");
		draw();
	}
}

class Circle implements Shape{
	public int r = 0;
	public Circle(int c) {
		this.r = c;		
	}
	@Override
	public void draw() {
		System.out.println("�������� "+this.r+"�� ���Դϴ�.");
	}
	@Override
	public double getArea() {		
		return PI*r*r;
	}
}

public class main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Shape donut = new Circle(5);
		donut.redraw();
		System.out.println("������ " + donut.getArea());
	}	
}