public class Example {
	private int[] position = { 1, 2, 3, 4, 5 };

	public int[] getPosition() {
		return (int[]) position.clone();
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int x : position)
			str.append("" + x + " ");
		str.append("]");
		return str.toString();
	}
	
	public void change(){
		position[0]=10;
	}

	public static void main(String[] args) {
		Example ex = new Example();
		System.out.println(ex);
		int[] arr = ex.getPosition();
		ex.change();
		for (int x : arr)
			System.out.print("" + x + " ");
		System.out.println();
		System.out.println(ex);
		arr = ex.getPosition();
		for (int x : arr)
			System.out.print("" + x + " ");
	}
}
