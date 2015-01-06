import java.util.Scanner;

/*
 * Write a program that reads the coordinates of the two points defining a square and then the coordinates of a third point. 
 * The program must first determine whether the square is actually square and then determine whether the third point falls 
 * inside, or outside of, the square.
 */
public class Square {
	private Point p1, p2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point p1 = getPoint(sc);
		Point p2 = getPoint(sc);
		Square sq = new Square(p1, p2);
		Point p3 = getPoint(sc);
		System.out.println("The square includes the point? " + sq.includes(p3));
	}

	public Square(Point p1, Point p2) {
		int xlength = Math.abs(p1.getX() - p2.getX());
		int ylength = Math.abs(p1.getY() - p2.getY());
		if (xlength != 0 && xlength == ylength) {
			this.p1 = p1;
			this.p2 = p2;
		} else {
			System.out.println("Not a square!");
			System.exit(-1);
		}
	}
 
	public boolean includes(Point p){
		return (p1.getX() <= p.getX()) && (p.getX() <= p2.getX()) && (p1.getY() <= p.getY()) && (p.getY() <= p2.getY());
	}
	
	private static Point getPoint(Scanner sc) {
		System.out.print("x = ");
		int x = sc.nextInt();
		System.out.print("y = ");
		int y = sc.nextInt();
		return new Point(x, y);
	}
}

class Point {
	private int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	public String toString() {
		return "x = " + x + ", y = " + y;
	}
}