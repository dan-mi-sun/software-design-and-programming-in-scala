package demo;

public class Test {
	public String thing(final int val){
		boolean x = false;
		int i = 3;
		Integer j = i;
		int y = j;
		System.out.println();
		if (x == true && val == 1){
			System.out.println();
            return "" + val;
		}
		return null;
	}
}

// run PMD on this code with the java/optimizations ruleset to see the violations
// run FindBugs as well
