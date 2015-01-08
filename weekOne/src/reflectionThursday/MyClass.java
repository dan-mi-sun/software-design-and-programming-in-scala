package reflectionThursday;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClass {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Pretty: ");
			String cl = sc.next();
			try {
				Class<?> c = Class.forName(cl);
				Object obj = c.newInstance();
				System.out.println(obj);
//				System.out.println(c);
//				Method[] m = c.getDeclaredMethods();
//				for (Method meth : m)
//					System.out.println(meth);
				// get setName method
				Method m = null;
				try {
					m = c.getMethod("setName",
							new Class[]{String.class});
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Object result= m.invoke(obj, new Object[]{"James"});
				} catch (IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(obj);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.err.println("oh no, it has all gone wrong [" + e + "]");
				// e.printStackTrace();
			}
		}
	}
}