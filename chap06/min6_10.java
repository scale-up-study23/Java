import java.util.*;

class Person {
	String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	Person(String name){
		this.name = name;
	}
}
class Game {
	int win = 0;
    Person[] p = new Person[2];
    int[] n = new int[3];
    
    public int random() {
        int n = (int) (Math.random() * 3);
        return n;
    }
    public boolean equals() {
    	win = 1;
        for (int j = 0; j < 3; j++) {
            n[j] = random();
            System.out.print(n[j] + "  ");
            if (j > 0) {
                if (n[j] != n[j - 1]) {
                    win = 0;
                }
            }
        }
        if (win == 1) {
        	return true;
        }
        else
        	return false;
    }

    public void run() {
        
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print((i + 1) + "번째 선수 이름>>");
            String name = sc.nextLine();
            p[i] = new Person(name);
        }
        while (true) {
            for (int i = 0; i < 2; i++) {
                System.out.print("[" + p[i].getName() + "]:<Enter>");
                sc.nextLine();                
                System.out.print("    ");
                if (equals()) {
                    System.out.println(p[i].getName() + "님이 이겼습니다!");
                    return; 
                } else
                    System.out.println("아쉽군요!");
            }
        }
    }
}

public class min6_10 {
    public static void main(String[] args) {
        Game g = new Game();
        g.run();
    }
}