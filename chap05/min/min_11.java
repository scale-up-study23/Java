import java.util.*;

abstract class Calc {
	int a;
	int b;
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	abstract int calculate(int a, int b);
}
class Add extends Calc{
	@Override
	int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
}
class Sub extends Calc{
	@Override
	int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}
}
class Mul extends Calc{
	@Override
	int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}
}
class Div extends Calc{
	@Override
	int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
}
public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Add a = new Add();
		Sub s = new Sub();
		Mul m = new Mul();
		Div d = new Div();
		System.out.print("두 정수와 연산자를 입력하시오>> ");
		int p = sc.nextInt();
		int q = sc.nextInt();
		String str = sc.next();
		
		if(str.equals("+")) {
			a.setValue(p, q);
			System.out.println(a.calculate(p, q));
		}
		else if(str.equals("-")) {
			s.setValue(p, q);
			System.out.println(s.calculate(p, q));
			
			}
		else if(str.equals("*")) {
			m.setValue(p, q);
			System.out.println(m.calculate(p, q));		}
		else if(str.equals("/")) {
			d.setValue(p, q);
			System.out.println(d.calculate(p, q));		}
		else
			System.out.println("잘못된 입력입니다.");
	}
}
