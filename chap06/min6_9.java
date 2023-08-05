import java.util.Scanner;

class Player {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Player(String name) {
        this.name = name;
    }

    public int getChoice() {
    	Scanner sc = new Scanner(System.in);
		System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
		return sc.nextInt();
    }
}
class Computer extends Player {
    Computer(String name) {
        super(name);
    }
    @Override
    public int getChoice() {
        // Random number generation for choices between 1 and 3 (inclusive)
        return (int) (Math.random() * 3 + 1);
    }
}

class Game {
    String gbb[] = { "가위", "바위", "보" };
    Player[] player = new Player[2];
    Scanner sc = new Scanner(System.in); // Scanner 객체를 멤버 변수로 선언

    Game() {
        player[0] = new Player("철수");
        player[1] = new Computer("컴퓨터");
    }
    public void run() {
    	 int userChoice;
         int computerChoice;
        while (true) {
        	userChoice = player[0].getChoice();
        	
        	if (userChoice == 4) {
                break;
            } 
            else if(userChoice<1 || 4<userChoice)
				System.out.println("잘못된 입력");
            
            computerChoice = player[1].getChoice();
            System.out.println(player[0].getName()+"(" + gbb[userChoice - 1] + ") : "+player[1].getName()+"(" + gbb[computerChoice - 1] + ")");           
            
            if (userChoice == computerChoice) {
                System.out.println("비겼습니다.");
            } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1)
                    || (userChoice == 3 && computerChoice == 2)) {
                System.out.println("철수가 이겼습니다.");
            } else {
                System.out.println("컴퓨터가 이겼습니다.");
            }
            
        }
    }
}

public class min6_9 {
    public static void main(String[] args) {
        Game g = new Game();
        g.run();
    }
}
