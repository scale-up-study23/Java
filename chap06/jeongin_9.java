package chap06;

import java.util.Scanner;

class Player{
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int select() {
		Scanner sc = new Scanner(System.in);
		System.out.print(name + " [가위(1) 바위(2) 보(3) 끝내기(4) >> ");
		int num = sc.nextInt();
		return num;
	}
}

class Computer extends Player{
	public Computer(String name) {
		super(name);
	}
	
	public int select(){
		return (int) (Math.random() * 3 + 1);
	}
}

class Games{
	private String[] game = {"가위", "바위", "보"};
	Player[] player = new Player[2];
	
	public Games() {
		player[0] = new Player("철수");
		player[1] = new Computer("컴퓨터");
	}
	
	public void run() {
		int playerNum, computerNum;
		
		while(true) {
			playerNum = player[0].select();
			if(playerNum < 1 || playerNum > 4)
				System.out.println("잘못 입력했습니다.");
			else if(playerNum == 4)
				break;
			
			computerNum = player[1].select();
			
			System.out.print(player[0].getName() + "(" + playerNum + ") ");
			System.out.println(player[1].getName() + "(" + computerNum + ")");
			
			if(playerNum == computerNum)
				System.out.println("비겼습니다.");
			else if((playerNum == 1 && computerNum == 2) || (playerNum == 2 && computerNum == 3) || (playerNum == 3 && computerNum == 1))
				System.out.println(player[1].getName() + "가 이겼습니다.");
			else if((playerNum == 1 && computerNum == 3) || (playerNum == 2 && computerNum == 1) || (playerNum == 3 && computerNum == 2))
				System.out.println(player[0].getName() + "가 이겼습니다.");
		}
	}
	
}

public class jeongin_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Games game = new Games();
		game.run();

	}

}
