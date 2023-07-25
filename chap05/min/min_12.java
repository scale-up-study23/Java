import java.util.*;

abstract class Shape {
	static int count = 0;
    static String[] shape = new String[100];

    public void paint() {
        for (int i = 0; i < count; i++) {
            System.out.println(shape[i]);
        }
    }

    abstract public void draw();

    public void delete(int index) {
        if (index < 1 || index > count) {
            System.out.println("삭제할 수 없습니다. 올바른 인덱스를 입력하세요.");
        } else {
            for (int i = index - 1; i < count - 1; i++) {
                shape[i] = shape[i + 1];
            }
            shape[count - 1] = null;
            count--;
            System.out.println("도형을 삭제했습니다.");
        }
    }
}

class Line extends Shape {
    @Override
    public void draw() {
        shape[count++] = "Line";
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        shape[count++] = "Rect";
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        shape[count++] = "Circle";
    }
}

public class GraphicEditor {

    public static void main(String[] args) {
        Line l = new Line();
        Rect r = new Rect();
        Circle c = new Circle();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("그래픽 에디터 beauty를 실행합니다.");
        while (choice != 4) {
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)>>");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            l.draw();
                            break;
                        case 2:
                            r.draw();
                            break;
                        case 3:
                            c.draw();
                            break;
                    }
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>>");
                    int index = sc.nextInt();
                    l.delete(index);
                    break;
                case 3:
                    l.paint();
                    break;
                case 4:
                    System.out.println("beauty를 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
        sc.close();
    }
}
