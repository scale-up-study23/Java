package chap06;

import java.util.Scanner;

class Person1{
	private String name;
	
	public Person1(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void turn() {
		System.out.print("[" + name + "]:<Enter> ");
	}
	
	public boolean randomNum() {
		boolean win = true;
		int num[] = new int[3];
		
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*3 +1);
			System.out.print(num[i] + " ");
		}
		
		for(int i=0; i<num.length;i++) {
			if(num[0] != num[i]){
				win = false;
				break;
			}
		}
		
		return win;
	}
}

class Game2{
	Person1 person[];
	Scanner sc = new Scanner(System.in);
	
	public Game2() {
		System.out.print("게임에 참여하는 인원 >> ");
		int n = sc.nextInt();
		person = new Person1[n];
		for(int i=0; i<person.length; i++) {
			System.out.print((i+1) + "번째 선수 이름 >> ");
			person[i] = new Person1(sc.next());
		}
		System.out.println();
	}
	
	public void run() {
		while(true){
			for(int i=0; i<person.length; i++) {
				sc.nextLine();
				person[i].turn();
				sc.nextLine();
				
				if(person[i].randomNum()) {
					System.out.print(person[i].getName() + "님이 이겼습니다!");
					return;
				}
				else
					System.out.println("아쉽군요!");
			}
		}
	}
	
}

public class jeongin_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game2 game = new Game2();
		game.run();

	}

}
