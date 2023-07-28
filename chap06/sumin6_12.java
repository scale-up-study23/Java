import java.util.Random;
import java.util.Scanner;
 
class human{
	String name;
	int r1,r2,r3;
	Scanner sc;
	public human(String name) {
		this.name=name;
		sc=new Scanner(System.in);
	}
	public boolean run() {
		System.out.print("["+name+"]:<Enter>");
		String enter=sc.nextLine();
		Random r=new Random();
		r.setSeed(System.currentTimeMillis());
		r1=r.nextInt(3)+1;
		r2=r.nextInt(3)+1;
		r3=r.nextInt(3)+1;
 
		System.out.print("\t"+r1+"\t"+r2+"\t"+r3+"\t");
		if(r1==r2&&r2==r3) {
			System.out.println(name+"���� �̰���ϴ�!");
			return true;
		}
		else {
			System.out.println("�ƽ�����!");
			return false;
		}
	}
}
 
public class sumin6_12{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("�׺� ���ӿ� ������ ���� ����>>");
		int n=sc.nextInt();
		human arr[]=new human[n];
		for(int i=0;i<n;i++) {
			System.out.print((i+1)+"��° ���� �̸�>>");
			String name=sc.next();
			arr[i]=new human(name);
		}
		boolean flag=true;;
		while(flag) {
			for(int i=0;i<n;i++) {
				if(arr[i].run()) {
					flag=false;
					break;
				}
			}
		}
	}
}