package chap05;

import java.util.Scanner;

abstract class Shape1{
	private Shape1 next;
	public Shape1() { next = null; }
	public void setNext(Shape1 obj) { next = obj; }
	public Shape1 getNext() { return next; }
	public abstract void draw();
}

class Line extends Shape1{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Line");
	}
	
}

class Rect1 extends Shape1{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rect");
	}
	
}

class Circle1 extends Shape1{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle");
	}
	
}

class GraphicEditor{
	Scanner sc = new Scanner(System.in);
	private Shape1 head = null;
	private Shape1 tail = null;
	
	public GraphicEditor() { }
	
	public void run() {
		System.out.println("그래픽 에디터를 실행합니다.");
		while(true) {
			System.out.print("삽입(1) 삭제(2) 모두 보기(3) 종료(4) >>> ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("Line(1) Rect(2) Circle(3)  >>> ");
				int n = sc.nextInt();
				insert(n);
				break;
			case 2:
				System.out.print("삭제할 도형의 위치 >>> ");
				int m = sc.nextInt();
				delete(m);
				break;
			case 3:
				print();
				break;
			case 4:
				System.out.println("종료합니다");
				break;
			}
		}
	}
	
	public void insert(int n) {
		Shape1 shape = null;
		switch(n) {
		case 1:
			shape = new Line();
			break;
		case 2:
			shape = new Rect1();
			break;
		case 3:
			shape = new Circle1();
			break;
		}
		
		if(head == null) {
			head = shape;
			tail = head;
		}
		else {
			tail.setNext(shape);
			tail = shape;
		}
		
	}
	
	public void delete(int delNum) {
		Shape1 current = head;	// 현재 노드
		Shape1 temp = head;
		int i;
		if(delNum == 1) {	// 첫번째 노드를 삭제할 때
			if(head == tail) {	// 노드가 한개일 때
				head = null;
				tail = null;
				return;
			} else {	// 노드가 두개 이상일 때
				head = head.getNext();
				return;
			}
		}
		for(i = 1; i < delNum; i++) {
			temp = current;	// 현재 노드를 저장
			current = current.getNext();	// 다음 노드로 이동
			if(current == null) {	// 노드 수가 입력 값보다 적을 때
				System.out.println("삭제할 수 없습니다.");
				return;
			}
		}
		if(i == delNum) {	// 마지막 노드일 때
			temp.setNext(current.getNext());
			tail = temp;
		} else	// 마지막 노드가 아니면 이전 노드가 다음 노드를 가리킨다.
			temp.setNext(current.getNext());

	}
	
	public void print() {
		Shape1 shape = head;
		while(shape != null) {
			shape.draw();
			shape = shape.getNext();
		}
	}
}

public class In_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicEditor g = new GraphicEditor();
		g.run();

	}

}
