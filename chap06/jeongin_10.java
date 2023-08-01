package chap06;

import java.util.Scanner;

class Person{
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void turn() {
		System.out.print("[" + name + "] : <Enter>");
	}
	
	public boolean randomNum() {
		int num[] = new int[3];
		boolean win = true;
		
		for(int i=0; i<num.length; i++) {
			num[i] = (int) (Math.random() * 3 + 1);
			System.out.print(num[i] + " ");
		}
		
		for(int i=0; i<num.length; i++) {
			if(num[0] != num[i]){
				win = false;
				break;
			}
		}
		return win;
	}
}

class Game{
	Scanner sc = new Scanner(System.in);
	Person[] person = new Person[2];
	
	public Game() {
		for(int i=0; i<person.length; i++) {
			System.out.print((i+1) + "번째 선수 이름 >> ");
			person[i] = new Person(sc.next()); 
		}
	}
	
	public void run() {
		while(true) {
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

public class jeongin_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.run();

	}

}
