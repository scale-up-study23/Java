package chap05;

import java.util.Scanner;

abstract class Calc1 {
	protected int a, b;

	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	abstract int calculate();
}

class Add1 extends Calc1 {
	@Override
	public int calculate() {
		return a + b;
	}
}

class Sub1 extends Calc1 {
	
	@Override
	int calculate() {
		// TODO Auto-generated method stub
		return a-b;
	}	
}

class Mul1 extends Calc1{

	@Override
	int calculate() {
		// TODO Auto-generated method stub
		return a*b;
	}
}

class Div1 extends Calc1{

	@Override
	int calculate() {
		// TODO Auto-generated method stub
		return a/b;
	}	
}

public class In_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		String op = sc.next();
		
		Calc1 cal = null;
		switch(op) {
		case "+":
			cal = new Add1();
			break;
		case "-":
			cal = new Sub1();
			break;
		case "*":
			cal = new Mul1();
			break;
			
		case "/" :
			cal = new Div1();
			break;
		}
		
		cal.setValue(a, b);
		System.out.println(cal.calculate());
		
		sc.close();

	}

}
